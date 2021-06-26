import java.io.*;
import java.net.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ChatServer {

	protected int serverPort = 1234;
	protected List<Socket> clients = new ArrayList<Socket>(); // list of clients 
	protected HashMap<Socket, String> clientHash = new HashMap<Socket, String>();

	public static void main(String[] args) throws Exception {
		new ChatServer();
	}

	public ChatServer() {
		ServerSocket serverSocket = null;

		// create socket
		try {
			serverSocket = new ServerSocket(this.serverPort); // create the ServerSocket
		} catch (Exception e) {
			System.err.println("[system] could not create socket on port " + this.serverPort);
			e.printStackTrace(System.err);
			System.exit(1);
		}

		// start listening for new connections
		System.out.println("[system] listening ...");
		try {
			while (true) {
				Socket newClientSocket = serverSocket.accept(); // wait for a new client connection
				synchronized(this) {
					clients.add(newClientSocket); // add client to the list of clients
					setupClient(newClientSocket);
				}
				ChatServerConnector conn = new ChatServerConnector(this, newClientSocket); // create a new thread for communication with the new client
				conn.start(); // run the new thread
			}
		} catch (Exception e) {
			System.err.println("[error] Accept failed.");
			e.printStackTrace(System.err);
			System.exit(1);
		}

		// close socket
		System.out.println("[system] closing server socket ...");
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}

	// send a message to all clients connected to the server
	public void sendToAllClients(String message, Socket senderSocket) throws Exception {
		Iterator<Socket> i = clients.iterator();
		while (i.hasNext()) { // iterate through the client list
			Socket socket = (Socket) i.next(); // get the socket for communicating with this client
			if(socket != senderSocket){
				try {
					DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // create output stream for sending messages to the client
					out.writeUTF(message); // send message to the client
				} catch (Exception e) {
					System.err.println("[system] could not send message to a client");
					e.printStackTrace(System.err);
				}
			}
		}
	}

	public void sendToClient(String message, Socket clientSocket) throws Exception {
		try {
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream()); // create output stream for sending messages to the client
			out.writeUTF(message); // send message to the client
		} catch (Exception e) {
			System.err.println("[system] could not send message to a client");
			e.printStackTrace(System.err);
		}
	}

	public void removeClient(Socket socket) {
		synchronized(this) {
			clients.remove(socket);
		}
	}

	public void setupClient(Socket socket) {
		DataInputStream in;
		try {
			in = new DataInputStream(socket.getInputStream()); // create input stream for listening for incoming messages
		} catch (IOException e) {
			System.err.println("[system] could not open input stream!");
			e.printStackTrace(System.err);
			removeClient(socket);
			return;
		}

		String clientName;
		try {
			clientName = in.readUTF(); // read the message from the client
		} catch (Exception e) {
			System.err.println("[system] there was a problem while reading message client on port " + socket.getPort() + ", removing client");
			e.printStackTrace(System.err);
			removeClient(socket);
			return;
		}

		clientHash.put(socket, clientName);
	}

	public boolean checkForCommands(String msg, Socket senderSocket) {
		if(msg.charAt(0) == '/') {
			String command = "";
			String query = "";
			for (int i = 1; i < msg.length(); i++) {
				if(msg.charAt(i) == ' ') {
					command = msg.substring(1, i);
					query = msg.substring(i + 1);
					break;

				}else if(i + 1 == msg.length()) {
					command = msg.substring(1, msg.length());
					break;
				}
			}

			executeCommand(command, query, senderSocket);

			return true;
		}
		return false;
	}

	public void executeCommand(String command, String msg, Socket senderSocket) {
		boolean sendToUser = false;
		for (Socket soc : clients) {
			String user = clientHash.get(soc);
			if(user.equals(command)) {
				try {
					msg = "[" + clientHash.get(senderSocket) + " -> " + user + "]: " + msg;
					sendToClient(msg, soc);
					sendToUser = true;
				} catch (Exception e) {
					System.err.println("[system] could not send msg to client");
				}
				break;
			}
		}

		if(!sendToUser) {
			try {
				sendToClient("[system] that user is not online!", senderSocket);
				System.err.println("[system] : " + clientHash.get(senderSocket) + " tried to send a message to a user that is not online");
			} catch (Exception e) {
				//TODO: handle exception
				System.err.println("[system] could not send msg to client");
			}
		}
	}
}

class ChatServerConnector extends Thread {
	private ChatServer server;
	private Socket socket;

	public ChatServerConnector(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
	}

	public void run() {
		System.out.println("[system] connected with " + this.socket.getInetAddress().getHostName() + ":" + this.socket.getPort());

		DataInputStream in;
		try {
			in = new DataInputStream(this.socket.getInputStream()); // create input stream for listening for incoming messages
		} catch (IOException e) {
			System.err.println("[system] could not open input stream!");
			e.printStackTrace(System.err);
			this.server.removeClient(socket);
			return;
		}

		while (true) { // infinite loop in which this thread waits for incoming messages and processes them
			String msg_received;

			try {
				msg_received = in.readUTF(); // read the message from the client
			} catch (Exception e) {
				System.err.println("[system] there was a problem while reading message client on port " + this.socket.getPort() + ", removing client");
				e.printStackTrace(System.err);
				this.server.removeClient(this.socket);
				return;
			}

			if (msg_received.length() == 0) // invalid message
				continue;

			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String time = "[" + dateFormat.format(date).toString() + "] ";

			System.out.println("[RKchat] [" + this.socket.getPort() + "] " + time + server.clientHash.get(this.socket) + ": " + msg_received); // print the incoming message in the console

			if(this.server.checkForCommands(msg_received, this.socket))
				continue;

			// removed the uppercase 
			//String msg_send = server.clientHash.get(this.socket) + ": " + msg_received.toUpperCase(); // TODO

			String msg_send = time + server.clientHash.get(this.socket) + ": " + msg_received;

			try {
				this.server.sendToAllClients(msg_send, this.socket); // send message to all clients
			} catch (Exception e) {
				System.err.println("[system] there was a problem while sending the message to all clients");
				e.printStackTrace(System.err);
				continue;
			}
		}
	}
}

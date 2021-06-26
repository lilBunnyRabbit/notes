import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Editor {
    private static int fee;
    private static List<String> words;
    private static List<Commands> commandsList, removedCommands;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        words = new ArrayList<String>();
        commandsList = new ArrayList<Commands>();
        removedCommands = new ArrayList<Commands>();

        while (sc.hasNext()) {
            String command = sc.next();

            if(command.equals("#")) { hashtag(sc, command); }
            else if(command.equals("+")) { plus(sc, command); }         
            else if(command.equals("-")) { minus(sc, command); }        
            else if(command.equals("<")) { lessThan(sc, command); }        
            else if(command.equals(">")) { greaterThan(sc, command); }
            else if(command.equals("x")) { break; }

            printWords(words);
        }
        
        sc.close();
    }

    public static void hashtag(Scanner sc, String command) {
        String word = sc.next();
        commandsList.add(new Commands(command, 0, word));
        insertToEnd(word);
    }

    public static void plus(Scanner sc, String command) {
        int position = sc.nextInt();
        String word = sc.next();
        commandsList.add(new Commands(command, position, word));
        insertToPosition(word, position);
    }

    public static void minus(Scanner sc, String command) {
        int position = sc.nextInt();
        if(position < words.size()) {
            commandsList.add(new Commands(command, position, words.get(position)));
            removeFromList(position);
        }
    }

    public static void lessThan(Scanner sc, String command) {
        String word = commandsList.get(commandsList.size() - 1).getWord();
        int position = commandsList.get(commandsList.size() - 1).getPosition();
        String currentCommand = commandsList.get(commandsList.size() - 1).getCommand();

        switch(currentCommand){
            case "#":
                removeFromList(words.size() - 1);
                removedCommands.add(new Commands("#", position, word));
                break;

            case "+":
                removeFromList(position);
                removedCommands.add(new Commands("+", position, word));
                break;

            case "-":
                insertToPosition(word, position);
                removedCommands.add(new Commands("-", position, word));
                break;
        }

        commandsList.remove(commandsList.size() - 1);
    }

    public static void greaterThan(Scanner sc, String command) {
        String word = removedCommands.get(removedCommands.size() - 1).getWord();
        int position = removedCommands.get(removedCommands.size() - 1).getPosition();
        String currentCommand = removedCommands.get(removedCommands.size() - 1).getCommand();

        switch(currentCommand){
            case "#":
                insertToEnd(word);
                break;

            case "+":
                insertToPosition(word, position);
                break;

            case "-":
                removeFromList(position);
                break;
        }

        commandsList.add(removedCommands.get(removedCommands.size() - 1));
        removedCommands.remove(removedCommands.size() - 1);
    }

    public static void insertToEnd(String word) {
        words.add(word);
        fee += word.length();
    }

    public static void insertToPosition(String word, int position) {
        words.add(position, word);
        fee += word.length() + Math.abs(2*((words.size() - 1) - position));
    }

    public static void removeFromList(int position) {
        if(position < words.size()) {
            fee += 2*words.get(position).length() + Math.abs(3*((words.size() - 1) - position));
            words.remove(position);
        }
    }

    public static void printWords(List<String> words) {
        System.out.printf("%d | ", fee);
        for (int i = 0; i < words.size(); i++) {
            if(i != 0){ System.out.print("/" + words.get(i)); }
            else{ System.out.print(words.get(i)); }
        }
        System.out.println();
    }

    static class Commands { 
        private String command;
        private int position;
        private String word;
        
        public Commands(String command, int position, String word) {
            this.command = command;
            this.position = position;
            this.word = word;
        }

        public String getCommand() { return command; }

        public int getPosition() { return position; }

        public String getWord() { return word; }
    }
}


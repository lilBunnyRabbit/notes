import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class DN09_63180202 {
    private static int poraba;
    private static List<String> besedilo;
    private static List<Ukazi> listUk, remUk;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        besedilo = new ArrayList<String>();
        listUk = new ArrayList<Ukazi>();
        remUk = new ArrayList<Ukazi>();

        while (sc.hasNext()) {
            String ukaz = sc.next();

            if(ukaz.equals("#")) { hashtag(sc, ukaz); }
            else if(ukaz.equals("+")) { plus(sc, ukaz); }         
            else if(ukaz.equals("-")) { minus(sc, ukaz); }        
            else if(ukaz.equals("<")) { lessThan(sc, ukaz); }        
            else if(ukaz.equals(">")) { greaterThan(sc, ukaz); }
            else if(ukaz.equals("x")) { break; }

            izpisBesedila(besedilo);
        }
        
        sc.close();
    }

    public static void hashtag(Scanner sc, String ukaz) {
        String beseda = sc.next();
        listUk.add(new Ukazi(ukaz, 0, beseda));
        insertToEnd(beseda);
    }

    public static void plus(Scanner sc, String ukaz) {
        int pozicija = sc.nextInt();
        String beseda = sc.next();
        listUk.add(new Ukazi(ukaz, pozicija, beseda));
        insertToPosition(beseda, pozicija);
    }

    public static void minus(Scanner sc, String ukaz) {
        int pozicija = sc.nextInt();
        if(pozicija < besedilo.size()) {
            listUk.add(new Ukazi(ukaz, pozicija, besedilo.get(pozicija)));
            removeFromList(pozicija);
        }
    }

    public static void lessThan(Scanner sc, String ukaz) {
        String beseda = listUk.get(listUk.size() - 1).getBeseda();
        int pozicija = listUk.get(listUk.size() - 1).getPozicija();
        String trenUkaz = listUk.get(listUk.size() - 1).getUkaz();

        switch(trenUkaz){
            case "#":
                removeFromList(besedilo.size() - 1);
                remUk.add(new Ukazi("#", pozicija, beseda));
                break;

            case "+":
                removeFromList(pozicija);
                remUk.add(new Ukazi("+", pozicija, beseda));
                break;

            case "-":
                insertToPosition(beseda, pozicija);
                remUk.add(new Ukazi("-", pozicija, beseda));
                break;
        }

        listUk.remove(listUk.size() - 1);
    }

    public static void greaterThan(Scanner sc, String ukaz) {
        String beseda = remUk.get(remUk.size() - 1).getBeseda();
        int pozicija = remUk.get(remUk.size() - 1).getPozicija();
        String trenUkaz = remUk.get(remUk.size() - 1).getUkaz();

        switch(trenUkaz){
            case "#":
                insertToEnd(beseda);
                break;

            case "+":
                insertToPosition(beseda, pozicija);
                break;

            case "-":
                removeFromList(pozicija);
                break;
        }

        listUk.add(remUk.get(remUk.size() - 1));
        remUk.remove(remUk.size() - 1);
    }

    public static void insertToEnd(String beseda) {
        besedilo.add(beseda);
        poraba += beseda.length();
    }

    public static void insertToPosition(String beseda, int pozicija) {
        besedilo.add(pozicija, beseda);
        poraba += beseda.length() + Math.abs(2*((besedilo.size() - 1) - pozicija));
    }

    public static void removeFromList(int pozicija) {
        if(pozicija < besedilo.size()) {
            poraba += 2*besedilo.get(pozicija).length() + Math.abs(3*((besedilo.size() - 1) - pozicija));
            besedilo.remove(pozicija);
        }
    }

    public static void izpisBesedila(List<String> besedilo) {
        System.out.printf("%d | ", poraba);
        for (int i = 0; i < besedilo.size(); i++) {
            if(i != 0){ System.out.print("/" + besedilo.get(i)); }
            else{ System.out.print(besedilo.get(i)); }
        }
        System.out.println();
    }

    static class Ukazi { 
        private String ukaz;
        private int pozicija;
        private String beseda;
        
        public Ukazi(String ukaz, int pozicija, String beseda) {
            this.ukaz = ukaz;
            this.pozicija = pozicija;
            this.beseda = beseda;
        }

        public String getUkaz() { return ukaz; }

        public int getPozicija() { return pozicija; }

        public String getBeseda() { return beseda; }
    }
}


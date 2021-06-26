import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Urejevalnik2 {
    private static int poraba;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> besedilo = new ArrayList<String>();
        List<Ukazi> uk = new ArrayList<Ukazi>();
        List<Ukazi> removedUkazi = new ArrayList<Ukazi>();

        while (sc.hasNext()) {
            String ukaz = sc.next();
            if(ukaz.equals("#")) {
                // Vrstico s podanim besedilom doda na konec dokumenta.
                String beseda = sc.next();
                besedilo.add(beseda);
                uk.add(new Ukazi(ukaz, 0, beseda));
                poraba += beseda.length();
                

            }else if(ukaz.equals("+")) {
                // Vrstico s podanim besedilom vstavi pred vrstico s podanim indeksom. Prva vrstica ima indeks 0.
                //2v+z
                int pozicija = sc.nextInt();
                String beseda = sc.next();
                uk.add(new Ukazi(ukaz, pozicija, beseda));

                besedilo = vstaviBesedo(besedilo, beseda, pozicija);
                poraba += beseda.length() + 2*((uk.size() - 1) - pozicija);

            }else if(ukaz.equals("-")) {
                // Odstrani vrstico s podanim indeksom
                int pozicija = sc.nextInt();
                //uk.add(new Ukazi(ukaz, pozicija, uk.get(pozicija).getBeseda()));

                poraba += 2*uk.get(pozicija).getBeseda().length() + 3*((uk.size() - 1) - pozicija);
                uk.remove(pozicija);

            }else if(ukaz.equals("<")) {
                // Razveljavi nazadnje izvršeni ukaz.1
                String besedaUkaza;
                int pozUkaza;
                String predUkaz = uk.get(uk.size() - 1).getUkaz();
                switch(predUkaz){
                    case "#":
                        poraba += 2*uk.get(uk.size() - 1).getBeseda().length();
                        removedUkazi.add(uk.get(uk.size() - 1));
                        uk.remove(uk.size() - 1);
                        break;
                    case "+":
                        besedaUkaza = uk.get(uk.size() - 1).getBeseda(); 
                        pozUkaza = uk.get(uk.size() - 1).getPozicija();
                        poraba += 2*besedaUkaza.length() + 3*((uk.size() - 1) - pozUkaza);
                        removedUkazi.add(uk.get(uk.size() - 1));
                        uk.remove(pozUkaza);
                        break;
                    case "-":
                        besedaUkaza = uk.get(uk.size() - 1).getBeseda(); 
                        pozUkaza = uk.get(uk.size() - 1).getPozicija();
                        poraba += besedaUkaza.length() + 2*((uk.size() - 1) - pozUkaza);
                        removedUkazi.add(uk.get(uk.size() - 1));
                        uk.remove(uk.size() - 1);
                        besedilo = vstaviBesedo(besedilo, besedaUkaza, pozUkaza);
                        break;
                }
                
            }else if(ukaz.equals(">")) {
                // Ponovno izvrši nazadnje razveljavljeni ukaz.2

            }

            else if(ukaz.equals("x")) {
                // Izhod iz programa.
                break;
            }

            izpisBesedila(besedilo);
        }
        sc.close();
        
    }

    public static List<String> vstaviBesedo(List<String> besedilo, String beseda, int pozicija) {
        //System.out.println(pozicija+ " - " + beseda);
        int velikost = besedilo.size();
        if(velikost != 0 && pozicija != velikost ){
            besedilo.add("temp");
            for (int i = velikost - 1; i >= 0; i--) {
                //System.out.println((i+1) + uk.get(i).getBeseda());
                //System.out.println(i);
                besedilo.set(i + 1, beseda);
                if(i == pozicija){
                    //System.out.println(i + beseda + "-----");
                    //System.out.println("Dodal " + beseda + " na " + pozicija);
                    besedilo.set(i, beseda);
                    break;
                }
                //System.out.print("-");
            }
        }else{
            besedilo.add(beseda);
        }
        
        return besedilo;
    }

    public static void izpisBesedila(List<String> besedilo) {
        System.out.printf("%d | ", poraba);
        for (int i = 0; i < besedilo.size(); i++) {
            if(i != 0){
                System.out.print("/" + besedilo.get(i));
            }else{
                System.out.print(besedilo.get(i));
            }
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

        public String getUkaz() {
            return ukaz;
        }

        public int getPozicija() {
            return pozicija;
        }

        public String getBeseda() {
            return beseda;
        }
    }
}

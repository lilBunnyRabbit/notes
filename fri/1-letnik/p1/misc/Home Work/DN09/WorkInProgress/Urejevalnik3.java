import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

class Urejevalnik3 {
    private static int poraba;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> besedilo = new ArrayList<String>();
        List<Character> ukazi = new ArrayList<Character>();
        List<Integer> pozicije = new ArrayList<Integer>();
        List<String> besede = new ArrayList<String>();

        while (sc.hasNext()) {
            String ukaz = sc.next();
            if(ukaz.equals("#")) {
                // Vrstico s podanim besedilom doda na konec dokumenta.
                String beseda = sc.next();
                ukazi.add('#');

                besedilo.add(beseda);
                poraba += beseda.length();
                

            }else if(ukaz.equals("+")) {
                // Vrstico s podanim besedilom vstavi pred vrstico s podanim indeksom. Prva vrstica ima indeks 0.
                //2v+z
                int pozicija = sc.nextInt();
                String beseda = sc.next();
                ukazi.add('+');
                pozicije.add(pozicija);
                besede.add(beseda);

                besedilo = vstaviBesedo(besedilo, beseda, pozicija);
                poraba += beseda.length() + 2*((besedilo.size() - 1) - pozicija);

            }else if(ukaz.equals("-")) {
                // Odstrani vrstico s podanim indeksom
                int pozicija = sc.nextInt();
                ukazi.add('-');
                pozicije.add(pozicija);
                besede.add(besedilo.get(pozicija));
                poraba += 2*besedilo.get(pozicija).length() + 3*((besedilo.size() - 1) - pozicija);
                besedilo.remove(pozicija);

            }else if(ukaz.equals("<")) {
                // Razveljavi nazadnje izvršeni ukaz.1
                String besedaUkaza;
                int pozUkaza;
                switch(ukazi.get(ukazi.size() - 1)){
                    case '#':
                        besedilo.remove(besedilo.size() - 1);
                        poraba += 2*besedilo.get(besedilo.size() - 1).length();
                        //System.out.println("#" + 2*besedilo.get(besedilo.size() - 1).length());
                        ukazi.remove(ukazi.size() - 1);
                        break;
                    case '+':
                        besedaUkaza = besede.get(besede.size() - 1); 
                        pozUkaza = pozicije.get(pozicije.size() - 1);
                        //System.out.println("+" + 2*besedaUkaza.length() + 3*((besedilo.size() - 1) - pozUkaza));
                        poraba += 2*besedaUkaza.length() + 3*((besedilo.size() - 1) - pozUkaza);
                        besedilo.remove(pozUkaza);

                        ukazi.remove(ukazi.size() - 1);
                        besede.remove(besede.size() - 1);
                        pozicije.remove(pozicije.size() - 1);
                        break;
                    case '-':
                        besedaUkaza = besede.get(besede.size() - 1); 
                        pozUkaza = pozicije.get(pozicije.size() - 1);

                        System.out.println("- ");
                        System.out.println(besedaUkaza);
                        System.out.println(besedaUkaza.length());
                        System.out.println(2*((besedilo.size() - 1)));
                        System.out.println( - pozUkaza);
                        poraba += besedaUkaza.length() + 2*((besedilo.size() - 1) - pozUkaza);
                        besedilo = vstaviBesedo(besedilo, besedaUkaza, pozUkaza);

                        ukazi.remove(ukazi.size() - 1);
                        besede.remove(besede.size() - 1);
                        pozicije.remove(pozicije.size() - 1);
                        break;
                }
                

            }else if(ukaz.equals(">")) {
                // Ponovno izvrši nazadnje razveljavljeni ukaz.2

            }else if(ukaz.equals("x")) {
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
                //System.out.println((i+1) + besedilo.get(i));
                //System.out.println(i);
                besedilo.set(i + 1, besedilo.get(i));
                if(i == pozicija){
                    //System.out.println(i + beseda + "-----");
                    //System.out.println("Dodal " + beseda + " na " + pozicija);
                    besedilo.set(i, beseda);
                    break;
                }
                //System.out.print("-");
                //izpisBesedila(besedilo);
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
}

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class DN06_63180202{
    private static int m, n, stDrzav, kolMorja;
    private static Drzava[] seznamDrzav;
    private static int[][] map;
    public static void main(String[] args){  
        Scanner sc = new Scanner(System.in);
        makeMap(sc);
        int ukaz = sc.nextInt();
        sc.close();
        executeUkaz(ukaz); 
    }

    private static void makeMap(Scanner sc) {
        m = sc.nextInt();
        n = sc.nextInt();
        map = new int[m][n];
        int polje = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                polje = sc.nextInt();
                if(polje == 0){ kolMorja++; }
                else if(polje > stDrzav){ stDrzav++; }
                map[i][j] = polje;
            }
        }
    }

    private static void executeUkaz(int ukaz) {
        switch (ukaz) {
            case 1:
                System.out.println(stDrzav); 
                break;
            
            case 2:
                System.out.println(kolMorja);
                break;

            case 3:
                makeDrzave(stDrzav);
                preglejPolja(ukaz);
                for (Drzava d : seznamDrzav) { System.out.println(d.getMorje()); }
                break;
            
            case 4:
                makeDrzave(stDrzav);
                preglejPolja(ukaz);
                int najSosedov = 0;
                int najDrzava = 0;
                for (Drzava d : seznamDrzav) {
                    if(d.getSosedi() > najSosedov){
                        najDrzava = d.getIme();
                        najSosedov = d.getSosedi();
                    }
                }
                System.out.printf("%d%n%d", najDrzava, najSosedov);

            default:
                break;
        }
    }

    private static void makeDrzave(int stDrzav){
        seznamDrzav = new Drzava[stDrzav]; 
        for (int i = 0; i < stDrzav; i++) {
            seznamDrzav[i] = new Drzava(i + 1);
        }
    }

    private static void preglejPolja(int ukaz) {
        int polje = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                polje = map[i][j];
                if(polje != 0){ 
                    switch(ukaz){
                        case 3:
                            if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                                seznamDrzav[polje - 1].addMorje();
                            }else if(preveriMorje(polje, new int[]{map[i - 1][j], map[i + 1][j], map[i][j - 1], map[i][j + 1]})){
                                seznamDrzav[polje - 1].addMorje();
                            }
                            break;

                        case 4:
                            if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                                preveriSosede(polje, mozneLokacije(i, j));
                            }else{
                                int[] moznaPolja = new int[]{map[i - 1][j], map[i + 1][j], map[i][j - 1], map[i][j + 1]};
                                preveriSosede(polje, moznaPolja);
                            }                  
                            break;
                    }
                }
            }
        }
    }

    private static boolean preveriMorje(int polje, int[] moznaPolja) {
        for (int p : moznaPolja) { if(p == 0){ return true; } }
        return false;
    }

    private static int[] mozneLokacije(int i, int j) {
        int gor = -1; 
        int desno = 1;
        int dol = 1; 
        int levo = -1;

        if(i == 0){ gor = 0; }
        else if(i == m - 1){ dol = 0;}

        if(j == 0){ levo = 0;}
        else if(j == n - 1){ desno = 0;}

        int[] moznaPolja = new int[]{map[i + gor][j], map[i + dol][j], map[i][j + levo], map[i][j + desno]};

        return moznaPolja;
    }

    private static void preveriSosede(int polje, int[] moznaPolja) {
        Drzava d = seznamDrzav[polje - 1];
        for (int p : moznaPolja) {
            if(polje != p && p != 0){
                d.dodajSoseda(p);
            }
        }
    }

    static class Drzava {
        private int ime, morje;
        private Set<Integer> sosedi;

        public Drzava(int ime) {
            this.ime = ime;
            this.morje = 0;
            this.sosedi = new HashSet<Integer>();
        }

        public void addMorje() {
            this.morje++;
        }

        public void dodajSoseda(int sosed) {
            this.sosedi.add(sosed);
        }

        public int getMorje() {
            return this.morje;
        }

        public int getIme() {
            return this.ime;
        }

        public int getSosedi(){
            return this.sosedi.size();
        }
        
    }    
}
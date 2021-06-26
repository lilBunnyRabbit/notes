import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class Zemljevid3{
    private static int m, n, stDrzav, kolMorja;
    private static Drzava[] seznamDrzav;
    public static void main(String[] args){  
        Scanner sc = new Scanner(System.in);

        int[][] map = makeMap(sc);
        int ukaz = sc.nextInt();
        sc.close();

        executeCommand(ukaz, map); 
    }

    private static int[][] makeMap(Scanner sc) {
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] map = new int[m][n];
        int polje = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                polje = sc.nextInt();
                if(polje > stDrzav){ stDrzav++; }
                if(polje == 0){ kolMorja++; }
                map[i][j] = polje;
            }
        }
        return map;
    }

    private static void executeCommand(int ukaz, int[][] map) {
        switch (ukaz) {
            case 1:
                System.out.println(stDrzav); 
                break;
            
            case 2:
                System.out.println(kolMorja);
                break;

            case 3:
                makeDrzave(stDrzav);
                poisciMorje(map);
                for (Drzava d : seznamDrzav) { System.out.println(d.geiorje()); }

                break;
            
            case 4:
                makeDrzave(stDrzav);
                poisciSosede(map);
                int najSosedov = 0;
                int najDrzava = 0;

                for (int i = 0; i < stDrzav; i++) {
                    if(seznamDrzav[i].getSosedi() > najSosedov){
                        najDrzava = seznamDrzav[i].getIme();
                        najSosedov = seznamDrzav[i].getSosedi();
                    }
                }

                System.out.printf("%d%n%d", najDrzava, najSosedov - 1);

            default:
                break;
        }
    }

    private static void makeDrzave(int stDrzav){
        seznamDrzav = new Drzava[stDrzav]; 
        for (int i = 0; i < stDrzav; i++) {
            seznamDrzav[i] = new Drzava();
            seznamDrzav[i].setDrzava(i + 1);
        }
    }

    private static void poisciMorje(int[][] map) {
        int polje;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                polje = map[i][j];
                if(polje != 0){ 
                    if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                        seznamDrzav[polje - 1].addMorje();
                    }else if(preveriMorje(map, i, j)){
                        seznamDrzav[polje - 1].addMorje();
                    }
                }
            }
        }
    }

    private static boolean preveriMorje(int[][] map, int i , int j) {
        int gor = -1; 
        int desno = 1;
        int dol = 1; 
        int levo = -1;

        if(i == 0){ gor = 0; }
        if(i == m - 1){ dol = 0;}

        if(j == 0){ levo = 0;}
        if(j == n - 1){ desno = 0;}

        if(map[i + gor][j] == 0){ return true;}
        if(map[i + dol][j] == 0){ return true;}
        if(map[i][j + levo] == 0){ return true;}
        if(map[i][j + desno] == 0){ return true;}

        return false;
    }

    private static void poisciSosede(int[][] map) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int polje = map[i][j];
                if(polje != 0){ 
                    preveriSosede(map, i, j, polje);
                }
            }
        }
    }

    private static void preveriSosede(int[][] map, int i , int j, int polje) {
        int gor = -1; 
        int desno = 1;
        int dol = 1; 
        int levo = -1;

        if(i == 0){ gor = 0; }
        if(i == m - 1){ dol = 0;}

        if(j == 0){ levo = 0;}
        if(j == n - 1){ desno = 0;}

        int gorPolje = map[i + gor][j];
        int dolPolje = map[i + dol][j];
        int desnoPolje = map[i][j + levo];
        int levoPolje = map[i][j + desno];
        if(polje != gorPolje ){ seznamDrzav[polje - 1].dodajSoseda(gorPolje); }
        if(polje != dolPolje){ seznamDrzav[polje - 1].dodajSoseda(dolPolje); }
        if(polje != levoPolje){ seznamDrzav[polje - 1].dodajSoseda(levoPolje); }
        if(polje != desnoPolje){ seznamDrzav[polje - 1].dodajSoseda(desnoPolje); }
    }

    static class Drzava {
        private int ime, morje;
        private Set<Integer> sosedi;

        public void setDrzava(int ime) {
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

        public int geiorje() {
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
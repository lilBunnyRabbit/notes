import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class Zemljevid{
    private static int m, n, stDrzav, kolMorja;
    private static int[] morje;
    private static int[][] sosedi;
    public static void main(String[] args){  
        Scanner sc = new Scanner(System.in);
        int[][] map = makeMap(sc);
        int ukaz = sc.nextInt();
        executeCommand(ukaz, map);
        sc.close();
    }

    private static int[][] makeMap(Scanner sc) {
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int polje = sc.nextInt();

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
                morje = new int[stDrzav];
                poisciMorje(map);
                for (int d : morje) { System.out.println(d); }
                break;
            
            case 4:
                sosedi = new int[stDrzav][stDrzav];
                poisciSosede(map);
                int[] stSosedov = new int[stDrzav];
                int stevecDrzav = 0;

                for (int[] sos : sosedi) { 
                    int stevec = 0;
                    for (int s : sos) {
                        if(s != 0){
                            stevec++;
                        }
                    }
                    stSosedov[stevecDrzav] = stevec;
                    stevecDrzav++;
                }
                int najDrzava = 0;
                int najSosedov = 0;
                for (int st = 0; st < stDrzav; st++) {
                    if(stSosedov[st] > najSosedov){
                        najDrzava = st + 1;
                        najSosedov = stSosedov[st];
                    }
                }

                System.out.printf("%d%n%d", najDrzava, najSosedov);
                break;

            default:
                break;
        }
    }

    private static void poisciMorje(int[][] map) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int polje = map[i][j];
                if(polje != 0){ 
                    if(preveriMorje(map, i, j)){
                        morje[polje - 1]++;
                    }else{
                        if(i == 0 || i == m - 1 || j == 0 || j == n - 1){
                            morje[polje - 1]++;
                        }
                    }
                }
            }
        }
    }

    private static boolean preveriMorje(int[][] map, int tM , int tN) {
        int gor = -1; 
        int desno = 1;
        int dol = 1; 
        int levo = -1;

        if(tM == 0){ gor = 0; }
        if(tM == m - 1){ dol = 0;}

        if(tN == 0){ levo = 0;}
        if(tN == n - 1){ desno = 0;}

        if(map[tM + gor][tN] == 0){ return true;}
        if(map[tM + dol][tN] == 0){ return true;}
        if(map[tM][tN + levo] == 0){ return true;}
        if(map[tM][tN + desno] == 0){ return true;}

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

    private static void preveriSosede(int[][] map, int tM , int tN, int polje) {
        int gor = -1; 
        int desno = 1;
        int dol = 1; 
        int levo = -1;

        if(tM == 0){ gor = 0; }
        if(tM == m - 1){ dol = 0;}

        if(tN == 0){ levo = 0;}
        if(tN == n - 1){ desno = 0;}
        int gorPolje = map[tM + gor][tN];
        int dolPolje = map[tM + dol][tN];
        int desnoPolje = map[tM][tN + levo];
        int levoPolje = map[tM][tN + desno];

        if(gorPolje != 0 && gorPolje != polje){ sosedi[polje - 1][gorPolje - 1] = gorPolje; }
        if(dolPolje != 0 && dolPolje != polje){ sosedi[polje - 1][dolPolje - 1] = dolPolje; }
        if(levoPolje != 0 && levoPolje != polje){ sosedi[polje - 1][levoPolje - 1] = levoPolje; }
        if(desnoPolje != 0 && desnoPolje != polje){ sosedi[polje - 1][desnoPolje - 1] = desnoPolje; }

    }
}
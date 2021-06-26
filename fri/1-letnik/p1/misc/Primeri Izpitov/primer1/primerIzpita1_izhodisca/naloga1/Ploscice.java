
//=============================================================================
// Dopolnite!
//=============================================================================

import java.util.*;

public class Ploscice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n * n skatla
        int k = sc.nextInt(); // k plostic
        int[][] sezPloscic = new int[k][2];
        int maxH = 1;
        int maxW = 1;
        int stPloscic = 0;

        for (int i = 0; i < k; i++) {
            sezPloscic[i][0] = sc.nextInt(); // visina i-te
            sezPloscic[i][1] = sc.nextInt(); // sirina i-te       
            if(sezPloscic[i][0] > maxH) { maxH = sezPloscic[i][0]; }    
            if(sezPloscic[i][1] > maxW) { maxH = sezPloscic[i][1]; } 
        }
        Arrays.sort(sezPloscic, c);
        for (int[] p : sezPloscic) {
            System.out.println(p[0] + " - " + p[1]);
        }
        // TODO: Sortiraj Array
        

    }
}

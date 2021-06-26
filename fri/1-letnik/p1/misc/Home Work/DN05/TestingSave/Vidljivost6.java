import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Vidljivost6{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int stOseb = sc.nextInt();
        int vsota = 1;
        int v1 = 0;
        int v2 = sc.nextInt();
        int[] visine = new int[stOseb];

        for (int oseba = 1; oseba < stOseb; oseba++) {
            v1 = v2;
            v2 = sc.nextInt();

            
        }

        System.out.println(vsota);
    }

    private static int[] sprazniVisine(int stOseb, int oseba, int v2) {
        int[] visine = new int[stOseb - oseba];
        visine[0] = v2;
        return visine;
    }
    
    private static int[] dodajVisino(int[] visine, int v2, int oseba) {
        visine[oseba - 1] = v2;
        return visine;
    }

    private static void primerjajVisine(int[] visine, int v2) {
        for (int i = 0; i < visine.length; i++) {
            
        }
    }
}
import java.util.Scanner;
import java.util.Arrays;

class Vidljivost{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int stOseb = sc.nextInt();
        int[] visine = new int[stOseb];
        visine = insertValues(visine, stOseb);
        int vsota = 0;

        for (int i = 0; i < stOseb; i++) { vsota += checkHeight(visine, i); }
        System.out.println(vsota);
    }

    private static int[] insertValues(int[] visine, int stOseb) {
        for (int oseba = 0; oseba < stOseb; oseba++) {
            int o = sc.nextInt()
            if(o < visine[])
            visine[oseba] = sc.nextInt();
        }
        return visine;
    }

    private static int checkHeight(int[] visine, int oseba) {
        if(oseba <= 0){ return 1; }
        else if(visine[oseba - 1] > visine[oseba]){ return 1; }
        else{
            for (int i = 1; i <= oseba; i++) {
                if(visine[oseba - i] > visine[oseba]){ return i; }
                if (oseba - i == 0) { return i + 1; }
            }
        }
        return 1;
    }
}
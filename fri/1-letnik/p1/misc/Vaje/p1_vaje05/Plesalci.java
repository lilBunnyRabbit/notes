
import java.util.Scanner;

public class Plesalci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int stM = sc.nextInt();
        int stZ = sc.nextInt();
        int stG = sc.nextInt();
        int par = 1;

        for(int moski = stG; moski <= stM ; moski += stG){
            for(int zenska = stG; zenska <= stZ; zenska += stG){
                if(gcd(moski,zenska) == stG){
                    System.out.printf("[%d] %d + %d",par,moski,zenska);
                    System.out.println();
                    par++;
                }
            }
        }
    }

    /*
     * Vrne GCD pozitivnih celih števil a in b.
     */
    public static int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}

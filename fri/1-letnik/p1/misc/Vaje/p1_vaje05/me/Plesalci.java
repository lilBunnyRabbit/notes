
import java.util.Scanner;

public class Plesalci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int stMoskih = sc.nextInt();
		int stZensk = sc.nextInt();
		int ciljniGCD = sc.nextInt();
		
		
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

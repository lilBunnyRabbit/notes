
import java.util.Scanner;

public class Plesalci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int stMoskih = sc.nextInt();
		int stZensk = sc.nextInt();
		int ciljniGCD = sc.nextInt();
		int stPara = 1;
		
		/*
		for (int m = 1;  m <= stMoskih;  m++) {
			for (int z = 1;  z <= stZensk;  z++) {
				if (gcd(m, z) == ciljniGCD) {
					System.out.printf("[%d] %d + %d%n", stPara, m, z);
					stPara++;
				}
			}
		}
		*/
		
		for (int m = ciljniGCD;  m <= stMoskih;  m += ciljniGCD) {
			for (int z = ciljniGCD;  z <= stZensk;  z += ciljniGCD) {
				if (gcd(m, z) == ciljniGCD) {
					System.out.printf("[%d] %d + %d%n", stPara, m, z);
					stPara++;
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

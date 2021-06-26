
import java.util.Scanner;

public class Smreka {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int stPiramid = sc.nextInt();
		
		for (int i = 1;  i <= stPiramid;  i++) {
			// narišemo zamaknjeno piramido (višina = i, zamik = stPiramid - i)
			piramida(i, stPiramid - i);
		}
    }

    /*
     * Nariše piramido vi"sine <visina>, zamaknjeno za <zamik> presledkov v
     * desno.
     */
    private static void piramida(int visina, int zamik) {
		for (int i = 1;  i <= visina;  i++) {
			// nariši i-to vrstico
			
			/*
			// presledki, ki tvorijo zamik
			for (int j = 1;  j <= zamik;  j++) {
				System.out.print(' ');
			}
			
			// presledki, ki so del piramide
			for (int j = 1;  j <= visina - i;  j++) {
				System.out.print(' ');
			}
			
			// zvezdice
			for (int j = 1;  j <= 2 * i - 1;  j++) {
				System.out.print('*');
			}
			*/
			
			// presledki, ki tvorijo zamik
			znaki(' ', zamik);
			
			// presledki, ki so del piramide
			znaki(' ', visina - i);
			
			// zvezdice
			znaki('*', 2 * i - 1);

			// skok v naslednjo vrstico
			System.out.println();
		}
    }
	
	/* Izpiše zaporedje <stZnakov> znakov <znak>. */
	private static void znaki(char znak, int stZnakov) {
		for (int i = 1;  i <= stZnakov;  i++) {
			System.out.print(znak);
		}
	}
}

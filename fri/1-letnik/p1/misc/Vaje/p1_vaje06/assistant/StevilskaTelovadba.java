
import java.util.Scanner;

public class StevilskaTelovadba {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int operacija = sc.nextInt();
		int n = sc.nextInt();
		
		switch (operacija) {
			case 1: {
				int d = sc.nextInt();
				System.out.println( dodajNaKonec(n, d));
				break;
			}
				
			case -1:
				System.out.println( odstraniZadnjo(n));
				break;
				
			case 2: {
				int d = sc.nextInt();
				System.out.println( dodajNaZacetek(n, d));
				break;
			}
				
			case -2:
				System.out.println( odstraniPrvo(n));
				break;
		}
	}
	
	/* Doda podano števko na konec podanega števila in vrne rezultat. */
	private static int dodajNaKonec(int stevilo, int stevka) {
		return stevilo * 10 + stevka;
	}
	
	private static int odstraniZadnjo(int stevilo) {
		return stevilo / 10;
	}
	
	private static int dodajNaZacetek(int stevilo, int stevka) {
		return stevilo + stevka * 10 * navzdolDoPotence10(stevilo); 
	}
	
	private static int odstraniPrvo(int stevilo) {
		return stevilo % navzdolDoPotence10(stevilo);
	}
	
	/* Vrne največjo potenco števila 10, ki ni večja od podanega števila. */
	private static int navzdolDoPotence10(int stevilo) {
		int potenca = 1;
		while (stevilo >= 10) {
			stevilo /= 10;
			potenca *= 10;
		}
		return potenca;
	}
}

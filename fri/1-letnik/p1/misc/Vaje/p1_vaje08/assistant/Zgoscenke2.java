
import java.util.Scanner;
import java.util.Arrays;

public class Zgoscenke2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stZgoscenk = sc.nextInt();
		int kapacitetaZgoscenke = sc.nextInt();
		
		// trenutne zasedenosti posameznih zgoščenk
		int[] zasedenosti = new int[stZgoscenk];
		
		while (sc.hasNextInt()) {
			// preberi velikost datoteke
			int velikostDatoteke = sc.nextInt();
			
			// poišči indeks najmanj zasedene zgoščenke
			int ixZgoscenka = indeksMinimuma(zasedenosti);
			
			// ali lahko datoteko shranimo na izbrano zgoščenko?
			if (zasedenosti[ixZgoscenka] + velikostDatoteke > kapacitetaZgoscenke) {
				// fuj, vendar pa alternative nič manj ne smrdijo
				break;
			}
			
			// povečaj zasedenost izbrane zgoščenke
			zasedenosti[ixZgoscenka] += velikostDatoteke;

			// izpiši vrstico
			System.out.printf("%d EP -> zgoscenka %d %s%n",
			                  velikostDatoteke,
							  ixZgoscenka + 1,    // zap. št. = indeks + 1
							  Arrays.toString(zasedenosti));
		}
	}
	
	/* Vrne indeks najmanjšega elementa v podani tabeli. */
	private static int indeksMinimuma(int[] t) {
		int ixMin = 0;
		for (int i = 1;  i < t.length;  i++) {
			if (t[i] < t[ixMin]) {
				ixMin = i;
			}
		}
		return ixMin;
	}
}

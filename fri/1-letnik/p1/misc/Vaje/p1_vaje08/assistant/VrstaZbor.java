
import java.util.Scanner;

public class VrstaZbor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stVojakov = sc.nextInt();
		
		// preberi višine vojakov v tabelo
		int[] visine = new int[stVojakov];
		for (int i = 0;  i < stVojakov;  i++) {
			visine[i] = sc.nextInt();
		}
		
		// izpišemo indekse lokalno pravilno postavljenih vojakov
		
		/* groba napaka!
		for (int i = 0;  i < stVojakov;  i++) {
			if (lokalnoPravilno(visine, i)) {
				System.out.println(i);
			} else {
				System.out.println("NOBEDEN");
			}
		}
		*/
		
		boolean vsajEden = false;
		for (int i = 0;  i < stVojakov;  i++) {
			if (lokalnoPravilno(visine, i)) {
				System.out.println(i);
				vsajEden = true;
			}
		}
		if (!vsajEden) {
			System.out.println("NOBEDEN");
		}
	}
	
	/* Vrne true natanko v primeru, če je element tabele t na indeksu if
	   večji ali enak od svojega levega soseda in manjši ali enak od
	   svojega desnega soseda.
	*/
	private static boolean lokalnoPravilno(int[] t, int i) {
		return (i == 0 || t[i] >= t[i - 1]) &&
		       (i == t.length - 1 || t[i] <= t[i + 1]);
	}
}

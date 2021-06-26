
import java.util.Scanner;

public class LikiGlavni {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lik[] liki = preberiLike(sc);

        int ukaz = sc.nextInt();
        switch (ukaz) {
            case 1:
                izpisiPodatke(liki);
                break;

            case 2:
                Lik najLik = likZNajvecjoPloscino(liki);
                System.out.println(najLik.toString());
                break;

            case 3:
                pravokotnikiInKvadrati(liki);
                break;
        }
    }

    /** Prebere podatke o vseh likih z vhoda in vrne tabelo s prebranimi
     * podatki. */
    private static Lik[] preberiLike(Scanner sc) {
        int stLikov = sc.nextInt();

        Lik[] liki = new Lik[stLikov];
        for (int i = 0;  i < liki.length;  i++) {
            int vrsta = sc.nextInt();
            switch (vrsta) {
                case 1:
                    liki[i] = new Pravokotnik(sc.nextInt(), sc.nextInt());
                    break;

                case 2:
                    liki[i] = new Kvadrat(sc.nextInt());
                    break;

                case 3:
                    liki[i] = new Krog(sc.nextInt());
                    break;
            }
        }
        return liki;
    }

    /** Izpi"se podatke o vseh likih. */
    private static void izpisiPodatke(Lik[] liki) {
		for (int i = 0;  i < liki.length;  i++) {
			System.out.println(liki[i].toString());
		}
    }

    /** Vrne lik z najve"cjo plo"s"cino v podani tabeli. */
    private static Lik likZNajvecjoPloscino(Lik[] liki) {
        int najPloscina = 0;  // doslej največja ploščina
		int iNaj = 0;         // indeks lika z doslej največjo ploščino
		
		for (int i = 0;  i < liki.length;  i++) {
			int ploscina = liki[i].ploscina();
			if (ploscina > najPloscina) {
				najPloscina = ploscina;
				iNaj = i;
			}
		}
		return liki[iNaj];
    }

    /** Izpi"se podatke o vseh pravokotnikih in kvadratih v podani tabeli. */
    private static void pravokotnikiInKvadrati(Lik[] liki) {
		for (int i = 0;  i < liki.length;  i++) {
			if (liki[i] instanceof Pravokotnik) {
				System.out.println(liki[i].toString());
			}
		}
		
		/* alternativa:
		for (int i = 0;  i < liki.length;  i++) {
			String vrsta = liki[i].vrsta();
			if (vrsta.equals("pravokotnik") || vrsta.equals("kvadrat")) {
				System.out.println(liki[i].toString());
			}
		}
		*/
    }
}

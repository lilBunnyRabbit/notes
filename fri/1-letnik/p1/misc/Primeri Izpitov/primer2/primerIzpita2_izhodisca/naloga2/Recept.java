
/**
 * NALOGA 2
 */

public class Recept {    // kuharski recept

    private Korak[] koraki;    // koraki recepta

    public Recept(Korak[] koraki) {
        this.koraki = koraki;
    }

    public Korak[] vrniKorake() {
        return this.koraki;
    }

    /**
     * Naloga (a) -- vrne trajanje recepta v minutah.
     */
    public int trajanje() {
        // Dopolnite / spremenite ...
        return -1;
    }

    /**
     * Naloga (b) -- vrne indeks prvega koraka s podano akcijo (-1, "ce te
     * akcije ni).
     */
    public int prviKorakZAkcijo(String akcija) {
        // Dopolnite / spremenite ...
        return -2;
    }

    /**
     * Naloga (d) -- vrne "stevilo snovi, ki se pojavljajo SAMO na vhodih v
     * korake recepta.
     */
    public int steviloVstopnihSnovi() {
        // Dopolnite / spremenite ...
        return -1;
    }
}

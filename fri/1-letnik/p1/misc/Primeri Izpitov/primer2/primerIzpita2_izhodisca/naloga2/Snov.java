
/**
 * NALOGA 2
 */

public class Snov {    // jedilna snov

    private String naziv;   // unikaten naziv, npr. "moka" ali "palacinke"

    public Snov(String naziv) {
        this.naziv = naziv;
    }

    public String vrniNaziv() {
        return this.naziv;
    }

    /**
     * Naloga (c) -- preveri, ali snov this nastopa na izhodu vsaj enega
     * koraka podanega recepta.
     */
    public boolean naIzhodu(Recept recept) {
        // Dopolnite / spremenite ...
        return false;
    }
}

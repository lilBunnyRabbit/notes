
public class Jed {

    private String naziv;            // naziv, npr. "prekmurska gibanica"
    private Sestavina[] sestavine;   // sestavine jedi
    private double[] mase;           // mase posameznih sestavin v gramih
    private String vrsta;            // npr. "glavna jed", "sladica"

    public Jed(String naziv, Sestavina[] sestavine, double[] mase, String vrsta) {
        this.naziv = naziv;
        this.sestavine = sestavine;
        this.mase = mase;
        this.vrsta = vrsta;
    }

    public String vrniNaziv() {
        return this.naziv;
    }

    public Sestavina[] vrniSestavine() {
        return this.sestavine;
    }

    public double[] vrniMase() {
        return this.mase;
    }

    public String vrniVrsto() {
        return this.vrsta;
    }

    /**
     * Vrne true natanko v primeru, "ce jed vsebuje vsaj eno sestavino z
     * najmanj 10% beljakovin.
     */
    public boolean jeBeljakovinska() {
        // Dopolnite!
        for (Sestavina s : this.sestavine) {
            if(s.vrniBeljakovine() >= 10) { return true; }
        }
        return false;   // Spremenite!
    }

    /**
     * Vrne skupno "stevilo kalorij (kcal) jedi this.
     */
    public double kalorije() {
        // Dopolnite!
        double skupKal = 0;
        for (int i = 0; i < sestavine.length; i++) {
            skupKal += sestavine[i].vrniKalorije() * (this.mase[i]/100);
        }
        return skupKal;   // Spremenite!
    }
}

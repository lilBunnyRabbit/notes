
public class PostniNaslov {

    private String ulicaHS;  // ulica s hi"sno "stevilko
    private int postnaStevilka;
    private String posta;

    /**
     * Ustvari nov objekt razreda PostniNaslov.
     */
    public PostniNaslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    /** 
     * Vrne predstavitev po"stnega naslova `this' v obliki niza.
     */
    public String toString() {
        return String.format("%s, %d %s", this.ulicaHS, this.postnaStevilka, this.posta);
    }

    /** 
     * Vrne `true' natanko v primeru, "ce objekt `pn' predstavlja enak po"stni
     * naslov kot objekt `this'.
     */
    public boolean jeEnakKot(PostniNaslov pn) {
        return (this.ulicaHS.equals(pn.ulicaHS)
                && this.postnaStevilka == pn.postnaStevilka
                && this.posta.equals(pn.posta));
    }
}

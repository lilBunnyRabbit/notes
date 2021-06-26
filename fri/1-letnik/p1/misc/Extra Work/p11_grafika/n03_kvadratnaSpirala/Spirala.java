
import java.awt.*;

/**
 * Razred, ki ga je treba dopolniti.
 */
public class Spirala extends Platno {

    public static void main(String[] args) {
        Spirala spirala = new Spirala(5);
        spirala.sproziRisanje(args);
    }

    // "stevilo zavojev spirale
    private int stZavojev;

    public Spirala(int stZavojev) {
        this.stZavojev = stZavojev;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
        // dopolnite ...
    }
}

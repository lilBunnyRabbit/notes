
import java.awt.*;

/**
 * Razred, ki ga je treba dopolniti.
 */
public class Drevo extends Platno {

    public static void main(String[] args) {
        Drevo drevo = new Drevo("4 2 0 0 1 2 0 0 0 3 0 3 0 0 0 0");
        drevo.sproziRisanje(args);
    }

    // opis drevesa
    private String opis;

    public Drevo(String opis) {
        this.opis = opis;
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

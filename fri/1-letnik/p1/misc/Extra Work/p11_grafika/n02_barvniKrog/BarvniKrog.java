
import java.awt.*;
import java.awt.geom.*;

/**
 * Razred, ki ga je treba dopolniti.
 */
public class BarvniKrog extends Platno {

    public static void main(String[] args) {
        BarvniKrog barvniKrog = new BarvniKrog(7);
        barvniKrog.sproziRisanje(args);
    }

    // "stevilo kro"znih izsekov
    private int stIzsekov;

    public BarvniKrog(int stIzsekov) {
        this.stIzsekov = stIzsekov;
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

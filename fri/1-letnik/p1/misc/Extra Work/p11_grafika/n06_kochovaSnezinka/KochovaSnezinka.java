
import java.awt.*;

/**
 * Razred, ki ga je treba dopolniti.
 */
public class KochovaSnezinka extends Platno {

    public static void main(String[] args) {
        KochovaSnezinka ks = new KochovaSnezinka(3);
        ks.sproziRisanje(args);
    }

    // "stevilo iteracij
    private int stIteracij;

    public KochovaSnezinka(int stIteracij) {
        this.stIteracij = stIteracij;
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


import java.awt.*;

public class RadarskiDiagram extends Platno {

    public static void main(String[] args) {
        double[] delezi = { 0.6, 0.3, 0.8, 0.5, 0.9 };
        RadarskiDiagram diagram = new RadarskiDiagram(delezi);
        diagram.sproziRisanje(args);
    }

    // [i] = dele"z za daljico ob kotu (2 * Math.PI * i / delezi.length)
    private double[] delezi;

    public RadarskiDiagram(double[] delezi) {
        this.delezi = delezi;
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

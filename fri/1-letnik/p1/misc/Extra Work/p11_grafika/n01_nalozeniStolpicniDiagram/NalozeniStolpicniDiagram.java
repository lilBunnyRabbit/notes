
import java.awt.*;

public class NalozeniStolpicniDiagram extends Platno {

    public static abstract class Slog {
    }

    public static class Pobarvan extends Slog {
        private Color barva;

        public Pobarvan(Color barva) {
            this.barva = barva;
        }
    }

    public static class Srafiran extends Slog {
        private int stCrt;
        private Color barvaCrt; 

        public Srafiran(int stCrt, Color barvaCrt) {
            this.stCrt = stCrt;
            this.barvaCrt = barvaCrt;
        }
    }

    public static void main(String[] args) {
        double[][] podatki = {
            { 3.0, 2.0, 5.0, 6.0 },
            { 7.0, 4.0, 8.0, 1.0 },
            { 2.0, 5.0, 1.0, 9.0 },
            { 4.0, 2.0, 3.0, 1.0 },
            { 6.0, 0.0, 5.0, 3.0 }
        };

        Slog[] slogi = {
            new Pobarvan(Color.GREEN),
            new Srafiran(10, Color.BLUE), 
            new Pobarvan(Color.YELLOW),
            new Srafiran(7, Color.RED),
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);
        diagram.sproziRisanje(args);
    }

    // [i][j] = j-ti podatek (od spodaj navzgor) v i-tem stolpcu
    private double[][] podatki;

    // [j] = pravokotnik za j-ti podatek (od spodaj navzgor) v posameznih stolpcih
    private Slog[] slogi;

    public NalozeniStolpicniDiagram(double[][] podatki, Slog[] slogi) {
        this.podatki = podatki;
        this.slogi = slogi;
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

    public double sirinaStolpca(double wp, double hp) {
        // popravite / dopolnite ...
        return 0.0;
    }

    public double visinaEnote(double wp, double hp) {
        // popravite / dopolnite ...
        return 0.0;
    }
}

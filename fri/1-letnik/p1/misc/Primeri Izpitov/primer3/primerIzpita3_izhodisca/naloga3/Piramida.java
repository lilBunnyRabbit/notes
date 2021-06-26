
/**
 * NALOGA 3
 */

import java.awt.*;
import java.util.*;

public class Piramida extends Platno {

    public static void main(String[] args) {
        Piramida piramida = new Piramida(4);
        piramida.sproziRisanje(args);
    }

    private int visina;   // vi"sina piramide

    public Piramida(int visina) {
        this.visina = visina;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //
    // Za zaokro"zevanje double -> int uporabite metodo ri, npr. ri(2.7) = 3.
    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double sirinaBloka(double wp, double hp) {
        return 0.0;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double visinaBloka(double wp, double hp) {
        return 0.0;
    }
}

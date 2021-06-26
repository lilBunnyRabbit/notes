// _NE_ODSTRANI_

import java.awt.Color;

public class Test20 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, T)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, T)}}, new Igra.Figura[]{});
        igra.sproziRisanje(new String[]{"rezultat20.png", "940x940"});
    }
}

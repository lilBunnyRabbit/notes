// _NE_ODSTRANI_

import java.awt.Color;

public class Test44 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, F, F, F), new Igra.Celica(F, F, F, T), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, F, T), new Igra.Celica(F, F, T, F)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, F, T), new Igra.Celica(F, F, T, T)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, T, T)}}, new Igra.Figura[]{new Igra.Duh(3, 1, Color.RED), new Igra.Duh(4, 1, Color.BLUE), new Igra.Duh(3, 3, Color.GREEN)});
        igra.sproziRisanje(new String[]{"rezultat44.png", "860x990"});
    }
}

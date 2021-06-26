// _NE_ODSTRANI_

import java.awt.Color;

public class Test43 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, T)}, {new Igra.Celica(T, T, F, F), new Igra.Celica(F, F, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, T)}}, new Igra.Figura[]{new Igra.Duh(2, 0, Color.GREEN), new Igra.Duh(0, 2, Color.GREEN)});
        igra.sproziRisanje(new String[]{"rezultat43.png", "690x600"});
    }
}

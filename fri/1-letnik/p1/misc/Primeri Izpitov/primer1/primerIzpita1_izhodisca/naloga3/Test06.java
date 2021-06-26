// _NE_ODSTRANI_

import java.awt.Color;

public class Test06 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        Igra igra = new Igra(
            new Igra.Celica[][]{
                { new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, T, F) },
                { new Igra.Celica(T, F, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, F) },
                { new Igra.Celica(T, F, F, T), new Igra.Celica(F, T, F, T), new Igra.Celica(F, F, T, T) },
            },
            new Igra.Figura[0]
        );

        igra.sproziRisanje(new String[]{"rezultat06.png", "400x700"});
    }
}

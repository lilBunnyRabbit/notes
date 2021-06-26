// _NE_ODSTRANI_

import java.awt.Color;

public class Test09 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        Igra igra = new Igra(
            new Igra.Celica[][]{
                { new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, F, F), new Igra.Celica(F, T, T, F) },
                { new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, F, T), new Igra.Celica(F, F, T, T), new Igra.Celica(T, F, T, F) },
                { new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, F, F), new Igra.Celica(F, F, T, T) },
                { new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, T, T, T) },
            },
            new Igra.Figura[]{
                new Igra.Pacman(1, 1, Color.RED), new Igra.Duh(3, 1, Color.BLUE),
                new Igra.Pacman(0, 3, Color.GREEN), new Igra.Duh(2, 2, Color.ORANGE)
            }
        );

        igra.sproziRisanje(new String[]{"rezultat09.png", "500x700"});
    }
}

// _NE_ODSTRANI_

import java.awt.Color;

public class Test38 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, F, T, F)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, T, T)}}, new Igra.Figura[]{new Igra.Pacman(2, 0, Color.RED), new Igra.Pacman(2, 2, Color.BLUE), new Igra.Pacman(1, 0, Color.GREEN)});
        igra.sproziRisanje(new String[]{"rezultat38.png", "850x560"});
    }
}

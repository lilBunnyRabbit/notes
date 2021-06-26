// _NE_ODSTRANI_

import java.awt.Color;

public class Test48 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, F, F), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, F, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, F, T, F), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, F, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, T, T), new Igra.Celica(T, F, T, T)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, F, T), new Igra.Celica(F, T, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, T, F), new Igra.Celica(T, F, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, F)}, {new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, F, T), new Igra.Celica(F, T, T, T), new Igra.Celica(T, F, T, F)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, T)}}, new Igra.Figura[]{new Igra.Pacman(3, 3, Color.BLUE), new Igra.Pacman(1, 3, Color.BLUE), new Igra.Pacman(4, 4, Color.GREEN), new Igra.Duh(4, 3, Color.GREEN), new Igra.Pacman(0, 1, Color.GREEN), new Igra.Duh(0, 3, Color.GREEN)});
        igra.sproziRisanje(new String[]{"rezultat48.png", "540x550"});
    }
}

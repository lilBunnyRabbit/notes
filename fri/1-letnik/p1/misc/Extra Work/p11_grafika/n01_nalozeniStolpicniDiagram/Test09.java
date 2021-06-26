// _NE_ODSTRANI_

import java.awt.*;

public class Test09 {

    public static void main(String[] args) {
        double[][] podatki = {
            { 1.0 },
            { 2.0 },
            { 3.0 },
            { 2.0 },
            { 1.0 },
        };

        NalozeniStolpicniDiagram.Slog[] slogi = {
            new NalozeniStolpicniDiagram.Pobarvan(Color.YELLOW)
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);
        diagram.sproziRisanje(new String[]{"rezultat09.png", "500x500"});
    }
}

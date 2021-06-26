// _NE_ODSTRANI_

import java.awt.*;

public class Test08 {

    public static void main(String[] args) {
        double[][] podatki = {
            { 0.1 },
        };

        NalozeniStolpicniDiagram.Slog[] slogi = {
            new NalozeniStolpicniDiagram.Srafiran(20, Color.CYAN.darker())
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);
        diagram.sproziRisanje(new String[]{"rezultat08.png", "640x480"});
    }
}

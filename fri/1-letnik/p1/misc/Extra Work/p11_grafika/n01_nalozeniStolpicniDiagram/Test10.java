// _NE_ODSTRANI_

import java.awt.*;

public class Test10 {

    public static void main(String[] args) {
        double[][] podatki = {
            { 1.0, 2.0, 1.0, 3.0, 1.0, 4.0, 1.0, 3.0, 1.0, 2.0, 1.0 },
            { 4.0, 1.0, 3.0, 1.0, 2.0, 1.0, 2.0, 1.0, 3.0, 1.0, 4.0 }
        };

        NalozeniStolpicniDiagram.Slog[] slogi = {
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED),
            new NalozeniStolpicniDiagram.Srafiran(3, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED),
            new NalozeniStolpicniDiagram.Srafiran(6, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED),
            new NalozeniStolpicniDiagram.Srafiran(9, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED),
            new NalozeniStolpicniDiagram.Srafiran(6, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED),
            new NalozeniStolpicniDiagram.Srafiran(3, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.RED)
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);
        diagram.sproziRisanje(new String[]{"rezultat10.png", "200x770"});
    }
}

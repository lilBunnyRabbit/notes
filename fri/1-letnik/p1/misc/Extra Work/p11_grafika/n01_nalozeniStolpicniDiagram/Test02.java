
import java.awt.*;

public class Test02 {

    public static void main(String[] args) {
        double[][] podatki = {
            { 3.0, 2.0, 5.0, 6.0 },
            { 7.0, 4.0, 8.0, 1.0 },
            { 2.0, 5.0, 1.0, 9.0 },
            { 4.0, 2.0, 3.0, 1.0 },
            { 6.0, 0.0, 5.0, 3.0 }
        };

        NalozeniStolpicniDiagram.Slog[] slogi = {
            new NalozeniStolpicniDiagram.Pobarvan(Color.GREEN),
            new NalozeniStolpicniDiagram.Srafiran(10, Color.BLUE),
            new NalozeniStolpicniDiagram.Pobarvan(Color.YELLOW),
            new NalozeniStolpicniDiagram.Srafiran(7, Color.RED),
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);

        System.out.println(Platno.ri(diagram.visinaEnote(500, 500)));
        System.out.println(Platno.ri(diagram.visinaEnote(600, 760)));
        System.out.println(Platno.ri(diagram.visinaEnote(800, 400)));
    }
}

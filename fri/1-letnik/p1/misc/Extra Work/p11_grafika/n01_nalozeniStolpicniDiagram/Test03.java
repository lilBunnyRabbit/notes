
import java.awt.*;

public class Test03 {

    public static void main(String[] args) {
        double[][] podatki = {
            { 7.0, 2.5, 3.6, 4.1, 5.2 },
            { 3.7, 8.2, 2.9, 1.6, 4.8 },
            { 6.4, 5.8, 7.9, 9.1, 3.5 }
        };

        NalozeniStolpicniDiagram.Slog[] slogi = {
            new NalozeniStolpicniDiagram.Srafiran(5, new Color(0, 128, 0)),
            new NalozeniStolpicniDiagram.Srafiran(1, new Color(128, 0, 0)),
            new NalozeniStolpicniDiagram.Pobarvan(Color.MAGENTA),
            new NalozeniStolpicniDiagram.Pobarvan(Color.YELLOW),
            new NalozeniStolpicniDiagram.Srafiran(2, Color.BLUE)
        };

        NalozeniStolpicniDiagram diagram = new NalozeniStolpicniDiagram(podatki, slogi);

        System.out.println(Platno.ri(diagram.sirinaStolpca(750, 750)));
        System.out.println(Platno.ri(diagram.visinaEnote(750, 750)));

        System.out.println(Platno.ri(diagram.sirinaStolpca(1200, 400)));
        System.out.println(Platno.ri(diagram.visinaEnote(1200, 400)));

        System.out.println(Platno.ri(diagram.sirinaStolpca(300, 1000)));
        System.out.println(Platno.ri(diagram.visinaEnote(300, 1000)));
    }
}

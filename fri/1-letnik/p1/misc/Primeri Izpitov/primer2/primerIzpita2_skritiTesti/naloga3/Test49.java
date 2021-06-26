// _NE_ODSTRANI_

public class Test49 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 4, 7),
            new Diagram.Skatla(1, 0, 3),
            new Diagram.Skatla(1, 7, 2),
            new Diagram.Skatla(1, 1, 11),
            new Diagram.Skatla(1, 0, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[0]), new Diagram.Povezava(skatle[0], skatle[3]), new Diagram.Povezava(skatle[1], skatle[1]), new Diagram.Povezava(skatle[1], skatle[2]), new Diagram.Povezava(skatle[1], skatle[3]), new Diagram.Povezava(skatle[2], skatle[1]), new Diagram.Povezava(skatle[2], skatle[4]), new Diagram.Povezava(skatle[4], skatle[1])}, 12, 5);
        diagram.sproziRisanje(new String[]{"rezultat49.png", "450x200"});
    }
}

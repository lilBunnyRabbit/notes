// _NE_ODSTRANI_

public class Test43 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(4, 11, 10),
            new Diagram.Skatla(2, 6, 8),
            new Diagram.Skatla(1, 11, 6),
            new Diagram.Skatla(2, 12, 2),
            new Diagram.Skatla(5, 1, 4),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[1]), new Diagram.Povezava(skatle[1], skatle[2]), new Diagram.Povezava(skatle[2], skatle[0]), new Diagram.Povezava(skatle[3], skatle[4]), new Diagram.Povezava(skatle[4], skatle[0]), new Diagram.Povezava(skatle[4], skatle[3])}, 14, 1);
        diagram.sproziRisanje(new String[]{"rezultat43.png", "330x790"});
    }
}

// _NE_ODSTRANI_

public class Test39 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 4, 4),
            new Diagram.Skatla(2, 2, 12),
            new Diagram.Skatla(1, 6, 8),
            new Diagram.Skatla(1, 0, 1),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[2]), new Diagram.Povezava(skatle[2], skatle[3])}, 15, 5);
        diagram.sproziRisanje(new String[]{"rezultat39.png", "500x440"});
    }
}

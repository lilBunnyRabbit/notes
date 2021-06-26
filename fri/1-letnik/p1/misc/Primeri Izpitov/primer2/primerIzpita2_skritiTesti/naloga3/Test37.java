// _NE_ODSTRANI_

public class Test37 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(5, 7, 3),
            new Diagram.Skatla(2, 3, 12),
            new Diagram.Skatla(2, 10, 4),
            new Diagram.Skatla(4, 11, 9),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[3]), new Diagram.Povezava(skatle[3], skatle[3])}, 14, 1);
        diagram.sproziRisanje(new String[]{"rezultat37.png", "520x570"});
    }
}

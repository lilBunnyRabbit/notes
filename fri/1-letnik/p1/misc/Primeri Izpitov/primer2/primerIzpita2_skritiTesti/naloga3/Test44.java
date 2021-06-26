// _NE_ODSTRANI_

public class Test44 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 6, 2),
            new Diagram.Skatla(5, 9, 5),
            new Diagram.Skatla(3, 0, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[0]), new Diagram.Povezava(skatle[1], skatle[1]), new Diagram.Povezava(skatle[2], skatle[0])}, 11, 1);
        diagram.sproziRisanje(new String[]{"rezultat44.png", "650x680"});
    }
}

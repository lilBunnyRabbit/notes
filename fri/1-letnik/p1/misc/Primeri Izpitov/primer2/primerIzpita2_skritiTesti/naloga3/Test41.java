// _NE_ODSTRANI_

public class Test41 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 0, 3),
            new Diagram.Skatla(1, 0, 6),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[0])}, 10, 5);
        diagram.sproziRisanje(new String[]{"rezultat41.png", "460x490"});
    }
}

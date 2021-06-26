// _NE_ODSTRANI_

public class Test45 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(3, 6, 7),
            new Diagram.Skatla(4, 5, 0),
            new Diagram.Skatla(5, 1, 5),
            new Diagram.Skatla(3, 0, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[1])}, 10, 2);
        diagram.sproziRisanje(new String[]{"rezultat45.png", "600x780"});
    }
}

// _NE_ODSTRANI_

public class Test40 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 10, 15),
            new Diagram.Skatla(2, 7, 5),
            new Diagram.Skatla(1, 1, 9),
            new Diagram.Skatla(1, 1, 16),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[2])}, 18, 5);
        diagram.sproziRisanje(new String[]{"rezultat40.png", "700x800"});
    }
}

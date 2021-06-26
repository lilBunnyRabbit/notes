// _NE_ODSTRANI_

public class Test20 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(10, 6, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 12, 4);
        diagram.sproziRisanje(new String[]{"rezultat20.png", "270x270"});
    }
}

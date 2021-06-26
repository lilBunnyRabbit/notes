// _NE_ODSTRANI_

public class Test33 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(8, 4, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 13, 6);
        diagram.sproziRisanje(new String[]{"rezultat33.png", "520x520"});
    }
}

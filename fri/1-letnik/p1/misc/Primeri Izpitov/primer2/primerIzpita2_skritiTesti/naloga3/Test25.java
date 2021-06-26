// _NE_ODSTRANI_

public class Test25 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 1, 6),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 13, 7);
        diagram.sproziRisanje(new String[]{"rezultat25.png", "230x230"});
    }
}

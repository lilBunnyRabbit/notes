// _NE_ODSTRANI_

public class Test28 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(9, 0, 8),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 19, 19);
        diagram.sproziRisanje(new String[]{"rezultat28.png", "590x590"});
    }
}

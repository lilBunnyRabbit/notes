// _NE_ODSTRANI_

public class Test29 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(8, 1, 1),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 16, 14);
        diagram.sproziRisanje(new String[]{"rezultat29.png", "540x540"});
    }
}

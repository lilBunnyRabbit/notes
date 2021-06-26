// _NE_ODSTRANI_

public class Test23 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(7, 3, 3),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 18, 5);
        diagram.sproziRisanje(new String[]{"rezultat23.png", "650x650"});
    }
}

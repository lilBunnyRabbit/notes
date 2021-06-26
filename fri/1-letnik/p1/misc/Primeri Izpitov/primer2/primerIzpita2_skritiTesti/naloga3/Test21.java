// _NE_ODSTRANI_

public class Test21 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(18, 0, 1),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 19, 19);
        diagram.sproziRisanje(new String[]{"rezultat21.png", "760x760"});
    }
}

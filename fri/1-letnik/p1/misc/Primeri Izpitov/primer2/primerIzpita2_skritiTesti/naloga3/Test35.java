// _NE_ODSTRANI_

public class Test35 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(19, 4, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 20, 2);
        diagram.sproziRisanje(new String[]{"rezultat35.png", "610x610"});
    }
}

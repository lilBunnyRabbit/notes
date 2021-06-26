// _NE_ODSTRANI_

public class Test18 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(5, 7, 6),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 17, 7);
        diagram.sproziRisanje(new String[]{"rezultat18.png", "610x610"});
    }
}

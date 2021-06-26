// _NE_ODSTRANI_

public class Test34 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(6, 7, 4),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 10, 1);
        diagram.sproziRisanje(new String[]{"rezultat34.png", "790x790"});
    }
}

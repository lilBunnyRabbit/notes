// _NE_ODSTRANI_

public class Test30 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 2, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 10, 1);
        diagram.sproziRisanje(new String[]{"rezultat30.png", "430x430"});
    }
}

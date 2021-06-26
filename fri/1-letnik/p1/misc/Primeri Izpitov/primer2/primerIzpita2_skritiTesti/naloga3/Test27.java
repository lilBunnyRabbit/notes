// _NE_ODSTRANI_

public class Test27 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(7, 0, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 18, 18);
        diagram.sproziRisanje(new String[]{"rezultat27.png", "720x720"});
    }
}

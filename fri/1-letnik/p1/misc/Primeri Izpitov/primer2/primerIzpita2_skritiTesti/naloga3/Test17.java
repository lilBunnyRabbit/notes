// _NE_ODSTRANI_

public class Test17 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(18, 1, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 20, 15);
        diagram.sproziRisanje(new String[]{"rezultat17.png", "250x250"});
    }
}

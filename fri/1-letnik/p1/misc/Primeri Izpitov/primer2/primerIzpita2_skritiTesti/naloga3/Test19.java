// _NE_ODSTRANI_

public class Test19 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(4, 5, 9),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 17, 10);
        diagram.sproziRisanje(new String[]{"rezultat19.png", "360x360"});
    }
}

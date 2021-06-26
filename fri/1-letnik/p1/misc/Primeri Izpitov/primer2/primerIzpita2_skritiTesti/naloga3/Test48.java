// _NE_ODSTRANI_

public class Test48 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(4, 9, 1),
            new Diagram.Skatla(3, 13, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[0])}, 18, 2);
        diagram.sproziRisanje(new String[]{"rezultat48.png", "640x660"});
    }
}

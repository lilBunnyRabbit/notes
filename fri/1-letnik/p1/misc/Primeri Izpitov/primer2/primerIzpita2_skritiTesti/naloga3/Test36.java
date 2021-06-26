// _NE_ODSTRANI_

public class Test36 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(5, 7, 5),
            new Diagram.Skatla(5, 0, 0),
            new Diagram.Skatla(1, 0, 11),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[0]), new Diagram.Povezava(skatle[1], skatle[0])}, 13, 5);
        diagram.sproziRisanje(new String[]{"rezultat36.png", "680x420"});
    }
}

// _NE_ODSTRANI_

public class Test50 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(5, 19, 5),
            new Diagram.Skatla(1, 15, 19),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[1])}, 20, 1);
        diagram.sproziRisanje(new String[]{"rezultat50.png", "320x450"});
    }
}

// _NE_ODSTRANI_

public class Test46 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(4, 3, 0),
            new Diagram.Skatla(1, 2, 9),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[1], skatle[1])}, 10, 4);
        diagram.sproziRisanje(new String[]{"rezultat46.png", "290x350"});
    }
}

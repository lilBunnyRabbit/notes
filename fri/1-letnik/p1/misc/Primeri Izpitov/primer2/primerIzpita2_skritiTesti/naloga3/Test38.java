// _NE_ODSTRANI_

public class Test38 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 8, 5),
            new Diagram.Skatla(5, 4, 2),
            new Diagram.Skatla(2, 10, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[0]), new Diagram.Povezava(skatle[2], skatle[2])}, 11, 1);
        diagram.sproziRisanje(new String[]{"rezultat38.png", "510x360"});
    }
}

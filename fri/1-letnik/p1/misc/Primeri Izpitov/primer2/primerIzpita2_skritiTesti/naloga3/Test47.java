// _NE_ODSTRANI_

public class Test47 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 11, 14),
            new Diagram.Skatla(5, 15, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[1])}, 20, 5);
        diagram.sproziRisanje(new String[]{"rezultat47.png", "650x350"});
    }
}

// _NE_ODSTRANI_

public class Test42 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(3, 4, 5),
            new Diagram.Skatla(4, 9, 11),
            new Diagram.Skatla(2, 2, 12),
            new Diagram.Skatla(3, 13, 1),
            new Diagram.Skatla(1, 11, 8),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{new Diagram.Povezava(skatle[0], skatle[2]), new Diagram.Povezava(skatle[1], skatle[1]), new Diagram.Povezava(skatle[2], skatle[0]), new Diagram.Povezava(skatle[2], skatle[2]), new Diagram.Povezava(skatle[2], skatle[4]), new Diagram.Povezava(skatle[3], skatle[2]), new Diagram.Povezava(skatle[4], skatle[1]), new Diagram.Povezava(skatle[4], skatle[2]), new Diagram.Povezava(skatle[4], skatle[3])}, 17, 3);
        diagram.sproziRisanje(new String[]{"rezultat42.png", "350x380"});
    }
}

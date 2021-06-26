// _NE_ODSTRANI_

public class Test32 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(6, 1, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 10, 2);
        diagram.sproziRisanje(new String[]{"rezultat32.png", "770x770"});
    }
}

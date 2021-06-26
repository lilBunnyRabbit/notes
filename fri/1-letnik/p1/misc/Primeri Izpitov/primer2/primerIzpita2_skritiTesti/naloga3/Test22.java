// _NE_ODSTRANI_

public class Test22 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(8, 2, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 13, 1);
        diagram.sproziRisanje(new String[]{"rezultat22.png", "270x270"});
    }
}

// _NE_ODSTRANI_

public class Test26 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(8, 2, 7),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 19, 4);
        diagram.sproziRisanje(new String[]{"rezultat26.png", "460x460"});
    }
}

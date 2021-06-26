// _NE_ODSTRANI_

public class Test24 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(5, 1, 7),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 12, 11);
        diagram.sproziRisanje(new String[]{"rezultat24.png", "750x750"});
    }
}

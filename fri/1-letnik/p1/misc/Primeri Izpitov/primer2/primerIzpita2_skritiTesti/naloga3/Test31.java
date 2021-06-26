// _NE_ODSTRANI_

public class Test31 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 7, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 18, 7);
        diagram.sproziRisanje(new String[]{"rezultat31.png", "530x530"});
    }
}

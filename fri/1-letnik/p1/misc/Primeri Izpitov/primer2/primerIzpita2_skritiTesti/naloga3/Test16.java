// _NE_ODSTRANI_

public class Test16 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 2, 7),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[]{}, 11, 2);
        diagram.sproziRisanje(new String[]{"rezultat16.png", "780x780"});
    }
}

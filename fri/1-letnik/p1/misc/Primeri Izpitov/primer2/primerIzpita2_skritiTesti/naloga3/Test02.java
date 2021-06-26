
public class Test02 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 0, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 10, 2);
        System.out.println(Platno.ri(diagram.sirinaSkatle(100, 100)));
    }
}

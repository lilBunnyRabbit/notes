
public class Test04 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 0, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 100, 1);
        System.out.println(Platno.ri(diagram.sirinaSkatle(300, 200)));
    }
}


public class Test14 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(4, 1, 2),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 10, 3);
        double[] koord = diagram.sredisceSkatle(skatle[0], 500, 600);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}

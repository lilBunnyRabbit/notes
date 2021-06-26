
public class Test15 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(6, 12, 6),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 20, 5);
        double[] koord = diagram.sredisceSkatle(skatle[0], 750, 250);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}


public class Test11 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 0, 0),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 10, 1);
        double[] koord = diagram.sredisceSkatle(skatle[0], 300, 300);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}
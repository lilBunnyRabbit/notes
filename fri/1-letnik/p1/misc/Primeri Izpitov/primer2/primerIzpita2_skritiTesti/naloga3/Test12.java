
public class Test12 {

    public static void main(String[] args) {
        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(1, 3, 5),
        };
        Diagram diagram = new Diagram(skatle, new Diagram.Povezava[0], 10, 1);
        double[] koord = diagram.sredisceSkatle(skatle[0], 200, 500);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}

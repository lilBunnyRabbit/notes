
public class Test15 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(5);
        for (int i = 0;  i < 27;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}


public class Test13 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(21);
        for (int i = 0;  i < 24;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}
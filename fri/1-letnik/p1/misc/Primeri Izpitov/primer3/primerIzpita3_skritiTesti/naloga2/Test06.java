
public class Test06 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(21);
        for (int i = 0;  i < 21;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}


public class Test07 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(40);
        for (int i = 0;  i < 12;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}

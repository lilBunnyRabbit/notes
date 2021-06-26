
public class Test05 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(8);
        for (int i = 0;  i < 17;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}


public class Test27 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(16);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.naslednje();
        System.out.println( z.katero() );
        z.naslednje();
        z.naslednje();
        System.out.println( z.katero() );
        z.naslednje();
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.naslednje();
        z.naslednje();
    }
}

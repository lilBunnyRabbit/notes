
public class Test21 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(30);
        z.naslednje();
        z.naslednje();
        z.naslednje();
        z.naslednje();
        z.naslednje();
        System.out.println( z.katero() );
        z.naslednje();
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.naslednje();
        z.naslednje();
        z.naslednje();
        System.out.println( z.katero() );
    }
}

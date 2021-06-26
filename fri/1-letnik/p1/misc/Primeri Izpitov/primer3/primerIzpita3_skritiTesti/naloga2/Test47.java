
public class Test47 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(24);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(15);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(13);
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        System.out.println( z.katero() );
        z.ponastavi(3);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
    }
}

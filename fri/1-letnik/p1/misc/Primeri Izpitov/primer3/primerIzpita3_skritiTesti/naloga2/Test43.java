
public class Test43 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(6);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(15);
        z.ponastavi(26);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(5);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(21);
        System.out.println( z.naslednje() );
        z.ponastavi(20);
        z.ponastavi(20);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
    }
}

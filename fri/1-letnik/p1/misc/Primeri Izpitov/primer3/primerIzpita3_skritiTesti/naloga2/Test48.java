
public class Test48 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(16);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(22);
        z.ponastavi(2);
        System.out.println( z.naslednje() );
        z.ponastavi(2);
        z.ponastavi(3);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(13);
        z.ponastavi(17);
        z.ponastavi(3);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(11);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(2);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(7);
        z.ponastavi(27);
    }
}

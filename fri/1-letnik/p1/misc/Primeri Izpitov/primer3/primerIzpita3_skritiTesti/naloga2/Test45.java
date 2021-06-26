
public class Test45 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(35);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(22);
        z.ponastavi(24);
        System.out.println( z.naslednje() );
        z.ponastavi(18);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(23);
        System.out.println( z.katero() );
        z.ponastavi(10);
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        z.ponastavi(13);
        z.ponastavi(16);
        z.ponastavi(28);
        z.ponastavi(3);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(17);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(23);
        z.ponastavi(3);
    }
}


public class Test38 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(29);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(4);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(15);
        System.out.println( z.katero() );
        z.ponastavi(13);
        z.ponastavi(1);
        z.ponastavi(15);
        z.ponastavi(29);
        z.ponastavi(6);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(9);
        z.ponastavi(17);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(27);
        System.out.println( z.naslednje() );
    }
}

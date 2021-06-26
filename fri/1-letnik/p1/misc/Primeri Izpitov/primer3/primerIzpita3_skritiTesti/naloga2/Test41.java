
public class Test41 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(38);
        System.out.println( z.naslednje() );
        z.ponastavi(19);
        z.ponastavi(21);
        z.ponastavi(6);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(29);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(25);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(8);
        System.out.println( z.naslednje() );
        z.ponastavi(25);
        z.ponastavi(23);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(21);
        z.ponastavi(29);
        z.ponastavi(24);
    }
}

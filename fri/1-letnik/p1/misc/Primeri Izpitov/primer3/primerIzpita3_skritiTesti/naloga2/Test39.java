
public class Test39 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(22);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(1);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(19);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(15);
        System.out.println( z.naslednje() );
        z.ponastavi(23);
        z.ponastavi(28);
        System.out.println( z.naslednje() );
        z.ponastavi(23);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(15);
        System.out.println( z.naslednje() );
    }
}

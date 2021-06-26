
public class Test44 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(6);
        z.ponastavi(17);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(30);
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        System.out.println( z.naslednje() );
        z.ponastavi(19);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(15);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(9);
        z.ponastavi(23);
        z.ponastavi(13);
        System.out.println( z.katero() );
    }
}

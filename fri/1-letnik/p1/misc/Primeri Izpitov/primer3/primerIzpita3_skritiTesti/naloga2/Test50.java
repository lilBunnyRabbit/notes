
public class Test50 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(24);
        System.out.println( z.katero() );
        z.ponastavi(18);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(4);
        System.out.println( z.katero() );
        z.ponastavi(6);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(24);
        z.ponastavi(19);
        z.ponastavi(26);
        z.ponastavi(10);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(21);
        z.ponastavi(28);
    }
}

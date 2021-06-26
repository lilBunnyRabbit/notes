
public class Test49 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(38);
        z.ponastavi(4);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(26);
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        z.ponastavi(21);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(4);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(26);
        System.out.println( z.katero() );
        z.ponastavi(1);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(30);
        z.ponastavi(17);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
    }
}

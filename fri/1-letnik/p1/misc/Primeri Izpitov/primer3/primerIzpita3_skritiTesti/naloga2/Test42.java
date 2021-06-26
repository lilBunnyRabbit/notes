
public class Test42 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(35);
        z.ponastavi(21);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(20);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(14);
        z.ponastavi(14);
        System.out.println( z.naslednje() );
        z.ponastavi(23);
        z.ponastavi(25);
        z.ponastavi(2);
        System.out.println( z.naslednje() );
        z.ponastavi(1);
        z.ponastavi(8);
        z.ponastavi(16);
        z.ponastavi(9);
        z.ponastavi(10);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(7);
        System.out.println( z.katero() );
    }
}

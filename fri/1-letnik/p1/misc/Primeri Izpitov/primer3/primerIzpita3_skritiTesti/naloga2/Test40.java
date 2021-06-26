
public class Test40 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(40);
        z.ponastavi(2);
        z.ponastavi(7);
        System.out.println( z.naslednje() );
        z.ponastavi(3);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(19);
        System.out.println( z.naslednje() );
        z.ponastavi(28);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        z.ponastavi(7);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(16);
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.ponastavi(26);
        System.out.println( z.katero() );
        z.ponastavi(1);
        z.ponastavi(1);
        z.ponastavi(30);
        System.out.println( z.katero() );
        z.ponastavi(21);
        System.out.println( z.naslednje() );
        z.ponastavi(30);
        z.ponastavi(7);
        System.out.println( z.katero() );
        z.ponastavi(24);
        System.out.println( z.naslednje() );
        z.ponastavi(11);
        System.out.println( z.naslednje() );
        z.ponastavi(18);
        z.ponastavi(5);
    }
}

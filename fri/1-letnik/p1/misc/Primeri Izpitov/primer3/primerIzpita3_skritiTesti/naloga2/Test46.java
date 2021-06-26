
public class Test46 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(33);
        z.ponastavi(6);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(2);
        z.ponastavi(17);
        System.out.println( z.naslednje() );
        z.ponastavi(2);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        z.ponastavi(4);
        System.out.println( z.naslednje() );
        z.ponastavi(11);
        z.ponastavi(10);
        z.ponastavi(2);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        z.ponastavi(14);
        System.out.println( z.katero() );
    }
}

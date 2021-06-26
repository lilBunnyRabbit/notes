
public class Test24 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(35);
        z.naslednje();
        z.naslednje();
        System.out.println( z.katero() );
        z.naslednje();
        z.naslednje();
        z.naslednje();
        z.naslednje();
        z.naslednje();
        System.out.println( z.katero() );
        System.out.println( z.katero() );
        z.naslednje();
    }
}

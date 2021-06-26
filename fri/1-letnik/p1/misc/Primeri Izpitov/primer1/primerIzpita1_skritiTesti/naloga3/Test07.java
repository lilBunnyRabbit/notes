
public class Test07 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, T, F)}, {new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, F, T), new Igra.Celica(F, F, T, T)}}, new Igra.Figura[]{});
        double[] koord = igra.zgorajLevo(760, 510);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}

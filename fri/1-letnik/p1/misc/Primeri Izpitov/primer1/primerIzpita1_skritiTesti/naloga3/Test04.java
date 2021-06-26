
public class Test04 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, F, F), new Igra.Celica(F, F, T, T), new Igra.Celica(T, T, T, F)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, T)}}, new Igra.Figura[]{});
        System.out.println(Platno.ri(igra.stranicaCelice(640, 860)));
    }
}

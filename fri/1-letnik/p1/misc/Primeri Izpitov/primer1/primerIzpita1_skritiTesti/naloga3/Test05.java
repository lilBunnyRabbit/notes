
public class Test05 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        Igra igra = new Igra(new Igra.Celica[][]{{new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T), new Igra.Celica(T, T, T, F), new Igra.Celica(T, T, T, T)}, {new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, F, F), new Igra.Celica(F, T, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, T, F)}, {new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, T, F), new Igra.Celica(T, F, F, F), new Igra.Celica(F, F, F, T), new Igra.Celica(F, F, F, F), new Igra.Celica(F, F, F, T), new Igra.Celica(F, F, T, T)}, {new Igra.Celica(T, T, T, F), new Igra.Celica(T, F, T, T), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, F, F), new Igra.Celica(F, F, T, F), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, F, T, T), new Igra.Celica(T, T, F, F), new Igra.Celica(F, F, F, T), new Igra.Celica(F, F, F, F), new Igra.Celica(F, F, T, T), new Igra.Celica(T, T, F, T), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, T, T, T), new Igra.Celica(T, F, F, F), new Igra.Celica(F, T, F, F), new Igra.Celica(F, F, F, T), new Igra.Celica(F, T, T, F), new Igra.Celica(T, T, F, F), new Igra.Celica(F, T, T, T)}, {new Igra.Celica(T, T, F, T), new Igra.Celica(F, F, F, T), new Igra.Celica(F, F, F, T), new Igra.Celica(F, T, T, T), new Igra.Celica(T, F, F, T), new Igra.Celica(F, F, T, T), new Igra.Celica(T, T, T, T)}}, new Igra.Figura[]{});
        System.out.println(Platno.ri(igra.stranicaCelice(850, 770)));
    }
}

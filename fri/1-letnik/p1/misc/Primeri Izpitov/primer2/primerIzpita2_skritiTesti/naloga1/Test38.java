
public class Test38 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][][] g =
        {
            {
                {T, F, T, F},
                {T, T, F, T},
            },
            {
                {F, T, T, F},
                {T, F, F, T},
            },
            {
                {T, T, F, T},
                {T, T, F, T},
            },
        };
        System.out.println(Park.najboljProstoNadstropje(g));   // 2
    }
}

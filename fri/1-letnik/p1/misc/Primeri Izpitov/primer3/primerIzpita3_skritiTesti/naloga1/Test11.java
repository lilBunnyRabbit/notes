
public class Test11 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, T, F, F, F, T, F, T, F},
            {T, F, T, F, F, T, F, F, F, T},
            {T, T, F, T, T, F, F, F, F, T},
            {F, F, T, F, F, T, F, F, F, F},
            {F, F, T, F, F, T, T, F, F, T},
            {F, T, F, T, T, F, F, F, T, F},
            {T, F, F, F, T, F, F, T, F, F},
            {F, F, F, F, F, F, T, F, T, F},
            {T, F, F, F, F, T, F, T, F, T},
            {F, T, T, F, T, F, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m1));

        boolean[][] m2 = {
            {F, T, F, T, F, F, F, F, F, T},
            {T, F, T, F, T, F, T, F, F, F},
            {F, T, F, T, T, T, T, T, T, T},
            {T, F, T, F, F, F, F, F, F, F},
            {F, T, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, F, F, F, T, F},
            {F, T, T, F, F, F, F, T, T, T},
            {F, F, T, F, F, F, T, F, F, F},
            {F, F, T, F, F, T, T, F, F, T},
            {T, F, T, F, F, F, T, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m2));

        boolean[][] m3 = {
            {F, T, T, T, T, T, T, T, F, T},
            {T, F, F, T, T, T, T, T, T, T},
            {T, F, F, F, T, F, F, F, F, F},
            {T, T, F, F, F, T, F, F, T, F},
            {T, T, T, F, F, F, F, F, F, T},
            {T, T, F, T, F, F, T, F, F, F},
            {T, T, F, F, F, T, F, T, F, F},
            {T, T, F, F, F, F, T, F, T, F},
            {F, T, F, T, F, F, F, T, F, T},
            {T, T, F, F, T, F, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m3));

        boolean[][] m4 = {
            {F, T, F, T, T, F, F, T, F, F},
            {T, F, T, F, F, F, F, F, F, F},
            {F, T, F, T, T, T, T, T, T, T},
            {T, F, T, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, T, T, T, F},
            {F, F, T, F, F, F, F, F, T, F},
            {F, F, T, F, T, F, F, F, F, F},
            {T, F, T, F, T, F, F, F, F, T},
            {F, F, T, F, T, T, F, F, F, T},
            {F, F, T, F, F, F, F, T, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m4));

        boolean[][] m5 = {
            {F, T, T, F, F, F, F, F, F, F},
            {T, F, T, T, T, T, T, T, F, T},
            {T, T, F, F, F, T, F, T, F, T},
            {F, T, F, F, F, F, F, T, T, T},
            {F, T, F, F, F, T, T, T, T, T},
            {F, T, T, F, T, F, T, T, T, T},
            {F, T, F, F, T, T, F, T, T, T},
            {F, T, T, T, T, T, T, F, T, F},
            {F, F, F, T, T, T, T, T, F, T},
            {F, T, T, T, T, T, T, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m5));

        boolean[][] m6 = {
            {F, T, T, T, F, T, T, F, F, T},
            {T, F, T, T, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, F, F, T, T, F, F, F, F},
            {F, F, F, T, F, T, T, T, F, F},
            {T, F, F, T, T, F, F, F, T, F},
            {T, F, F, F, T, F, F, T, T, T},
            {F, F, F, F, T, F, T, F, F, F},
            {F, F, F, F, F, T, T, F, F, F},
            {T, F, F, F, F, F, T, F, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m6));

        boolean[][] m7 = {
            {F, T, F, F, F, F, T, F, F, F},
            {T, F, T, T, T, T, F, T, T, F},
            {F, T, F, T, T, F, F, F, F, T},
            {F, T, T, F, T, T, F, T, T, T},
            {F, T, T, T, F, F, F, F, T, F},
            {F, T, F, T, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, T, T, T},
            {F, T, F, T, F, F, T, F, T, F},
            {F, T, F, T, T, F, T, T, F, T},
            {F, F, T, T, F, F, T, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m7));

        boolean[][] m8 = {
            {F, T, T, F, F, T, F, F, F, T},
            {T, F, F, T, T, F, F, F, F, T},
            {T, F, F, T, T, T, T, T, T, T},
            {F, T, T, F, F, F, T, F, T, F},
            {F, T, T, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F},
            {F, F, T, T, F, F, F, F, F, F},
            {F, F, T, F, F, F, F, F, F, T},
            {F, F, T, T, F, F, F, F, F, F},
            {T, T, T, F, F, F, F, T, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m8));

        boolean[][] m9 = {
            {F, T, T, T, T, T, F, F, F, F},
            {T, F, T, F, F, F, T, T, T, F},
            {T, T, F, T, T, T, T, T, T, T},
            {T, F, T, F, F, F, F, F, F, F},
            {T, F, T, F, F, T, F, F, T, F},
            {T, F, T, F, T, F, T, T, T, F},
            {F, T, T, F, F, T, F, F, F, T},
            {F, T, T, F, F, T, F, F, F, T},
            {F, T, T, F, T, T, F, F, F, F},
            {F, F, T, F, F, F, T, T, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m9));

        boolean[][] m10 = {
            {F, T, T, T, T, F, T, T, T, T},
            {T, F, T, F, F, T, T, T, T, T},
            {T, T, F, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, T, T, T},
            {T, F, F, F, F, F, F, F, F, T},
            {F, T, F, F, F, F, F, F, T, F},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, F, T, F, F, F, F, T, F},
            {T, T, F, T, F, T, F, T, F, T},
            {T, T, F, T, T, F, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m10));

        boolean[][] m11 = {
            {F, T, F, F, F, T, F, F, F, F},
            {T, F, T, T, T, F, F, F, F, T},
            {F, T, F, F, F, F, T, F, F, F},
            {F, T, F, F, T, F, F, F, F, F},
            {F, T, F, T, F, T, F, T, T, F},
            {T, F, F, F, T, F, F, F, T, T},
            {F, F, T, F, F, F, F, T, T, T},
            {F, F, F, F, T, F, T, F, F, F},
            {F, F, F, F, T, T, T, F, F, T},
            {F, T, F, F, F, T, T, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m11));

        boolean[][] m12 = {
            {F, T, F, F, F, T, F, F, F, F},
            {T, F, T, F, T, F, F, T, F, F},
            {F, T, F, T, T, F, F, T, T, T},
            {F, F, T, F, T, F, T, T, F, F},
            {F, T, T, T, F, T, T, T, T, T},
            {T, F, F, F, T, F, T, T, T, T},
            {F, F, F, T, T, T, F, F, T, F},
            {F, T, T, T, T, T, F, F, T, F},
            {F, F, T, F, T, T, T, T, F, T},
            {F, F, T, F, T, T, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m12));

        boolean[][] m13 = {
            {F, T, T, F, F, F, T, T, F, F},
            {T, F, F, F, F, F, F, F, F, T},
            {T, F, F, T, T, F, F, T, F, F},
            {F, F, T, F, F, T, F, F, F, F},
            {F, F, T, F, F, F, T, F, F, F},
            {F, F, F, T, F, F, F, F, T, F},
            {T, F, F, F, T, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F},
            {F, F, F, F, F, T, F, F, F, T},
            {F, T, F, F, F, F, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m13));

        boolean[][] m14 = {
            {F, T, F, T, F, F, F, F, F, F},
            {T, F, T, T, T, F, T, T, T, T},
            {F, T, F, T, T, T, F, T, T, T},
            {T, T, T, F, F, F, T, F, T, T},
            {F, T, T, F, F, T, F, F, F, T},
            {F, F, T, F, T, F, T, T, T, T},
            {F, T, F, T, F, T, F, F, T, F},
            {F, T, T, F, F, T, F, F, T, F},
            {F, T, T, T, F, T, T, T, F, F},
            {F, T, T, T, T, T, F, F, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m14));

        boolean[][] m15 = {
            {F, T, T, T, T, T, T, F, T, T},
            {T, F, T, T, T, T, F, F, F, T},
            {T, T, F, T, T, T, T, T, T, T},
            {T, T, T, F, F, T, F, F, F, F},
            {T, T, T, F, F, T, F, T, F, T},
            {T, T, T, T, T, F, T, T, F, T},
            {T, F, T, F, F, T, F, T, F, F},
            {F, F, T, F, T, T, T, F, F, F},
            {T, F, T, F, F, F, F, F, F, T},
            {T, T, T, F, T, T, F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m15));

        boolean[][] m16 = {
            {F, T, T, T, T, T, T, F, T, T},
            {T, F, T, T, F, F, T, T, T, F},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, T, F, T},
            {T, F, F, F, F, F, T, F, F, F},
            {T, F, F, F, F, F, T, F, T, T},
            {T, T, F, F, T, T, F, T, T, T},
            {F, T, F, T, F, F, T, F, F, T},
            {T, T, F, F, F, T, T, F, F, F},
            {T, F, F, T, F, T, T, T, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m16));

        boolean[][] m17 = {
            {F, T, T, F, F, F, F, F, F, F},
            {T, F, F, F, F, T, F, F, F, F},
            {T, F, F, T, T, F, F, F, T, F},
            {F, F, T, F, F, F, F, T, F, F},
            {F, F, T, F, F, T, T, T, T, T},
            {F, T, F, F, T, F, F, F, F, F},
            {F, F, F, F, T, F, F, F, F, T},
            {F, F, F, T, T, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F},
            {F, F, F, F, T, F, T, F, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m17));

        boolean[][] m18 = {
            {F, T, F, F, F, F, F, T, F, F},
            {T, F, T, F, F, F, F, F, F, F},
            {F, T, F, T, T, T, T, T, T, T},
            {F, F, T, F, T, F, T, F, F, T},
            {F, F, T, T, F, F, F, F, F, F},
            {F, F, T, F, F, F, F, F, F, T},
            {F, F, T, T, F, F, F, T, T, T},
            {T, F, T, F, F, F, T, F, T, F},
            {F, F, T, F, F, F, T, T, F, T},
            {F, F, T, T, F, T, T, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m18));

        boolean[][] m19 = {
            {F, T, F, F, F, F, F, T, F, F},
            {T, F, T, T, T, T, T, T, T, T},
            {F, T, F, T, T, T, T, T, T, T},
            {F, T, T, F, F, F, F, F, F, F},
            {F, T, T, F, F, T, T, T, T, T},
            {F, T, T, F, T, F, T, T, F, T},
            {F, T, T, F, T, T, F, F, F, F},
            {T, T, T, F, T, T, F, F, T, F},
            {F, T, T, F, T, F, F, T, F, F},
            {F, T, T, F, T, T, F, F, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m19));

        boolean[][] m20 = {
            {F, T, F, T, T, T, T, T, T, T},
            {T, F, T, T, F, T, T, T, T, T},
            {F, T, F, F, F, F, F, F, T, F},
            {T, T, F, F, T, F, T, T, T, T},
            {T, F, F, T, F, F, F, T, F, T},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, F, T, F, F, F, T, T, T},
            {T, T, F, T, T, F, T, F, T, F},
            {T, T, T, T, F, F, T, T, F, F},
            {T, T, F, T, T, F, T, F, F, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m20));
    }
}

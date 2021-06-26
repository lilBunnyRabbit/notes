
public class Test38 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, T, T, T},
            {T, F, T, T, T},
            {T, T, F, F, F},
            {T, T, F, F, T},
            {T, T, F, T, F},
        };
        int[][] s1 = {
            {1, 2, 3, 4},
            {0, 2, 3, 4},
            {0, 1},
            {0, 1, 4},
            {0, 1, 3},
        };

        boolean[][] m2 = {
            {F, T, T, F, F},
            {T, F, T, T, T},
            {T, T, F, F, F},
            {F, T, F, F, T},
            {F, T, F, T, F},
        };
        int[][] s2 = {
            {1, 2},
            {0, 2, 3, 4},
            {0, 1},
            {1, 4},
            {1, 3},
        };

        boolean[][] m3 = {
            {F, T, T, F, F},
            {T, F, T, T, F},
            {T, T, F, F, F},
            {F, T, F, F, T},
            {F, F, F, T, F},
        };
        int[][] s3 = {
            {1, 2},
            {0, 2, 3},
            {0, 1},
            {1, 4},
            {3},
        };

        boolean[][] m4 = {
            {F, T, T, F, F},
            {T, F, F, F, T},
            {T, F, F, T, T},
            {F, F, T, F, T},
            {F, T, T, T, F},
        };
        int[][] s4 = {
            {1, 2},
            {0, 4},
            {0, 3, 4},
            {2, 4},
            {1, 2, 3},
        };

        boolean[][] m5 = {
            {F, T, T, T, T},
            {T, F, T, T, T},
            {T, T, F, F, F},
            {T, T, F, F, F},
            {T, T, F, F, F},
        };
        int[][] s5 = {
            {1, 2, 3, 4},
            {0, 2, 3, 4},
            {0, 1},
            {0, 1},
            {0, 1},
        };

        boolean[][] m6 = {
            {F, T, F, T, F},
            {T, F, T, T, T},
            {F, T, F, F, T},
            {T, T, F, F, T},
            {F, T, T, T, F},
        };
        int[][] s6 = {
            {1, 3},
            {0, 2, 3, 4},
            {1, 4},
            {0, 1, 4},
            {1, 2, 3},
        };

        boolean[][] m7 = {
            {F, T, T, F, F},
            {T, F, T, F, T},
            {T, T, F, T, T},
            {F, F, T, F, T},
            {F, T, T, T, F},
        };
        int[][] s7 = {
            {1, 2},
            {0, 2, 4},
            {0, 1, 3, 4},
            {2, 4},
            {1, 2, 3},
        };

        boolean[][] m8 = {
            {F, T, F, F, T},
            {T, F, T, T, T},
            {F, T, F, T, F},
            {F, T, T, F, F},
            {T, T, F, F, F},
        };
        int[][] s8 = {
            {1, 4},
            {0, 2, 3, 4},
            {1, 3},
            {1, 2},
            {0, 1},
        };

        boolean[][] m9 = {
            {F, T, F, T, F},
            {T, F, T, T, T},
            {F, T, F, F, T},
            {T, T, F, F, F},
            {F, T, T, F, F},
        };
        int[][] s9 = {
            {1, 3},
            {0, 2, 3, 4},
            {1, 4},
            {0, 1},
            {1, 2},
        };

        boolean[][] m10 = {
            {F, T, F, T, F},
            {T, F, T, F, F},
            {F, T, F, F, T},
            {T, F, F, F, T},
            {F, F, T, T, F},
        };
        int[][] s10 = {
            {1, 3},
            {0, 2},
            {1, 4},
            {0, 4},
            {2, 3},
        };

        System.out.println(Graf.istiGraf(m1, s7));
        System.out.println(Graf.istiGraf(m2, s5));
        System.out.println(Graf.istiGraf(m3, s3));
        System.out.println(Graf.istiGraf(m4, s4));
        System.out.println(Graf.istiGraf(m5, s6));
        System.out.println(Graf.istiGraf(m6, s2));
        System.out.println(Graf.istiGraf(m7, s1));
        System.out.println(Graf.istiGraf(m8, s8));
        System.out.println(Graf.istiGraf(m9, s9));
        System.out.println(Graf.istiGraf(m10, s10));
    }
}


public class Test41 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, T, T, T, T, F, T},
            {T, F, F, T, T, T, F, F},
            {T, F, F, F, T, F, F, F},
            {T, T, F, F, F, T, F, T},
            {T, T, T, F, F, F, T, F},
            {T, T, F, T, F, F, F, T},
            {F, F, F, F, T, F, F, T},
            {T, F, F, T, F, T, T, F},
        };
        int[][] s1 = {
            {1, 2, 3, 4, 5, 7},
            {0, 3, 4, 5},
            {0, 4},
            {0, 1, 5, 7},
            {0, 1, 2, 6},
            {0, 1, 3, 7},
            {4, 7},
            {0, 3, 5, 6},
        };

        boolean[][] m2 = {
            {F, T, T, T, T, T, F, T},
            {T, F, T, F, T, F, F, T},
            {T, T, F, T, T, T, F, F},
            {T, F, T, F, T, T, T, T},
            {T, T, T, T, F, F, F, F},
            {T, F, T, T, F, F, T, F},
            {F, F, F, T, F, T, F, F},
            {T, T, F, T, F, F, F, F},
        };
        int[][] s2 = {
            {1, 2, 3, 4, 5, 7},
            {0, 2, 4, 7},
            {0, 1, 3, 4, 5},
            {0, 2, 4, 5, 6, 7},
            {0, 1, 2, 3},
            {0, 2, 3, 6},
            {3, 5},
            {0, 1, 3},
        };

        boolean[][] m3 = {
            {F, T, T, T, F, T, T, T},
            {T, F, T, F, T, T, F, F},
            {T, T, F, T, F, F, T, F},
            {T, F, T, F, T, T, T, T},
            {F, T, F, T, F, F, F, F},
            {T, T, F, T, F, F, F, T},
            {T, F, T, T, F, F, F, T},
            {T, F, F, T, F, T, T, F},
        };
        int[][] s3 = {
            {1, 2, 3, 5, 6, 7},
            {0, 2, 4, 5},
            {0, 1, 3, 6},
            {0, 2, 4, 5, 6, 7},
            {1, 3},
            {0, 1, 3, 7},
            {0, 2, 3, 7},
            {0, 3, 5, 6},
        };

        boolean[][] m4 = {
            {F, T, T, T, T, F, T, F},
            {T, F, F, F, F, F, F, T},
            {T, F, F, T, T, T, T, F},
            {T, F, T, F, F, F, F, F},
            {T, F, T, F, F, T, T, T},
            {F, F, T, F, T, F, F, F},
            {T, F, T, F, T, F, F, T},
            {F, T, F, F, T, F, T, F},
        };
        int[][] s4 = {
            {1, 2, 3, 4, 6},
            {0, 7},
            {0, 3, 4, 5, 6},
            {0, 2},
            {0, 2, 5, 6, 7},
            {2, 4},
            {0, 2, 4, 7},
            {1, 4, 6},
        };

        boolean[][] m5 = {
            {F, T, F, T, F, T, T, F},
            {T, F, T, F, T, T, T, T},
            {F, T, F, F, T, F, F, F},
            {T, F, F, F, F, T, T, T},
            {F, T, T, F, F, F, F, F},
            {T, T, F, T, F, F, F, T},
            {T, T, F, T, F, F, F, T},
            {F, T, F, T, F, T, T, F},
        };
        int[][] s5 = {
            {1, 3, 5, 6},
            {0, 2, 4, 5, 6, 7},
            {1, 4},
            {0, 5, 6, 7},
            {1, 2},
            {0, 1, 3, 7},
            {0, 1, 3, 7},
            {1, 3, 5, 6},
        };

        boolean[][] m6 = {
            {F, T, F, T, F, F, T, T},
            {T, F, T, F, T, F, F, T},
            {F, T, F, F, F, F, F, T},
            {T, F, F, F, F, F, T, F},
            {F, T, F, F, F, T, F, F},
            {F, F, F, F, T, F, F, T},
            {T, F, F, T, F, F, F, F},
            {T, T, T, F, F, T, F, F},
        };
        int[][] s6 = {
            {1, 3, 6, 7},
            {0, 2, 4, 7},
            {1, 7},
            {0, 6},
            {1, 5},
            {4, 7},
            {0, 3},
            {0, 1, 2, 5},
        };

        boolean[][] m7 = {
            {F, T, T, F, T, T, F, T},
            {T, F, F, T, F, F, F, F},
            {T, F, F, F, F, F, T, F},
            {F, T, F, F, T, T, F, T},
            {T, F, F, T, F, F, F, F},
            {T, F, F, T, F, F, T, F},
            {F, F, T, F, F, T, F, F},
            {T, F, F, T, F, F, F, F},
        };
        int[][] s7 = {
            {1, 2, 4, 5, 7},
            {0, 3},
            {0, 6},
            {1, 4, 5, 7},
            {0, 3},
            {0, 3, 6},
            {2, 5},
            {0, 3},
        };

        boolean[][] m8 = {
            {F, T, F, F, F, F, F, T},
            {T, F, T, F, T, T, T, T},
            {F, T, F, T, F, F, F, F},
            {F, F, T, F, F, T, F, F},
            {F, T, F, F, F, F, T, F},
            {F, T, F, T, F, F, F, F},
            {F, T, F, F, T, F, F, F},
            {T, T, F, F, F, F, F, F},
        };
        int[][] s8 = {
            {1, 7},
            {0, 2, 4, 5, 6, 7},
            {1, 3},
            {2, 5},
            {1, 6},
            {1, 3},
            {1, 4},
            {0, 1},
        };

        boolean[][] m9 = {
            {F, T, T, T, F, F, T, T},
            {T, F, F, F, F, T, F, F},
            {T, F, F, T, T, T, T, T},
            {T, F, T, F, F, F, F, F},
            {F, F, T, F, F, F, T, F},
            {F, T, T, F, F, F, T, T},
            {T, F, T, F, T, T, F, F},
            {T, F, T, F, F, T, F, F},
        };
        int[][] s9 = {
            {1, 2, 3, 6, 7},
            {0, 5},
            {0, 3, 4, 5, 6, 7},
            {0, 2},
            {2, 6},
            {1, 2, 6, 7},
            {0, 2, 4, 5},
            {0, 2, 5},
        };

        boolean[][] m10 = {
            {F, T, T, T, T, T, F, T},
            {T, F, T, F, F, F, F, F},
            {T, T, F, F, F, F, F, F},
            {T, F, F, F, F, T, F, F},
            {T, F, F, F, F, T, F, F},
            {T, F, F, T, T, F, T, T},
            {F, F, F, F, F, T, F, T},
            {T, F, F, F, F, T, T, F},
        };
        int[][] s10 = {
            {1, 2, 3, 4, 5, 7},
            {0, 2},
            {0, 1},
            {0, 5},
            {0, 5},
            {0, 3, 4, 6, 7},
            {5, 7},
            {0, 5, 6},
        };

        System.out.println(Graf.istiGraf(m1, s10));
        System.out.println(Graf.istiGraf(m2, s2));
        System.out.println(Graf.istiGraf(m3, s3));
        System.out.println(Graf.istiGraf(m4, s4));
        System.out.println(Graf.istiGraf(m5, s5));
        System.out.println(Graf.istiGraf(m6, s1));
        System.out.println(Graf.istiGraf(m7, s7));
        System.out.println(Graf.istiGraf(m8, s8));
        System.out.println(Graf.istiGraf(m9, s6));
        System.out.println(Graf.istiGraf(m10, s9));
    }
}

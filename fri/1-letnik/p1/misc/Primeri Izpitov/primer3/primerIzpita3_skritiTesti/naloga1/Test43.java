
public class Test43 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, T, F, T, T, F, F, T, T},
            {T, F, F, T, T, T, T, T, T, T},
            {T, F, F, T, T, F, F, T, F, F},
            {F, T, T, F, F, T, T, T, T, T},
            {T, T, T, F, F, T, T, T, T, T},
            {T, T, F, T, T, F, F, F, F, F},
            {F, T, F, T, T, F, F, F, T, F},
            {F, T, T, T, T, F, F, F, F, F},
            {T, T, F, T, T, F, T, F, F, T},
            {T, T, F, T, T, F, F, F, T, F},
        };
        int[][] s1 = {
            {1, 2, 4, 5, 8, 9},
            {0, 3, 4, 5, 6, 7, 8, 9},
            {0, 3, 4, 7},
            {1, 2, 5, 6, 7, 8, 9},
            {0, 1, 2, 5, 6, 7, 8, 9},
            {0, 1, 3, 4},
            {1, 3, 4, 8},
            {1, 2, 3, 4},
            {0, 1, 3, 4, 6, 9},
            {0, 1, 3, 4, 8},
        };

        boolean[][] m2 = {
            {F, T, T, T, F, T, F, F, F, F},
            {T, F, T, T, T, F, T, T, F, F},
            {T, T, F, T, T, T, T, T, T, T},
            {T, T, T, F, T, F, F, F, F, F},
            {F, T, T, T, F, T, T, T, T, T},
            {T, F, T, F, T, F, T, F, F, F},
            {F, T, T, F, T, T, F, F, F, F},
            {F, T, T, F, T, F, F, F, F, T},
            {F, F, T, F, T, F, F, F, F, T},
            {F, F, T, F, T, F, F, T, T, F},
        };
        int[][] s2 = {
            {1, 2, 3, 5},
            {0, 2, 3, 4, 6, 7},
            {0, 1, 3, 4, 5, 6, 7, 8, 9},
            {0, 1, 2, 4},
            {1, 2, 3, 5, 6, 7, 8, 9},
            {0, 2, 4, 6},
            {1, 2, 4, 5},
            {1, 2, 4, 9},
            {2, 4, 9},
            {2, 4, 7, 8},
        };

        boolean[][] m3 = {
            {F, T, T, F, F, T, T, T, F, T},
            {T, F, F, F, F, T, T, F, T, F},
            {T, F, F, T, F, F, T, F, T, F},
            {F, F, T, F, T, F, T, T, F, T},
            {F, F, F, T, F, F, F, T, F, F},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, T, T, F, F, F, F, F, F},
            {T, F, F, T, T, F, F, F, T, F},
            {F, T, T, F, F, F, F, T, F, T},
            {T, F, F, T, F, F, F, F, T, F},
        };
        int[][] s3 = {
            {1, 2, 5, 6, 7, 9},
            {0, 5, 6, 8},
            {0, 3, 6, 8},
            {2, 4, 6, 7, 9},
            {3, 7},
            {0, 1},
            {0, 1, 2, 3},
            {0, 3, 4, 8},
            {1, 2, 7, 9},
            {0, 3, 8},
        };

        boolean[][] m4 = {
            {F, T, T, T, T, T, T, T, F, T},
            {T, F, T, T, T, T, F, T, T, T},
            {T, T, F, F, T, F, F, F, F, T},
            {T, T, F, F, F, F, F, F, F, F},
            {T, T, T, F, F, T, F, T, T, F},
            {T, T, F, F, T, F, T, F, F, F},
            {T, F, F, F, F, T, F, F, F, F},
            {T, T, F, F, T, F, F, F, F, T},
            {F, T, F, F, T, F, F, F, F, F},
            {T, T, T, F, F, F, F, T, F, F},
        };
        int[][] s4 = {
            {1, 2, 3, 4, 5, 6, 7, 9},
            {0, 2, 3, 4, 5, 7, 8, 9},
            {0, 1, 4, 9},
            {0, 1},
            {0, 1, 2, 5, 7, 8},
            {0, 1, 4, 6},
            {0, 5},
            {0, 1, 4, 9},
            {1, 4},
            {0, 1, 2, 7},
        };

        boolean[][] m5 = {
            {F, T, F, T, T, T, F, F, F, F},
            {T, F, T, F, T, F, T, F, F, T},
            {F, T, F, F, F, F, F, F, F, T},
            {T, F, F, F, F, F, F, F, T, F},
            {T, T, F, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, T, T, T},
            {F, T, F, F, F, F, F, T, T, T},
            {F, F, F, F, F, T, T, F, T, F},
            {F, F, F, T, F, T, T, T, F, F},
            {F, T, T, F, F, T, T, F, F, F},
        };
        int[][] s5 = {
            {1, 3, 4, 5},
            {0, 2, 4, 6, 9},
            {1, 9},
            {0, 8},
            {0, 1},
            {0, 7, 8, 9},
            {1, 7, 8, 9},
            {5, 6, 8},
            {3, 5, 6, 7},
            {1, 2, 5, 6},
        };

        boolean[][] m6 = {
            {F, T, T, T, T, T, F, F, F, T},
            {T, F, F, F, F, T, F, F, F, F},
            {T, F, F, T, F, F, T, T, F, F},
            {T, F, T, F, F, T, F, F, T, F},
            {T, F, F, F, F, F, F, T, F, F},
            {T, T, F, T, F, F, F, F, F, T},
            {F, F, T, F, F, F, F, T, T, T},
            {F, F, T, F, T, F, T, F, T, F},
            {F, F, F, T, F, F, T, T, F, T},
            {T, F, F, F, F, T, T, F, T, F},
        };
        int[][] s6 = {
            {1, 2, 3, 4, 5, 9},
            {0, 5},
            {0, 3, 6, 7},
            {0, 2, 5, 8},
            {0, 7},
            {0, 1, 3, 9},
            {2, 7, 8, 9},
            {2, 4, 6, 8},
            {3, 6, 7, 9},
            {0, 5, 6, 8},
        };

        boolean[][] m7 = {
            {F, T, T, T, T, T, T, T, T, F},
            {T, F, T, F, F, F, F, F, F, F},
            {T, T, F, F, T, F, F, F, T, F},
            {T, F, F, F, F, F, F, T, F, F},
            {T, F, T, F, F, F, T, F, F, T},
            {T, F, F, F, F, F, F, T, F, F},
            {T, F, F, F, T, F, F, F, F, F},
            {T, F, F, T, F, T, F, F, T, F},
            {T, F, T, F, F, F, F, T, F, T},
            {F, F, F, F, T, F, F, F, T, F},
        };
        int[][] s7 = {
            {1, 2, 3, 4, 5, 6, 7, 8},
            {0, 2},
            {0, 1, 4, 8},
            {0, 7},
            {0, 2, 6, 9},
            {0, 7},
            {0, 4},
            {0, 3, 5, 8},
            {0, 2, 7, 9},
            {4, 8},
        };

        boolean[][] m8 = {
            {F, T, F, T, F, F, F, F, F, F},
            {T, F, T, F, T, T, F, F, T, F},
            {F, T, F, F, F, F, F, T, F, F},
            {T, F, F, F, T, T, T, T, F, T},
            {F, T, F, T, F, F, F, F, F, F},
            {F, T, F, T, F, F, F, F, F, F},
            {F, F, F, T, F, F, F, T, T, T},
            {F, F, T, T, F, F, T, F, T, F},
            {F, T, F, F, F, F, T, T, F, T},
            {F, F, F, T, F, F, T, F, T, F},
        };
        int[][] s8 = {
            {1, 3},
            {0, 2, 4, 5, 8},
            {1, 7},
            {0, 4, 5, 6, 7, 9},
            {1, 3},
            {1, 3},
            {3, 7, 8, 9},
            {2, 3, 6, 8},
            {1, 6, 7, 9},
            {3, 6, 8},
        };

        boolean[][] m9 = {
            {F, T, T, T, F, T, T, T, T, T},
            {T, F, F, T, T, T, F, F, F, F},
            {T, F, F, F, F, T, F, F, T, T},
            {T, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, T, T, T, T, T},
            {T, T, T, F, T, F, F, T, T, T},
            {T, F, F, F, T, F, F, F, F, F},
            {T, F, F, F, T, T, F, F, F, T},
            {T, F, T, F, T, T, F, F, F, F},
            {T, F, T, F, T, T, F, T, F, F},
        };
        int[][] s9 = {
            {1, 2, 3, 5, 6, 7, 8, 9},
            {0, 3, 4, 5},
            {0, 5, 8, 9},
            {0, 1},
            {1, 5, 6, 7, 8, 9},
            {0, 1, 2, 4, 7, 8, 9},
            {0, 4},
            {0, 4, 5, 9},
            {0, 2, 4, 5},
            {0, 2, 4, 5, 7},
        };

        boolean[][] m10 = {
            {F, T, T, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, F, F, T},
            {T, F, F, T, T, F, T, F, F, T},
            {F, F, T, F, T, T, F, T, T, F},
            {F, F, T, T, F, T, F, F, F, T},
            {F, F, F, T, T, F, F, F, F, F},
            {F, F, T, F, F, F, F, T, F, F},
            {F, F, F, T, F, F, T, F, F, F},
            {F, F, F, T, F, F, F, F, F, T},
            {F, T, T, F, T, F, F, F, T, F},
        };
        int[][] s10 = {
            {1, 2},
            {0, 9},
            {0, 3, 4, 6, 9},
            {2, 4, 5, 7, 8},
            {2, 3, 5, 9},
            {3, 4},
            {2, 7},
            {3, 6},
            {3, 9},
            {1, 2, 4, 8},
        };

        System.out.println(Graf.istiGraf(m1, s1));
        System.out.println(Graf.istiGraf(m2, s2));
        System.out.println(Graf.istiGraf(m3, s3));
        System.out.println(Graf.istiGraf(m4, s9));
        System.out.println(Graf.istiGraf(m5, s8));
        System.out.println(Graf.istiGraf(m6, s6));
        System.out.println(Graf.istiGraf(m7, s7));
        System.out.println(Graf.istiGraf(m8, s10));
        System.out.println(Graf.istiGraf(m9, s5));
        System.out.println(Graf.istiGraf(m10, s4));
    }
}

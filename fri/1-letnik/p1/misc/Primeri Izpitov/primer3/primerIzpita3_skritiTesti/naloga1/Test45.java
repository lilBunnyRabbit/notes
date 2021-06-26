
public class Test45 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, F, T, F, F, F, T, T, F, T, T},
            {T, F, T, F, T, T, F, F, F, F, F, F},
            {F, T, F, T, F, F, T, F, F, F, F, T},
            {T, F, T, F, T, T, F, T, F, T, F, F},
            {F, T, F, T, F, F, F, F, F, F, F, F},
            {F, T, F, T, F, F, F, F, F, F, T, F},
            {F, F, T, F, F, F, F, F, T, T, T, T},
            {T, F, F, T, F, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, T, F, F, F, F, F},
            {F, F, F, T, F, F, T, F, F, F, F, F},
            {T, F, F, F, F, T, T, F, F, F, F, T},
            {T, F, T, F, F, F, T, F, F, F, T, F},
        };
        int[][] s1 = {
            {1, 3, 7, 8, 10, 11},
            {0, 2, 4, 5},
            {1, 3, 6, 11},
            {0, 2, 4, 5, 7, 9},
            {1, 3},
            {1, 3, 10},
            {2, 8, 9, 10, 11},
            {0, 3},
            {0, 6},
            {3, 6},
            {0, 5, 6, 11},
            {0, 2, 6, 10},
        };

        boolean[][] m2 = {
            {F, T, F, T, F, T, T, F, F, F, F, F},
            {T, F, T, T, T, T, F, F, F, T, T, F},
            {F, T, F, F, T, F, F, F, T, T, F, F},
            {T, T, F, F, T, T, T, T, T, T, T, F},
            {F, T, T, T, F, F, F, F, F, F, T, F},
            {T, T, F, T, F, F, T, T, T, F, T, T},
            {T, F, F, T, F, T, F, T, F, T, T, F},
            {F, F, F, T, F, T, T, F, F, F, T, F},
            {F, F, T, T, F, T, F, F, F, F, F, T},
            {F, T, T, T, F, F, T, F, F, F, F, F},
            {F, T, F, T, T, T, T, T, F, F, F, F},
            {F, F, F, F, F, T, F, F, T, F, F, F},
        };
        int[][] s2 = {
            {1, 3, 5, 6},
            {0, 2, 3, 4, 5, 9, 10},
            {1, 4, 8, 9},
            {0, 1, 4, 5, 6, 7, 8, 9, 10},
            {1, 2, 3, 10},
            {0, 1, 3, 6, 7, 8, 10, 11},
            {0, 3, 5, 7, 9, 10},
            {3, 5, 6, 10},
            {2, 3, 5, 11},
            {1, 2, 3, 6},
            {1, 3, 4, 5, 6, 7},
            {5, 8},
        };

        boolean[][] m3 = {
            {F, T, F, T, F, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, T, T, F, T, T, T},
            {T, F, F, F, T, T, T, T, T, T, F, T},
            {F, F, F, T, F, T, T, F, T, T, T, F},
            {F, F, F, T, T, F, F, F, F, F, F, F},
            {F, F, T, T, T, F, F, T, T, F, F, F},
            {F, F, T, T, F, F, T, F, F, T, F, F},
            {F, F, F, T, T, F, T, F, F, F, T, F},
            {F, F, T, T, T, F, F, T, F, F, F, F},
            {F, F, T, F, T, F, F, F, T, F, F, T},
            {F, F, T, T, F, F, F, F, F, F, T, F},
        };
        int[][] s3 = {
            {1, 3},
            {0, 2},
            {1, 6, 7, 9, 10, 11},
            {0, 4, 5, 6, 7, 8, 9, 11},
            {3, 5, 6, 8, 9, 10},
            {3, 4},
            {2, 3, 4, 7, 8},
            {2, 3, 6, 9},
            {3, 4, 6, 10},
            {2, 3, 4, 7},
            {2, 4, 8, 11},
            {2, 3, 10},
        };

        boolean[][] m4 = {
            {F, T, T, F, T, F, F, F, T, F, F, F},
            {T, F, F, F, F, T, F, F, F, F, F, F},
            {T, F, F, T, T, T, T, T, T, T, T, T},
            {F, F, T, F, F, F, F, F, F, F, F, T},
            {T, F, T, F, F, T, T, T, T, T, T, T},
            {F, T, T, F, T, F, T, T, F, F, F, T},
            {F, F, T, F, T, T, F, F, F, F, F, T},
            {F, F, T, F, T, T, F, F, F, T, F, F},
            {T, F, T, F, T, F, F, F, F, T, T, T},
            {F, F, T, F, T, F, F, T, T, F, F, F},
            {F, F, T, F, T, F, F, F, T, F, F, T},
            {F, F, T, T, T, T, T, F, T, F, T, F},
        };
        int[][] s4 = {
            {1, 2, 4, 8},
            {0, 5},
            {0, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            {2, 11},
            {0, 2, 5, 6, 7, 8, 9, 10, 11},
            {1, 2, 4, 6, 7, 11},
            {2, 4, 5, 11},
            {2, 4, 5, 9},
            {0, 2, 4, 9, 10, 11},
            {2, 4, 7, 8},
            {2, 4, 8, 11},
            {2, 3, 4, 5, 6, 8, 10},
        };

        boolean[][] m5 = {
            {F, T, F, T, F, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, F, T, F},
            {T, F, F, F, T, T, T, F, T, T, T, T},
            {F, F, F, T, F, F, F, T, F, F, F, F},
            {F, F, F, T, F, F, T, F, T, F, T, F},
            {F, F, F, T, F, T, F, F, F, F, F, F},
            {F, F, F, F, T, F, F, F, F, T, F, F},
            {F, F, F, T, F, T, F, F, F, F, F, F},
            {F, F, F, T, F, F, F, T, F, F, F, F},
            {F, F, T, T, F, T, F, F, F, F, F, T},
            {F, F, F, T, F, F, F, F, F, F, T, F},
        };
        int[][] s5 = {
            {1, 3},
            {0, 2},
            {1, 10},
            {0, 4, 5, 6, 8, 9, 10, 11},
            {3, 7},
            {3, 6, 8, 10},
            {3, 5},
            {4, 9},
            {3, 5},
            {3, 7},
            {2, 3, 5, 11},
            {3, 10},
        };

        boolean[][] m6 = {
            {F, T, T, T, T, F, F, T, T, T, F, T},
            {T, F, T, F, F, T, F, F, T, F, F, F},
            {T, T, F, T, T, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, T, F, F, T, F},
            {T, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, T, F, F, F, F, F},
            {F, F, F, F, F, T, F, F, F, T, F, F},
            {T, F, F, T, F, F, F, F, T, T, T, T},
            {T, T, F, F, F, F, F, T, F, T, T, T},
            {T, F, F, F, F, F, T, T, T, F, F, T},
            {F, F, F, T, F, F, F, T, T, F, F, T},
            {T, F, F, F, F, F, F, T, T, T, T, F},
        };
        int[][] s6 = {
            {1, 2, 3, 4, 7, 8, 9, 11},
            {0, 2, 5, 8},
            {0, 1, 3, 4},
            {0, 2, 7, 10},
            {0, 2},
            {1, 6},
            {5, 9},
            {0, 3, 8, 9, 10, 11},
            {0, 1, 7, 9, 10, 11},
            {0, 6, 7, 8, 11},
            {3, 7, 8, 11},
            {0, 7, 8, 9, 10},
        };

        boolean[][] m7 = {
            {F, T, T, T, T, T, F, F, F, F, F, T},
            {T, F, F, F, T, F, F, F, F, F, F, F},
            {T, F, F, T, F, T, F, F, T, T, F, F},
            {T, F, T, F, T, F, T, F, F, F, F, F},
            {T, T, F, T, F, F, F, F, F, F, F, T},
            {T, F, T, F, F, F, F, T, T, T, T, T},
            {F, F, F, T, F, F, F, T, T, T, T, T},
            {F, F, F, F, F, T, T, F, F, F, F, F},
            {F, F, T, F, F, T, T, F, F, T, F, F},
            {F, F, T, F, F, T, T, F, T, F, F, F},
            {F, F, F, F, F, T, T, F, F, F, F, F},
            {T, F, F, F, T, T, T, F, F, F, F, F},
        };
        int[][] s7 = {
            {1, 2, 3, 4, 5, 11},
            {0, 4},
            {0, 3, 5, 8, 9},
            {0, 2, 4, 6},
            {0, 1, 3, 11},
            {0, 2, 7, 8, 9, 10, 11},
            {3, 7, 8, 9, 10, 11},
            {5, 6},
            {2, 5, 6, 9},
            {2, 5, 6, 8},
            {5, 6},
            {0, 4, 5, 6},
        };

        boolean[][] m8 = {
            {F, T, F, F, T, F, T, F, F, T, F, F},
            {T, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, T, F, F, F, T, T, F, F, F},
            {F, F, T, F, T, T, T, F, T, T, T, T},
            {T, F, F, T, F, T, F, F, T, T, F, F},
            {F, F, F, T, T, F, F, F, F, F, F, F},
            {T, F, F, T, F, F, F, T, F, T, F, T},
            {F, F, T, F, F, F, T, F, F, T, T, F},
            {F, F, T, T, T, F, F, F, F, F, F, T},
            {T, F, F, T, T, F, T, T, F, F, F, T},
            {F, F, F, T, F, F, F, T, F, F, F, F},
            {F, F, F, T, F, F, T, F, T, T, F, F},
        };
        int[][] s8 = {
            {1, 4, 6, 9},
            {0, 2},
            {1, 3, 7, 8},
            {2, 4, 5, 6, 8, 9, 10, 11},
            {0, 3, 5, 8, 9},
            {3, 4},
            {0, 3, 7, 9, 11},
            {2, 6, 9, 10},
            {2, 3, 4, 11},
            {0, 3, 4, 6, 7, 11},
            {3, 7},
            {3, 6, 8, 9},
        };

        boolean[][] m9 = {
            {F, T, T, T, F, T, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, T, F, F, F, F},
            {T, F, F, F, F, F, F, T, F, F, F, F},
            {T, F, F, F, T, T, T, F, F, T, T, F},
            {F, F, F, T, F, F, T, T, T, F, F, F},
            {T, F, F, T, F, F, F, F, F, F, F, F},
            {F, F, F, T, T, F, F, F, F, F, F, F},
            {F, T, T, F, T, F, F, F, T, F, F, F},
            {F, F, F, F, T, F, F, T, F, F, F, F},
            {F, F, F, T, F, F, F, F, F, F, T, F},
            {F, F, F, T, F, F, F, F, F, T, F, T},
            {F, F, F, F, F, F, F, F, F, F, T, F},
        };
        int[][] s9 = {
            {1, 2, 3, 5},
            {0, 7},
            {0, 7},
            {0, 4, 5, 6, 9, 10},
            {3, 6, 7, 8},
            {0, 3},
            {3, 4},
            {1, 2, 4, 8},
            {4, 7},
            {3, 10},
            {3, 9, 11},
            {10},
        };

        boolean[][] m10 = {
            {F, T, T, T, T, T, T, T, F, T, F, T},
            {T, F, F, T, T, F, T, T, T, F, F, F},
            {T, F, F, F, T, F, F, F, F, F, F, F},
            {T, T, F, F, F, T, F, F, F, F, T, F},
            {T, T, T, F, F, F, T, T, F, T, F, F},
            {T, F, F, T, F, F, F, F, F, F, F, F},
            {T, T, F, F, T, F, F, F, T, F, F, F},
            {T, T, F, F, T, F, F, F, T, F, F, F},
            {F, T, F, F, F, F, T, T, F, F, F, T},
            {T, F, F, F, T, F, F, F, F, F, F, F},
            {F, F, F, T, F, F, F, F, F, F, F, T},
            {T, F, F, F, F, F, F, F, T, F, T, F},
        };
        int[][] s10 = {
            {1, 2, 3, 4, 5, 6, 7, 9, 11},
            {0, 3, 4, 6, 7, 8},
            {0, 4},
            {0, 1, 5, 10},
            {0, 1, 2, 6, 7, 9},
            {0, 3},
            {0, 1, 4, 8},
            {0, 1, 4, 8},
            {1, 6, 7, 11},
            {0, 4},
            {3, 11},
            {0, 8, 10},
        };

        System.out.println(Graf.istiGraf(m1, s10));
        System.out.println(Graf.istiGraf(m2, s2));
        System.out.println(Graf.istiGraf(m3, s3));
        System.out.println(Graf.istiGraf(m4, s4));
        System.out.println(Graf.istiGraf(m5, s7));
        System.out.println(Graf.istiGraf(m6, s6));
        System.out.println(Graf.istiGraf(m7, s5));
        System.out.println(Graf.istiGraf(m8, s8));
        System.out.println(Graf.istiGraf(m9, s9));
        System.out.println(Graf.istiGraf(m10, s1));
    }
}

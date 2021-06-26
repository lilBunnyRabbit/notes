
public class Test47 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, F, F, F, F, T, F, F, T, F, F, T, F},
            {T, F, T, T, F, F, F, F, T, F, T, F, F, F},
            {F, T, F, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, T, F, F, F, F, F, F, F, F, F},
            {F, F, T, T, F, T, F, T, F, T, F, T, T, T},
            {F, F, F, F, T, F, F, T, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, T, T, T, T, T, T, T},
            {F, F, F, F, T, T, T, F, F, F, F, T, F, F},
            {F, T, F, F, F, F, T, F, F, F, F, F, F, F},
            {T, F, F, F, T, F, T, F, F, F, F, F, F, T},
            {F, T, F, F, F, F, T, F, F, F, F, F, F, F},
            {F, F, F, F, T, F, T, T, F, F, F, F, F, T},
            {T, F, F, F, T, F, T, F, F, F, F, F, F, T},
            {F, F, F, F, T, F, T, F, F, T, F, T, T, F},
        };
        int[][] s1 = {
            {1, 6, 9, 12},
            {0, 2, 3, 8, 10},
            {1, 4},
            {1, 4},
            {2, 3, 5, 7, 9, 11, 12, 13},
            {4, 7},
            {0, 7, 8, 9, 10, 11, 12, 13},
            {4, 5, 6, 11},
            {1, 6},
            {0, 4, 6, 13},
            {1, 6},
            {4, 6, 7, 13},
            {0, 4, 6, 13},
            {4, 6, 9, 11, 12},
        };

        boolean[][] m2 = {
            {F, T, T, T, T, T, T, T, T, T, T, T, T, T},
            {T, F, F, F, F, F, F, T, F, T, F, T, F, F},
            {T, F, F, T, T, F, F, T, F, F, T, F, T, T},
            {T, F, T, F, F, T, F, F, T, F, F, F, F, F},
            {T, F, T, F, F, T, T, T, T, T, T, T, T, T},
            {T, F, F, T, T, F, T, T, F, T, F, F, T, T},
            {T, F, F, F, T, T, F, F, T, T, T, T, T, F},
            {T, T, T, F, T, T, F, F, F, F, F, F, T, F},
            {T, F, F, T, T, F, T, F, F, F, F, F, F, F},
            {T, T, F, F, T, T, T, F, F, F, F, T, T, T},
            {T, F, T, F, T, F, T, F, F, F, F, T, T, T},
            {T, T, F, F, T, F, T, F, F, T, T, F, F, F},
            {T, F, T, F, T, T, T, T, F, T, T, F, F, F},
            {T, F, T, F, T, T, F, F, F, T, T, F, F, F},
        };
        int[][] s2 = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {0, 7, 9, 11},
            {0, 3, 4, 7, 10, 12, 13},
            {0, 2, 5, 8},
            {0, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {0, 3, 4, 6, 7, 9, 12, 13},
            {0, 4, 5, 8, 9, 10, 11, 12},
            {0, 1, 2, 4, 5, 12},
            {0, 3, 4, 6},
            {0, 1, 4, 5, 6, 11, 12, 13},
            {0, 2, 4, 6, 11, 12, 13},
            {0, 1, 4, 6, 9, 10},
            {0, 2, 4, 5, 6, 7, 9, 10},
            {0, 2, 4, 5, 9, 10},
        };

        boolean[][] m3 = {
            {F, T, T, T, F, T, F, F, F, F, F, F, T, F},
            {T, F, F, F, F, F, T, F, F, F, F, F, F, F},
            {T, F, F, T, T, T, F, F, T, T, F, F, F, F},
            {T, F, T, F, T, F, F, F, F, T, F, F, F, F},
            {F, F, T, T, F, F, F, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, T, T, T, T, F, T, F},
            {F, T, F, F, F, F, F, F, F, F, F, F, T, F},
            {F, F, F, F, F, T, F, F, F, F, F, T, F, F},
            {F, F, T, F, F, T, F, F, F, F, F, F, F, F},
            {F, F, T, T, F, T, F, F, F, F, F, T, T, T},
            {F, F, F, F, F, T, F, F, F, F, F, T, T, T},
            {F, F, F, F, F, F, F, T, F, T, T, F, F, T},
            {T, F, F, F, F, T, T, F, F, T, T, F, F, T},
            {F, F, F, F, F, F, F, F, F, T, T, T, T, F},
        };
        int[][] s3 = {
            {1, 2, 3, 5, 12},
            {0, 6},
            {0, 3, 4, 5, 8, 9},
            {0, 2, 4, 9},
            {2, 3},
            {0, 2, 7, 8, 9, 10, 12},
            {1, 12},
            {5, 11},
            {2, 5},
            {2, 3, 5, 11, 12, 13},
            {5, 11, 12, 13},
            {7, 9, 10, 13},
            {0, 5, 6, 9, 10, 13},
            {9, 10, 11, 12},
        };

        boolean[][] m4 = {
            {F, T, T, F, T, F, F, F, T, F, F, F, F, F},
            {T, F, F, T, T, T, T, T, T, F, F, T, T, T},
            {T, F, F, T, F, F, T, F, F, T, T, F, F, T},
            {F, T, T, F, F, F, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, T, F, T, F, F, F, T, T, F},
            {F, T, F, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, T, F, F, F, F, F, F, T, T, T, T, T},
            {F, T, F, F, T, F, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, F, F, F, F, F, F, F},
            {F, F, T, F, F, F, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, F, T, F, F, F, F, F, F, F},
            {F, T, F, F, T, F, T, F, F, F, F, F, F, T},
            {F, T, F, F, T, F, T, F, F, F, F, F, F, T},
            {F, T, T, F, F, F, T, F, F, F, F, T, T, F},
        };
        int[][] s4 = {
            {1, 2, 4, 8},
            {0, 3, 4, 5, 6, 7, 8, 11, 12, 13},
            {0, 3, 6, 9, 10, 13},
            {1, 2},
            {0, 1, 5, 7, 11, 12},
            {1, 4},
            {1, 2, 9, 10, 11, 12, 13},
            {1, 4},
            {0, 1},
            {2, 6},
            {2, 6},
            {1, 4, 6, 13},
            {1, 4, 6, 13},
            {1, 2, 6, 11, 12},
        };

        boolean[][] m5 = {
            {F, T, F, T, F, F, T, F, T, F, F, F, T, F},
            {T, F, T, T, T, T, T, T, F, T, T, F, T, F},
            {F, T, F, T, T, T, T, F, T, T, F, T, T, T},
            {T, T, T, F, F, F, T, F, F, F, F, F, F, F},
            {F, T, T, F, F, T, T, F, T, T, T, T, F, T},
            {F, T, T, F, T, F, F, F, F, F, F, F, T, F},
            {T, T, T, T, T, F, F, F, F, T, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, T, T, T, T, T},
            {T, F, T, F, T, F, F, F, F, T, F, T, F, F},
            {F, T, T, F, T, F, T, T, T, F, F, F, F, F},
            {F, T, F, F, T, F, F, T, F, F, F, T, T, T},
            {F, F, T, F, T, F, F, T, T, F, T, F, F, T},
            {T, T, T, F, F, T, F, T, F, F, T, F, F, T},
            {F, F, T, F, T, F, F, T, F, F, T, T, T, F},
        };
        int[][] s5 = {
            {1, 3, 6, 8, 12},
            {0, 2, 3, 4, 5, 6, 7, 9, 10, 12},
            {1, 3, 4, 5, 6, 8, 9, 11, 12, 13},
            {0, 1, 2, 6},
            {1, 2, 5, 6, 8, 9, 10, 11, 13},
            {1, 2, 4, 12},
            {0, 1, 2, 3, 4, 9},
            {1, 9, 10, 11, 12, 13},
            {0, 2, 4, 9, 11},
            {1, 2, 4, 6, 7, 8},
            {1, 4, 7, 11, 12, 13},
            {2, 4, 7, 8, 10, 13},
            {0, 1, 2, 5, 7, 10, 13},
            {2, 4, 7, 10, 11, 12},
        };

        boolean[][] m6 = {
            {F, T, T, T, T, F, F, F, F, F, F, F, F, F},
            {T, F, T, T, T, F, T, T, F, T, T, T, T, T},
            {T, T, F, F, F, F, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, T, F, F, T, F, F, F, F, F},
            {F, F, F, F, T, F, T, T, F, T, F, F, F, F},
            {F, T, F, F, F, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, T, F, F, F, F, F, F, F, F},
            {F, F, F, F, T, F, F, F, F, F, F, T, T, T},
            {F, T, F, F, F, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, F, F, T, F, F},
            {F, T, F, F, F, F, F, F, T, F, T, F, T, F},
            {F, T, F, F, F, F, F, F, T, F, F, T, F, T},
            {F, T, F, F, F, F, F, F, T, F, F, F, T, F},
        };
        int[][] s6 = {
            {1, 2, 3, 4},
            {0, 2, 3, 4, 6, 7, 9, 10, 11, 12, 13},
            {0, 1},
            {0, 1},
            {0, 1, 5, 8},
            {4, 6, 7, 9},
            {1, 5},
            {1, 5},
            {4, 11, 12, 13},
            {1, 5},
            {1, 11},
            {1, 8, 10, 12},
            {1, 8, 11, 13},
            {1, 8, 12},
        };

        boolean[][] m7 = {
            {F, T, T, F, T, T, T, F, F, T, F, T, F, F},
            {T, F, T, F, F, F, T, F, F, T, F, T, F, T},
            {T, T, F, T, F, T, T, T, T, T, F, F, F, F},
            {F, F, T, F, F, F, F, F, F, F, F, F, F, T},
            {T, F, F, F, F, F, F, T, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, T, T, F, T, F, F, F},
            {T, T, T, F, F, F, F, T, T, T, T, T, T, T},
            {F, F, T, F, T, T, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, T, T, F, F, T, T, F, F, T},
            {T, T, T, F, F, F, T, F, T, F, F, T, T, T},
            {F, F, F, F, F, T, T, F, T, F, F, T, T, T},
            {T, T, F, F, F, F, T, F, F, T, T, F, T, F},
            {F, F, F, F, F, F, T, F, F, T, T, T, F, T},
            {F, T, F, T, F, F, T, F, T, T, T, F, T, F},
        };
        int[][] s7 = {
            {1, 2, 4, 5, 6, 9, 11},
            {0, 2, 6, 9, 11, 13},
            {0, 1, 3, 5, 6, 7, 8, 9},
            {2, 13},
            {0, 7},
            {0, 2, 7, 8, 10},
            {0, 1, 2, 7, 8, 9, 10, 11, 12, 13},
            {2, 4, 5, 6},
            {2, 5, 6, 9, 10, 13},
            {0, 1, 2, 6, 8, 11, 12, 13},
            {5, 6, 8, 11, 12, 13},
            {0, 1, 6, 9, 10, 12},
            {6, 9, 10, 11, 13},
            {1, 3, 6, 8, 9, 10, 12},
        };

        boolean[][] m8 = {
            {F, T, F, F, F, T, F, T, F, F, F, F, T, F},
            {T, F, T, T, F, F, F, F, T, F, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, F, F, T, F, F},
            {F, T, F, F, T, T, F, T, T, T, F, F, T, F},
            {F, F, F, T, F, F, T, F, F, F, F, F, F, F},
            {T, F, F, T, F, F, T, T, T, F, T, T, T, F},
            {F, F, F, F, T, T, F, T, T, T, T, T, T, T},
            {T, F, F, T, F, T, T, F, F, F, F, F, F, F},
            {F, T, F, T, F, T, T, F, F, F, F, F, F, F},
            {F, F, F, T, F, F, T, F, F, F, F, F, F, F},
            {F, F, F, F, F, T, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, T, T, F, F, F, F, F, F, T},
            {T, F, F, T, F, T, T, F, F, F, F, F, F, F},
            {F, F, F, F, F, F, T, F, F, F, F, T, F, F},
        };
        int[][] s8 = {
            {1, 5, 7, 12},
            {0, 2, 3, 8},
            {1, 11},
            {1, 4, 5, 7, 8, 9, 12},
            {3, 6},
            {0, 3, 6, 7, 8, 10, 11, 12},
            {4, 5, 7, 8, 9, 10, 11, 12, 13},
            {0, 3, 5, 6},
            {1, 3, 5, 6},
            {3, 6},
            {5, 6},
            {2, 5, 6, 13},
            {0, 3, 5, 6},
            {6, 11},
        };

        boolean[][] m9 = {
            {F, T, T, T, F, T, T, F, F, F, F, T, F, F},
            {T, F, T, T, T, T, T, F, T, T, T, T, T, T},
            {T, T, F, F, T, F, F, T, T, F, T, F, F, F},
            {T, T, F, F, F, F, F, F, F, F, F, F, F, F},
            {F, T, T, F, F, T, F, F, F, T, T, F, T, T},
            {T, T, F, F, T, F, F, T, T, F, F, T, F, F},
            {T, T, F, F, F, F, F, T, F, T, F, F, F, F},
            {F, F, T, F, F, T, T, F, T, F, T, F, F, T},
            {F, T, T, F, F, T, F, T, F, F, F, F, F, F},
            {F, T, F, F, T, F, T, F, F, F, T, F, T, T},
            {F, T, T, F, T, F, F, T, F, T, F, T, F, F},
            {T, T, F, F, F, T, F, F, F, F, T, F, F, F},
            {F, T, F, F, T, F, F, F, F, T, F, F, F, T},
            {F, T, F, F, T, F, F, T, F, T, F, F, T, F},
        };
        int[][] s9 = {
            {1, 2, 3, 5, 6, 11},
            {0, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13},
            {0, 1, 4, 7, 8, 10},
            {0, 1},
            {1, 2, 5, 9, 10, 12, 13},
            {0, 1, 4, 7, 8, 11},
            {0, 1, 7, 9},
            {2, 5, 6, 8, 10, 13},
            {1, 2, 5, 7},
            {1, 4, 6, 10, 12, 13},
            {1, 2, 4, 7, 9, 11},
            {0, 1, 5, 10},
            {1, 4, 9, 13},
            {1, 4, 7, 9, 12},
        };

        boolean[][] m10 = {
            {F, T, F, F, T, F, F, F, F, F, F, T, F, T},
            {T, F, T, F, F, F, F, F, F, F, F, F, F, F},
            {F, T, F, T, T, F, T, F, F, F, T, F, T, F},
            {F, F, T, F, F, F, F, T, T, F, F, F, F, T},
            {T, F, T, F, F, T, F, T, F, F, T, F, F, T},
            {F, F, F, F, T, F, T, F, T, T, T, T, T, T},
            {F, F, T, F, F, T, F, T, F, T, F, T, F, F},
            {F, F, F, T, T, F, T, F, F, F, F, T, F, F},
            {F, F, F, T, F, T, F, F, F, F, F, F, F, F},
            {F, F, F, F, F, T, T, F, F, F, F, F, F, F},
            {F, F, T, F, T, T, F, F, F, F, F, F, F, T},
            {T, F, F, F, F, T, T, T, F, F, F, F, F, F},
            {F, F, T, F, F, T, F, F, F, F, F, F, F, F},
            {T, F, F, T, T, T, F, F, F, F, T, F, F, F},
        };
        int[][] s10 = {
            {1, 4, 11, 13},
            {0, 2},
            {1, 3, 4, 6, 10, 12},
            {2, 7, 8, 13},
            {0, 2, 5, 7, 10, 13},
            {4, 6, 8, 9, 10, 11, 12, 13},
            {2, 5, 7, 9, 11},
            {3, 4, 6, 11},
            {3, 5},
            {5, 6},
            {2, 4, 5, 13},
            {0, 5, 6, 7},
            {2, 5},
            {0, 3, 4, 5, 10},
        };

        System.out.println(Graf.istiGraf(m1, s3));
        System.out.println(Graf.istiGraf(m2, s2));
        System.out.println(Graf.istiGraf(m3, s7));
        System.out.println(Graf.istiGraf(m4, s4));
        System.out.println(Graf.istiGraf(m5, s5));
        System.out.println(Graf.istiGraf(m6, s9));
        System.out.println(Graf.istiGraf(m7, s1));
        System.out.println(Graf.istiGraf(m8, s8));
        System.out.println(Graf.istiGraf(m9, s6));
        System.out.println(Graf.istiGraf(m10, s10));
    }
}


public class Test46 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, T, F, F, F, F, F, T, F, F, T, F},
            {T, F, F, T, F, F, T, F, F, T, F, F, F},
            {T, F, F, F, T, F, F, T, F, F, T, F, T},
            {F, T, F, F, F, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, T, T, T, T, F, T, T, T},
            {F, F, F, T, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, T, F, F, F, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F, F, F, F},
            {T, F, F, F, T, F, F, F, F, T, T, T, F},
            {F, T, F, F, F, F, F, F, T, F, F, F, F},
            {F, F, T, F, T, F, F, F, T, F, F, F, T},
            {T, F, F, F, T, F, F, F, T, F, F, F, T},
            {F, F, T, F, T, F, F, F, F, F, T, T, F},
        };
        int[][] s1 = {
            {1, 2, 8, 11},
            {0, 3, 6, 9},
            {0, 4, 7, 10, 12},
            {1, 5},
            {2, 5, 6, 7, 8, 10, 11, 12},
            {3, 4},
            {1, 4},
            {2, 4},
            {0, 4, 9, 10, 11},
            {1, 8},
            {2, 4, 8, 12},
            {0, 4, 8, 12},
            {2, 4, 10, 11},
        };

        boolean[][] m2 = {
            {F, T, T, F, T, T, F, F, F, F, F, F, F},
            {T, F, F, T, F, F, F, F, F, F, F, F, F},
            {T, F, F, T, F, T, T, F, F, T, T, T, T},
            {F, T, T, F, F, F, T, F, T, F, F, F, F},
            {T, F, F, F, F, T, T, F, T, T, T, T, T},
            {T, F, T, F, T, F, F, T, F, F, F, F, F},
            {F, F, T, T, T, F, F, F, F, F, F, T, F},
            {F, F, F, F, F, T, F, F, F, F, F, F, T},
            {F, F, F, T, T, F, F, F, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F, F, F, F},
            {F, F, T, F, T, F, T, F, F, F, F, F, T},
            {F, F, T, F, T, F, F, T, F, F, F, T, F},
        };
        int[][] s2 = {
            {1, 2, 4, 5},
            {0, 3},
            {0, 3, 5, 6, 9, 10, 11, 12},
            {1, 2, 6, 8},
            {0, 5, 6, 8, 9, 10, 11, 12},
            {0, 2, 4, 7},
            {2, 3, 4, 11},
            {5, 12},
            {3, 4},
            {2, 4},
            {2, 4},
            {2, 4, 6, 12},
            {2, 4, 7, 11},
        };

        boolean[][] m3 = {
            {F, T, T, T, T, T, T, T, T, F, T, T, T},
            {T, F, F, F, F, F, F, F, F, F, T, F, F},
            {T, F, F, F, T, T, F, T, T, F, T, F, F},
            {T, F, F, F, T, F, F, F, F, F, F, F, F},
            {T, F, T, T, F, F, F, F, F, T, F, F, F},
            {T, F, T, F, F, F, F, F, T, F, F, F, F},
            {T, F, F, F, F, F, F, T, F, F, F, F, F},
            {T, F, T, F, F, F, T, F, F, T, F, F, F},
            {T, F, T, F, F, T, F, F, F, T, T, T, T},
            {F, F, F, F, T, F, F, T, T, F, T, F, F},
            {T, T, T, F, F, F, F, F, T, T, F, T, F},
            {T, F, F, F, F, F, F, F, T, F, T, F, T},
            {T, F, F, F, F, F, F, F, T, F, F, T, F},
        };
        int[][] s3 = {
            {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12},
            {0, 10},
            {0, 4, 5, 7, 8, 10},
            {0, 4},
            {0, 2, 3, 9},
            {0, 2, 8},
            {0, 7},
            {0, 2, 6, 9},
            {0, 2, 5, 9, 10, 11, 12},
            {4, 7, 8, 10},
            {0, 1, 2, 8, 9, 11},
            {0, 8, 10, 12},
            {0, 8, 11},
        };

        boolean[][] m4 = {
            {F, T, T, T, F, T, T, F, T, F, F, F, T},
            {T, F, T, T, T, T, T, T, T, T, F, F, F},
            {T, T, F, T, F, T, F, T, F, F, F, F, T},
            {T, T, T, F, T, T, F, T, F, F, T, T, F},
            {F, T, F, T, F, F, F, F, F, F, F, F, F},
            {T, T, T, T, F, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, F, F, T, F, T, F},
            {F, T, T, T, F, F, F, F, F, T, F, F, F},
            {T, T, F, F, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, T, T, F, F, F, T, F},
            {F, F, F, T, F, F, F, F, F, F, F, T, F},
            {F, F, F, T, F, F, T, F, F, T, T, F, F},
            {T, F, T, F, F, F, F, F, F, F, F, F, F},
        };
        int[][] s4 = {
            {1, 2, 3, 5, 6, 8, 12},
            {0, 2, 3, 4, 5, 6, 7, 8, 9},
            {0, 1, 3, 5, 7, 12},
            {0, 1, 2, 4, 5, 7, 10, 11},
            {1, 3},
            {0, 1, 2, 3},
            {0, 1, 9, 11},
            {1, 2, 3, 9},
            {0, 1},
            {1, 6, 7, 11},
            {3, 11},
            {3, 6, 9, 10},
            {0, 2},
        };

        boolean[][] m5 = {
            {F, T, T, T, T, T, T, F, T, T, F, T, T},
            {T, F, T, F, F, T, F, F, F, F, F, F, T},
            {T, T, F, F, T, T, T, T, T, T, T, T, T},
            {T, F, F, F, T, T, T, T, T, T, T, T, T},
            {T, F, T, T, F, F, T, F, F, F, F, F, F},
            {T, T, T, T, F, F, F, F, T, F, T, F, F},
            {T, F, T, T, T, F, F, F, F, T, F, T, T},
            {F, F, T, T, F, F, F, F, F, F, T, T, F},
            {T, F, T, T, F, T, F, F, F, F, F, F, F},
            {T, F, T, T, F, F, T, F, F, F, F, F, F},
            {F, F, T, T, F, T, F, T, F, F, F, F, F},
            {T, F, T, T, F, F, T, T, F, F, F, F, T},
            {T, T, T, T, F, F, T, F, F, F, F, T, F},
        };
        int[][] s5 = {
            {1, 2, 3, 4, 5, 6, 8, 9, 11, 12},
            {0, 2, 5, 12},
            {0, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {0, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {0, 2, 3, 6},
            {0, 1, 2, 3, 8, 10},
            {0, 2, 3, 4, 9, 11, 12},
            {2, 3, 10, 11},
            {0, 2, 3, 5},
            {0, 2, 3, 6},
            {2, 3, 5, 7},
            {0, 2, 3, 6, 7, 12},
            {0, 1, 2, 3, 6, 11},
        };

        boolean[][] m6 = {
            {F, T, F, F, F, T, F, T, F, F, F, F, F},
            {T, F, T, T, T, F, F, F, T, T, F, F, F},
            {F, T, F, F, F, T, F, F, T, F, F, T, F},
            {F, T, F, F, F, F, F, T, F, F, F, F, F},
            {F, T, F, F, F, F, T, F, F, T, F, T, F},
            {T, F, T, F, F, F, F, F, F, F, F, F, F},
            {F, F, F, F, T, F, F, F, F, F, F, F, T},
            {T, F, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, T, F, F, F, F, F, F, F, F, F, F},
            {F, T, F, F, T, F, F, F, F, F, T, T, T},
            {F, F, F, F, F, F, F, F, F, T, F, F, T},
            {F, F, T, F, T, F, F, F, F, T, F, F, T},
            {F, F, F, F, F, F, T, F, F, T, T, T, F},
        };
        int[][] s6 = {
            {1, 5, 7},
            {0, 2, 3, 4, 8, 9},
            {1, 5, 8, 11},
            {1, 7},
            {1, 6, 9, 11},
            {0, 2},
            {4, 12},
            {0, 3},
            {1, 2},
            {1, 4, 10, 11, 12},
            {9, 12},
            {2, 4, 9, 12},
            {6, 9, 10, 11},
        };

        boolean[][] m7 = {
            {F, T, T, T, F, T, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, T, F, T, F, F, F, T},
            {T, F, F, F, T, F, F, F, F, F, F, F, F},
            {T, F, F, F, T, T, T, T, T, T, T, T, T},
            {F, F, T, T, F, F, F, F, F, F, F, F, F},
            {T, F, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, F, T, F, F, F, T, T, T, T, F, T},
            {F, F, F, T, F, F, T, F, F, F, F, F, F},
            {F, T, F, T, F, F, T, F, F, T, T, F, T},
            {F, F, F, T, F, F, T, F, T, F, T, F, F},
            {F, F, F, T, F, F, T, F, T, T, F, T, F},
            {F, F, F, T, F, F, F, F, F, F, T, F, F},
            {F, T, F, T, F, F, T, F, T, F, F, F, F},
        };
        int[][] s7 = {
            {1, 2, 3, 5},
            {0, 6, 8, 12},
            {0, 4},
            {0, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {2, 3},
            {0, 3},
            {1, 3, 7, 8, 9, 10, 12},
            {3, 6},
            {1, 3, 6, 9, 10, 12},
            {3, 6, 8, 10},
            {3, 6, 8, 9, 11},
            {3, 10},
            {1, 3, 6, 8},
        };

        boolean[][] m8 = {
            {F, T, F, F, T, F, F, F, F, F, T, F, T},
            {T, F, T, T, T, T, T, F, F, F, T, T, F},
            {F, T, F, T, F, F, F, F, F, F, F, F, F},
            {F, T, T, F, F, F, F, F, F, T, T, F, F},
            {T, T, F, F, F, F, T, F, T, F, F, F, F},
            {F, T, F, F, F, F, T, T, T, T, T, T, T},
            {F, T, F, F, T, T, F, T, F, F, F, F, F},
            {F, F, F, F, F, T, T, F, T, T, T, T, T},
            {F, F, F, F, T, T, F, T, F, F, T, T, T},
            {F, F, F, T, F, T, F, T, F, F, T, T, T},
            {T, T, F, T, F, T, F, T, T, T, F, F, T},
            {F, T, F, F, F, T, F, T, T, T, F, F, T},
            {T, F, F, F, F, T, F, T, T, T, T, T, F},
        };
        int[][] s8 = {
            {1, 4, 10, 12},
            {0, 2, 3, 4, 5, 6, 10, 11},
            {1, 3},
            {1, 2, 9, 10},
            {0, 1, 6, 8},
            {1, 6, 7, 8, 9, 10, 11, 12},
            {1, 4, 5, 7},
            {5, 6, 8, 9, 10, 11, 12},
            {4, 5, 7, 10, 11, 12},
            {3, 5, 7, 10, 11, 12},
            {0, 1, 3, 5, 7, 8, 9, 12},
            {1, 5, 7, 8, 9, 12},
            {0, 5, 7, 8, 9, 10, 11},
        };

        boolean[][] m9 = {
            {F, T, F, F, T, T, F, F, F, F, F, F, T},
            {T, F, T, F, F, T, T, F, T, T, F, F, F},
            {F, T, F, T, F, F, T, T, F, F, F, F, F},
            {F, F, T, F, T, T, T, T, T, T, T, T, T},
            {T, F, F, T, F, F, F, T, T, F, T, T, F},
            {T, T, F, T, F, F, T, T, T, T, T, T, T},
            {F, T, T, T, F, T, F, F, T, T, F, F, F},
            {F, F, T, T, T, T, F, F, F, F, F, F, F},
            {F, T, F, T, T, T, T, F, F, F, T, F, F},
            {F, T, F, T, F, T, T, F, F, F, F, T, T},
            {F, F, F, T, T, T, F, F, T, F, F, F, F},
            {F, F, F, T, T, T, F, F, F, T, F, F, F},
            {T, F, F, T, F, T, F, F, F, T, F, F, F},
        };
        int[][] s9 = {
            {1, 4, 5, 12},
            {0, 2, 5, 6, 8, 9},
            {1, 3, 6, 7},
            {2, 4, 5, 6, 7, 8, 9, 10, 11, 12},
            {0, 3, 7, 8, 10, 11},
            {0, 1, 3, 6, 7, 8, 9, 10, 11, 12},
            {1, 2, 3, 5, 8, 9},
            {2, 3, 4, 5},
            {1, 3, 4, 5, 6, 10},
            {1, 3, 5, 6, 11, 12},
            {3, 4, 5, 8},
            {3, 4, 5, 9},
            {0, 3, 5, 9},
        };

        boolean[][] m10 = {
            {F, T, T, F, T, T, F, F, T, T, F, F, F},
            {T, F, F, T, F, F, F, F, F, F, F, F, F},
            {T, F, F, F, F, F, F, F, F, F, F, T, F},
            {F, T, F, F, F, T, F, T, T, T, F, F, F},
            {T, F, F, F, F, F, F, T, T, F, F, T, F},
            {T, F, F, T, F, F, T, T, T, T, T, T, T},
            {F, F, F, F, F, T, F, F, F, F, F, F, T},
            {F, F, F, T, T, T, F, F, F, F, T, F, F},
            {T, F, F, T, T, T, F, F, F, F, F, F, F},
            {T, F, F, T, F, T, F, F, F, F, F, F, T},
            {F, F, F, F, F, T, F, T, F, F, F, F, F},
            {F, F, T, F, T, T, F, F, F, F, F, F, T},
            {F, F, F, F, F, T, T, F, F, T, F, T, F},
        };
        int[][] s10 = {
            {1, 2, 4, 5, 8, 9},
            {0, 3},
            {0, 11},
            {1, 5, 7, 8, 9},
            {0, 7, 8, 11},
            {0, 3, 6, 7, 8, 9, 10, 11, 12},
            {5, 12},
            {3, 4, 5, 10},
            {0, 3, 4, 5},
            {0, 3, 5, 12},
            {5, 7},
            {2, 4, 5, 12},
            {5, 6, 9, 11},
        };

        System.out.println(Graf.istiGraf(m1, s1));
        System.out.println(Graf.istiGraf(m2, s3));
        System.out.println(Graf.istiGraf(m3, s10));
        System.out.println(Graf.istiGraf(m4, s4));
        System.out.println(Graf.istiGraf(m5, s5));
        System.out.println(Graf.istiGraf(m6, s6));
        System.out.println(Graf.istiGraf(m7, s2));
        System.out.println(Graf.istiGraf(m8, s9));
        System.out.println(Graf.istiGraf(m9, s7));
        System.out.println(Graf.istiGraf(m10, s8));
    }
}


public class Test44 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] m1 = {
            {F, T, F, T, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, F, T, F, F, F, F},
            {T, F, F, F, T, T, F, T, F, T, T},
            {F, F, F, T, F, F, F, T, F, F, F},
            {F, F, F, T, F, F, F, F, T, F, F},
            {F, F, T, F, F, F, F, F, T, T, T},
            {F, F, F, T, T, F, F, F, F, T, T},
            {F, F, F, F, F, T, T, F, F, F, F},
            {F, F, F, T, F, F, T, T, F, F, T},
            {F, F, F, T, F, F, T, T, F, T, F},
        };
        int[][] s1 = {
            {1, 3},
            {0, 2},
            {1, 6},
            {0, 4, 5, 7, 9, 10},
            {3, 7},
            {3, 8},
            {2, 8, 9, 10},
            {3, 4, 9, 10},
            {5, 6},
            {3, 6, 7, 10},
            {3, 6, 7, 9},
        };

        boolean[][] m2 = {
            {F, T, F, F, T, F, F, F, F, F, F},
            {T, F, T, T, T, F, T, F, F, F, T},
            {F, T, F, F, F, T, F, F, F, F, F},
            {F, T, F, F, T, T, T, T, T, T, T},
            {T, T, F, T, F, F, F, F, F, T, F},
            {F, F, T, T, F, F, T, T, F, F, F},
            {F, T, F, T, F, T, F, T, T, T, F},
            {F, F, F, T, F, T, T, F, T, F, F},
            {F, F, F, T, F, F, T, T, F, F, T},
            {F, F, F, T, T, F, T, F, F, F, T},
            {F, T, F, T, F, F, F, F, T, T, F},
        };
        int[][] s2 = {
            {1, 4},
            {0, 2, 3, 4, 6, 10},
            {1, 5},
            {1, 4, 5, 6, 7, 8, 9, 10},
            {0, 1, 3, 9},
            {2, 3, 6, 7},
            {1, 3, 5, 7, 8, 9},
            {3, 5, 6, 8},
            {3, 6, 7, 10},
            {3, 4, 6, 10},
            {1, 3, 8, 9},
        };

        boolean[][] m3 = {
            {F, T, T, T, T, F, T, T, T, F, T},
            {T, F, T, T, T, T, T, F, F, T, T},
            {T, T, F, T, T, T, T, T, F, T, T},
            {T, T, T, F, F, T, T, T, T, T, F},
            {T, T, T, F, F, T, T, T, F, T, T},
            {F, T, T, T, T, F, F, F, F, F, F},
            {T, T, T, T, T, F, F, T, T, T, T},
            {T, F, T, T, T, F, T, F, F, F, T},
            {T, F, F, T, F, F, T, F, F, F, T},
            {F, T, T, T, T, F, T, F, F, F, T},
            {T, T, T, F, T, F, T, T, T, T, F},
        };
        int[][] s3 = {
            {1, 2, 3, 4, 6, 7, 8, 10},
            {0, 2, 3, 4, 5, 6, 9, 10},
            {0, 1, 3, 4, 5, 6, 7, 9, 10},
            {0, 1, 2, 5, 6, 7, 8, 9},
            {0, 1, 2, 5, 6, 7, 9, 10},
            {1, 2, 3, 4},
            {0, 1, 2, 3, 4, 7, 8, 9, 10},
            {0, 2, 3, 4, 6, 10},
            {0, 3, 6, 10},
            {1, 2, 3, 4, 6, 10},
            {0, 1, 2, 4, 6, 7, 8, 9},
        };

        boolean[][] m4 = {
            {F, T, F, F, T, F, F, F, F, F, F},
            {T, F, T, T, T, F, T, F, T, T, T},
            {F, T, F, F, F, T, F, F, F, F, F},
            {F, T, F, F, F, F, F, F, F, F, T},
            {T, T, F, F, F, T, T, F, F, F, F},
            {F, F, T, F, T, F, T, T, T, T, T},
            {F, T, F, F, T, T, F, T, T, T, F},
            {F, F, F, F, F, T, T, F, F, F, F},
            {F, T, F, F, F, T, T, F, F, T, F},
            {F, T, F, F, F, T, T, F, T, F, F},
            {F, T, F, T, F, T, F, F, F, F, F},
        };
        int[][] s4 = {
            {1, 4},
            {0, 2, 3, 4, 6, 8, 9, 10},
            {1, 5},
            {1, 10},
            {0, 1, 5, 6},
            {2, 4, 6, 7, 8, 9, 10},
            {1, 4, 5, 7, 8, 9},
            {5, 6},
            {1, 5, 6, 9},
            {1, 5, 6, 8},
            {1, 3, 5},
        };

        boolean[][] m5 = {
            {F, T, T, F, F, F, F, F, F, F, F},
            {T, F, T, T, T, F, F, F, F, F, F},
            {T, T, F, F, F, T, T, F, F, F, F},
            {F, T, F, F, F, F, F, T, T, T, F},
            {F, T, F, F, F, T, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F, F},
            {F, F, T, F, F, F, F, F, F, F, T},
            {F, F, F, T, F, F, F, F, T, T, T},
            {F, F, F, T, F, F, F, T, F, F, F},
            {F, F, F, T, F, F, F, T, F, F, F},
            {F, F, F, F, F, F, T, T, F, F, F},
        };
        int[][] s5 = {
            {1, 2},
            {0, 2, 3, 4},
            {0, 1, 5, 6},
            {1, 7, 8, 9},
            {1, 5},
            {2, 4},
            {2, 10},
            {3, 8, 9, 10},
            {3, 7},
            {3, 7},
            {6, 7},
        };

        boolean[][] m6 = {
            {F, T, F, T, T, F, F, F, F, F, T},
            {T, F, T, F, F, F, F, F, F, F, F},
            {F, T, F, F, F, T, F, T, F, T, F},
            {T, F, F, F, T, F, T, F, F, T, F},
            {T, F, F, T, F, F, F, F, F, F, F},
            {F, F, T, F, F, F, T, F, T, F, F},
            {F, F, F, T, F, T, F, F, F, F, F},
            {F, F, T, F, F, F, F, F, T, T, T},
            {F, F, F, F, F, T, F, T, F, F, F},
            {F, F, T, T, F, F, F, T, F, F, T},
            {T, F, F, F, F, F, F, T, F, T, F},
        };
        int[][] s6 = {
            {1, 3, 4, 10},
            {0, 2},
            {1, 5, 7, 9},
            {0, 4, 6, 9},
            {0, 3},
            {2, 6, 8},
            {3, 5},
            {2, 8, 9, 10},
            {5, 7},
            {2, 3, 7, 10},
            {0, 7, 9},
        };

        boolean[][] m7 = {
            {F, T, F, T, T, T, F, F, F, F, F},
            {T, F, T, T, F, T, T, T, T, T, T},
            {F, T, F, F, T, F, T, T, T, F, T},
            {T, T, F, F, F, F, F, F, F, F, F},
            {T, F, T, F, F, F, F, F, F, F, F},
            {T, T, F, F, F, F, F, F, T, T, F},
            {F, T, T, F, F, F, F, T, F, F, F},
            {F, T, T, F, F, F, T, F, T, F, F},
            {F, T, T, F, F, T, F, T, F, T, T},
            {F, T, F, F, F, T, F, F, T, F, T},
            {F, T, T, F, F, F, F, F, T, T, F},
        };
        int[][] s7 = {
            {1, 3, 4, 5},
            {0, 2, 3, 5, 6, 7, 8, 9, 10},
            {1, 4, 6, 7, 8, 10},
            {0, 1},
            {0, 2},
            {0, 1, 8, 9},
            {1, 2, 7},
            {1, 2, 6, 8},
            {1, 2, 5, 7, 9, 10},
            {1, 5, 8, 10},
            {1, 2, 8, 9},
        };

        boolean[][] m8 = {
            {F, T, T, F, F, F, F, F, F, F, F},
            {T, F, F, T, T, F, T, F, F, F, F},
            {T, F, F, F, F, T, F, T, F, F, T},
            {F, T, F, F, F, F, F, F, T, F, F},
            {F, T, F, F, F, F, T, T, F, T, F},
            {F, F, T, F, F, F, F, F, T, F, F},
            {F, T, F, F, T, F, F, F, F, F, F},
            {F, F, T, F, T, F, F, F, F, F, F},
            {F, F, F, T, F, T, F, F, F, T, T},
            {F, F, F, F, T, F, F, F, T, F, F},
            {F, F, T, F, F, F, F, F, T, F, F},
        };
        int[][] s8 = {
            {1, 2},
            {0, 3, 4, 6},
            {0, 5, 7, 10},
            {1, 8},
            {1, 6, 7, 9},
            {2, 8},
            {1, 4},
            {2, 4},
            {3, 5, 9, 10},
            {4, 8},
            {2, 8},
        };

        boolean[][] m9 = {
            {F, T, F, T, F, F, F, T, T, T, T},
            {T, F, T, T, T, T, T, T, T, F, T},
            {F, T, F, F, T, F, F, F, T, T, F},
            {T, T, F, F, F, T, F, F, F, F, T},
            {F, T, T, F, F, F, T, F, F, F, T},
            {F, T, F, T, F, F, F, T, F, T, F},
            {F, T, F, F, T, F, F, F, F, F, F},
            {T, T, F, F, F, T, F, F, F, F, T},
            {T, T, T, F, F, F, F, F, F, F, T},
            {T, F, T, F, F, T, F, F, F, F, T},
            {T, T, F, T, T, F, F, T, T, T, F},
        };
        int[][] s9 = {
            {1, 3, 7, 8, 9, 10},
            {0, 2, 3, 4, 5, 6, 7, 8, 10},
            {1, 4, 8, 9},
            {0, 1, 5, 10},
            {1, 2, 6, 10},
            {1, 3, 7, 9},
            {1, 4},
            {0, 1, 5, 10},
            {0, 1, 2, 10},
            {0, 2, 5, 10},
            {0, 1, 3, 4, 7, 8, 9},
        };

        boolean[][] m10 = {
            {F, T, F, T, T, F, T, T, F, F, T},
            {T, F, T, T, F, F, T, T, F, F, T},
            {F, T, F, F, F, F, F, T, F, F, F},
            {T, T, F, F, F, F, F, F, T, T, F},
            {T, F, F, F, F, T, T, F, F, T, F},
            {F, F, F, F, T, F, T, T, F, F, T},
            {T, T, F, F, T, T, F, F, F, F, F},
            {T, T, T, F, F, T, F, F, F, F, F},
            {F, F, F, T, F, F, F, F, F, F, T},
            {F, F, F, T, T, F, F, F, F, F, F},
            {T, T, F, F, F, T, F, F, T, F, F},
        };
        int[][] s10 = {
            {1, 3, 4, 6, 7, 10},
            {0, 2, 3, 6, 7, 10},
            {1, 7},
            {0, 1, 8, 9},
            {0, 5, 6, 9},
            {4, 6, 7, 10},
            {0, 1, 4, 5},
            {0, 1, 2, 5},
            {3, 10},
            {3, 4},
            {0, 1, 5, 8},
        };

        System.out.println(Graf.istiGraf(m1, s10));
        System.out.println(Graf.istiGraf(m2, s1));
        System.out.println(Graf.istiGraf(m3, s3));
        System.out.println(Graf.istiGraf(m4, s8));
        System.out.println(Graf.istiGraf(m5, s5));
        System.out.println(Graf.istiGraf(m6, s6));
        System.out.println(Graf.istiGraf(m7, s7));
        System.out.println(Graf.istiGraf(m8, s9));
        System.out.println(Graf.istiGraf(m9, s2));
        System.out.println(Graf.istiGraf(m10, s4));
    }
}

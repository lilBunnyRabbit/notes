
public class Test32 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 2, 3, 4, 6, 7, 8, 10, 11, 13},
            {0, 4},
            {0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            {0, 2, 5, 11},
            {0, 1, 2, 6},
            {2, 3, 8, 9},
            {0, 2, 4, 7},
            {0, 2, 6, 8, 9, 10, 11, 12},
            {0, 2, 5, 7},
            {2, 5, 7, 12},
            {0, 2, 7, 11, 12, 13},
            {0, 2, 3, 7, 10, 12},
            {2, 7, 9, 10, 11, 13},
            {0, 2, 10, 12},
        };
        izpisiMatriko(Graf.vMatriko(s));
    }

    private static void izpisiMatriko(boolean[][] m) {
        for (int i = 0;  i < m.length;  i++) {
            for (int j = 0;  j < m[i].length;  j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(m[i][j] ? "T" : "F");
            }
            System.out.println();
        }
    }
}

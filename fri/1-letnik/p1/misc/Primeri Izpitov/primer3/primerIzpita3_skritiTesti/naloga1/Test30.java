
public class Test30 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 8, 9, 11},
            {0, 2},
            {1, 3, 5, 8, 10, 11},
            {2, 4, 5, 6, 8, 9, 10},
            {3, 5, 6, 7, 8, 10},
            {2, 3, 4, 6, 7, 10, 11},
            {3, 4, 5, 8, 9, 10},
            {4, 5},
            {0, 2, 3, 4, 6, 9},
            {0, 3, 6, 8},
            {2, 3, 4, 5, 6, 11},
            {0, 2, 5, 10},
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

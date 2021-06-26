
public class Test28 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 2, 4, 6},
            {0, 3, 4, 5, 8, 9},
            {0, 6},
            {1, 4, 7, 9},
            {0, 1, 3, 5},
            {1, 4},
            {0, 2, 7, 8},
            {3, 6, 8, 9},
            {1, 6, 7, 9},
            {1, 3, 7, 8},
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

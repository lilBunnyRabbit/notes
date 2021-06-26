
public class Test33 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 2, 3, 4},
            {0, 8},
            {0, 4, 5, 6, 7, 8, 9, 10, 12, 14},
            {0, 13},
            {0, 2, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14},
            {2, 4, 7, 8, 10, 11, 14},
            {2, 4, 7, 8, 9, 10, 11, 12, 13},
            {2, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14},
            {1, 2, 4, 5, 6, 7, 10, 11},
            {2, 4, 6, 7},
            {2, 4, 5, 6, 7, 8, 12, 14},
            {4, 5, 6, 7, 8, 12, 13, 14},
            {2, 4, 6, 7, 10, 11},
            {3, 4, 6, 7, 11, 14},
            {2, 4, 5, 7, 10, 11, 13},
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

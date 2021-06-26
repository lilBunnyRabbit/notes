
public class Test31 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 3, 4, 5},
            {0, 2, 7, 11},
            {1, 4, 6, 10},
            {0, 9},
            {0, 2, 6, 12},
            {0, 7, 10, 12},
            {2, 4, 8, 9},
            {1, 5, 8, 9, 10, 11, 12},
            {6, 7},
            {3, 6, 7, 11},
            {2, 5, 7, 12},
            {1, 7, 9, 12},
            {4, 5, 7, 10, 11},
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


public class Test29 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 5},
            {0, 2, 6, 8},
            {1, 3, 4, 5},
            {2, 5},
            {2, 10},
            {0, 2, 3, 6, 7, 8, 9, 10},
            {1, 5, 7, 8, 10},
            {5, 6, 9},
            {1, 5, 6, 10},
            {5, 7},
            {4, 5, 6, 8},
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

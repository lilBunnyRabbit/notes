
public class Test25 {

    public static void main(String[] args) {
        int[][] s = {
            {1, 3, 4, 5, 6},
            {0, 2},
            {1, 3, 4, 5},
            {0, 2},
            {0, 2, 5, 6},
            {0, 2, 4, 6},
            {0, 4, 5},
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

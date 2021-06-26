import java.util.Scanner;
import java.util.Arrays;

class Dolgovi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int stOseb = sc.nextInt();
        int stIzposoj = sc.nextInt();

        int[][] nepobotaniDolgovi = new int[stOseb][stOseb];
        int[][] pobotaniDolgovi = new int[stOseb][stOseb];

        for (int i = 0; i < stIzposoj; i++) {
            int prvaOseba = sc.nextInt();
            int drugaOseba = sc.nextInt();
            int izposoja = sc.nextInt();

            nepobotaniDolgovi[prvaOseba - 1][drugaOseba - 1] += izposoja;
        }

        for (int i = 0; i < stOseb; i++) {
            for (int j = 0; j < stOseb; j++) {
                int a = nepobotaniDolgovi[i][j];
                int b = nepobotaniDolgovi[j][i];
                if (a < b) {
                    pobotaniDolgovi[i][j] = 0;
                    pobotaniDolgovi[j][i] = b - a; 

                }else if(a > b){
                    pobotaniDolgovi[i][j] = a - b;
                    pobotaniDolgovi[j][i] = 0;

                }else if(a == b){
                    pobotaniDolgovi[i][j] = 0;
                    pobotaniDolgovi[j][i] = 0;
                }

            }
        }

        System.out.println(Arrays.deepToString(nepobotaniDolgovi));
        System.out.println(Arrays.deepToString(pobotaniDolgovi));
    }
}
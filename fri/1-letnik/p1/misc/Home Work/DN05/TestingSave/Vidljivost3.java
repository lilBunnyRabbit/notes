import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Vidljivost3{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int stOseb = sc.nextInt();
        int vsota = 0;
        int v1 = 0;
        int v2 = sc.nextInt();
        int stevec = 0;
        int[][] ohranjeneVisine = new int[1][2];

        for (int oseba = 0; oseba < stOseb - 1; oseba++) {
            v1 = v2;
            v2 = sc.nextInt();
            if (oseba == 0){
                if (v1 > v2){
                    ohranjeneVisine[0][0] = v1;
                    stevec++;
                    vsota += 2;
                }

            }else if (v1 < v2){
                if(v2 > ohranjeneVisine[0][0]){
                    ohranjeneVisine[0][0] = v2;
                    ohranjeneVisine[0][1] = oseba + 1;

                }else{
                    ohranjeneVisine[stevec][0] = v2;
                    ohranjeneVisine[stevec][1] = oseba + 1;
                    stevec++;
                }

            }else if (v1 == v2){
                if(v1 > ohranjeneVisine[0][0]){
                    ohranjeneVisine[0][0] = v1;
                    ohranjeneVisine[0][1] = oseba + 1;

                }else{
                    ohranjeneVisine[stevec][0] = v1;
                    ohranjeneVisine[stevec][1] = oseba + 1;
                    stevec++;

                }
                stevec++;
            }else if (v1 > v2){
                vsota++;
            }

        }
        System.out.println(ohranjeneVisine.length);
        System.out.println(Arrays.deepToString(ohranjeneVisine));


    } 
    private static int[][] increaseSize(int[][] ohranjeneVisine, int zadnjiElement, int zadnjaPozicija) {
        int length = ohranjeneVisine.length;
        int[][] newArray = new int[length + 1][2];
        for (int i = 0; i < length; i++) {
            newArray[i][0] = ohranjeneVisine[i][0];
            newArray[i][1] = ohranjeneVisine[i][1];
        }
        newArray[length + 1][0] = zadnjiElement;
        newArray[length + 1][1] = zadnjaPozicija;


        return newArray;
    }
}
import java.util.Scanner;

public class Visibility_dejan {

    public static long distance;
    public static int[] row;
    public static int lenght;

    public static void main(String[] args) {
        
        inputOfElements();
        
        for (int i = 1; i <= lenght; i++) {
            distance = isBiggerthan(i);
        }
        System.out.println(distance);

    }

    private static void inputOfElements(){

        Scanner sc = new Scanner(System.in);
        lenght = sc.nextInt();
        row = new int[lenght+1];
        row[0] = 99999;

        for (int i = 1; i <= lenght; i++) {
            row[i] = sc.nextInt();
        }

    }

    private static long isBiggerthan(int i){

        if (row[i] < row[i - 1]) { 

            distance += 1;
            return distance;
            
        }else{

            for (int j = i; j >= 0; j--) {

                if(row[i] < row[j]){
                    distance = distance + (i - j);  
                    return distance;
                }

            }
            return i;
        }
    }
}


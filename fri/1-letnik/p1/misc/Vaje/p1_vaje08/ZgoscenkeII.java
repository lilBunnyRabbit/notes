import java.util.Scanner;
import java.util.Arrays;

public class ZgoscenkeII{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stZgoscenk = sc.nextInt();
        int velZgoscenk = sc.nextInt();
        int[] zgoscenke = new int[stZgoscenk];

        while(sc.hasNextInt()){
            int datoteka = sc.nextInt();
            int najZgoscenka = 0;
            
            for (int i = 0; i < stZgoscenk; i++) {
                if(zgoscenke[i] < zgoscenke[najZgoscenka]){
                    najZgoscenka = i;
                }
            }

            if((zgoscenke[najZgoscenka] + datoteka) > velZgoscenk){
                break;

            }else{
                zgoscenke[najZgoscenka] += datoteka;
                System.out.printf("%d EP -> zgoscenka %d ", datoteka, najZgoscenka + 1);
                System.out.print(Arrays.toString(zgoscenke));
                System.out.println();

            }

        }
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Izstevanka{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stOtrok = sc.nextInt();
        int stIzstevanke = sc.nextInt();
        String[] otroci = new String[stOtrok];
        

        for (int i = 0; i < stOtrok; i++) {otroci[i] = sc.next();}

        otroci[0] = null;

        while(true){

        }
        System.out.print(Arrays.toString(otroci));



    }
}

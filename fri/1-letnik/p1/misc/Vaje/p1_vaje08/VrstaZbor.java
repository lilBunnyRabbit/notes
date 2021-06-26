import java.util.Scanner;

public class VrstaZbor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stVojakov = sc.nextInt();
        int[] visineVojakov = new int[stVojakov];
        int stevec = 0;

        for (int i = 0; i < stVojakov; i++) {
            visineVojakov[i] = sc.nextInt();
        }
        
        for (int j = 0; j < stVojakov; j++) {
            if(j == 0){
                if(visineVojakov[0] <= visineVojakov[1]){
                    System.out.println(0);
                    stevec++;
                }
            }else if(j == stVojakov - 1){
                if(visineVojakov[j] >= visineVojakov[j-1]){
                    System.out.println(j);
                    stevec++;
                }
            }else{
                if(visineVojakov[j] >= visineVojakov[j - 1] && visineVojakov[j] <= visineVojakov[j + 1]){
                    System.out.println(j);
                    stevec++;
                }
            }
        }

        if (stevec == 0) {
            System.out.println("NOBEDEN");
        }
        
    }
}

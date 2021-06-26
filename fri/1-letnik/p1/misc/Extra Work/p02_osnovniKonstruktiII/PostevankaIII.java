import java.util.Scanner;

public class PostevankaIII{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for(int i = 1; i <= b; i++){
            if(a * i > b){
                break;
            }
            System.out.printf("%d * %d = %d\n", a, i, a * i);
        }  	
	}
}
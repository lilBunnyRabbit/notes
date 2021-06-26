import java.util.Scanner;

public class Potenca{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int stevec = a;
        for(int i = 0; i < b - 1; i++){
            stevec = stevec * a;
        }
        if(b == 0){
            stevec = 1;
        }

        System.out.println(stevec);
        	
	}
}
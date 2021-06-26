import java.util.Scanner;

public class NajblizjiVeckratnik{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 0;

        for(int i = a; i <= b; i = i + a){
            c = i;
        }

        if((b - c) < (a + c - b)){
            System.out.println(c);
        }else if((b - c) == (a + c - b)){
            System.out.println(c);
        }else{
            System.out.println(a + c);
        }
		
	}
}
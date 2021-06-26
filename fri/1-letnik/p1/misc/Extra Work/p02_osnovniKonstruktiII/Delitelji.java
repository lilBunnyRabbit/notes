import java.util.Scanner;

public class Delitelji{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int stevec = 0;

        for(int i = 1; i <= a; i++){
            stevec = 0;
            for(int j = 1; stevec <= a ;j++){
                stevec = i * j;
                if(stevec == a){
                    System.out.println(i);
                }
            }
        }

        
        	
	}
}
import java.util.Scanner;

public class Trihotomija{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int stevilo1 = sc.nextInt();
        int stevilo2 = sc.nextInt();
        if(stevilo1 > stevilo2){
            System.out.println(1);
        }else if(stevilo1 < stevilo2){
            System.out.println(-1);
        }else{
            System.out.println(0);
        }
        
		
	}
}
import java.util.Scanner;

public class Vsota{
	public static void main(String[] args){
		// preberemo stevili
		
		Scanner sc = new Scanner(System.in);
		int prvo = sc.nextInt();
		int drugo = sc.nextInt();
		
		// izracunamo vsoto prebranih stevil
		
		int vsota = prvo + drugo;
		
		//izpisemo vsoto
		
		System.out.println(vsota);
		
		
	}
}
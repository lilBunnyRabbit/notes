import java.util.Scanner;

public class Collatz{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		long stevilo = sc.nextInt();

		while (stevilo>0){
			int zadnjaStevka = (int) (stevilo % 10);
			System.out.println(zadnjaStevka);
			
			stevilo = stevilo/10;
		}
		
	}
}
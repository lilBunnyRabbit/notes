import java.util.Scanner;

public class Romanje_I{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int prvo = sc.nextInt();
		int drugo = sc.nextInt();
		
		System.out.println(prvo);
		while (prvo > drugo){
			prvo = prvo - drugo;
			System.out.println(prvo);
			
		}
		
	}
}
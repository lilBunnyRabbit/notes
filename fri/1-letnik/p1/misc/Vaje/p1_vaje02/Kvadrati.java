import java.util.Scanner;

public class Kvadrati{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int prvo = sc.nextInt();
		int drugo = sc.nextInt();
				
		for (int i = prvo; i <= drugo; i++) {
			int kvadrat = i*i;
			
			System.out.println(kvadrat);
		}
	}
}
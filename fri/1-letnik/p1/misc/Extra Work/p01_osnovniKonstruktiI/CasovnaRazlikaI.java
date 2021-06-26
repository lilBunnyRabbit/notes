import java.util.Scanner;

public class CasovnaRazlikaI{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int ura1 = sc.nextInt();
        int minuta1 = sc.nextInt();
        int ura2 = sc.nextInt();
        int minuta2 = sc.nextInt();
        
        int skupaj1 = ura1 * 60 + minuta1;
        int skupaj2 = ura2 * 60 + minuta2;

        int razlika = Math.abs(skupaj1 - skupaj2);

        System.out.println(razlika);
        
		
	}
}
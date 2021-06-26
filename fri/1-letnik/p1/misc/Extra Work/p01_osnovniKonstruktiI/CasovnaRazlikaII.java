import java.util.Scanner;

public class CasovnaRazlikaII{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int ura1 = sc.nextInt();
        int minuta1 = sc.nextInt();
        int ura2 = sc.nextInt();
        int minuta2 = sc.nextInt();
        
        int skupaj1 = ura1 * 60 + minuta1;
        int skupaj2 = ura2 * 60 + minuta2;

        int razlika = Math.abs(skupaj1 - skupaj2);
        int stUr = razlika / 60;
        int stMinut = razlika - stUr * 60;

        if(stMinut < 10){
            System.out.printf("%d:0%d", stUr, stMinut);
        }else{
            System.out.printf("%d:%d", stUr, stMinut);
        }
        
        
		
	}
}
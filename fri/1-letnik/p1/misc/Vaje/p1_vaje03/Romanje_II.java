import java.util.Scanner;

public class Romanje_II{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int prvo = sc.nextInt();
		int drugo = sc.nextInt();
		int razlika = prvo;
		int dan = 1;
		int naslednja_razlika = 1;
		while (naslednja_razlika != 0){
			if(razlika > drugo){
				naslednja_razlika = razlika - drugo;
				
			}else {
				drugo = razlika;
				naslednja_razlika = razlika - drugo;
				
			}
			
			System.out.println(dan + ". dan: " + razlika + " -> " + naslednja_razlika + " (prehodil " + drugo + ")");
			razlika = razlika - drugo;
			dan = dan + 1;
			
			
		}
		
	}
}
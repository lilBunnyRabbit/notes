import java.util.Scanner;

public class DN00_63180202{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int stBombonov = sc.nextInt();
		int stPrijateljev = sc.nextInt();
		
		int razdelitev = (int) (stBombonov / stPrijateljev);
		int ostanek = stBombonov - (stPrijateljev * razdelitev);

		System.out.println(razdelitev);
		System.out.println(ostanek);
		
	}
}
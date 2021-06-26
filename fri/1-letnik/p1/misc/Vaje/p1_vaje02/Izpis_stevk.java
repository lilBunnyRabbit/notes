import java.util.Scanner;

public class Izpis_stevk{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int stevilo = sc.nextInt();
		int stevec = 0;
		while (stevilo>0){
			stevilo = stevilo/10;
			stevec++;
		}
		System.out.println(stevec);
		
	}
}

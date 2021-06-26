import java.util.Scanner;

public class Piramida{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int visina = sc.nextInt();
		int presledek = visina - 1;
		int zvezdice = 1;
		
	for(int i=0; i<visina; i++){
			for(int j=0; j<presledek; j++){
				System.out.print(" ");
			}

			for(int k=0; k<zvezdice; k++){
				System.out.print("*");
			}
			System.out.println();
			zvezdice = zvezdice + 2;
			presledek--;
	}
		
	}
}
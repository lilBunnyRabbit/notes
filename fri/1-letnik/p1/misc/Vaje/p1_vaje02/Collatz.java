import java.util.Scanner;

public class Collatz{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int clen = sc.nextInt();
		int stClenov = 1;

		while (clen>1){
			if(clen % 2 == 0){
				clen = clen / 2;
				
			}else {
				clen = 3 * clen + 1;
				
			}
			stClenov++;
			//System.out.println(clen)
		}
		
	}
}
import java.util.Scanner;

public class Zgoscenke{
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int stDiskov = sc.nextInt();
        int velikostDiskov = sc.nextInt();
        int naDisku = 0;
        int disk = 1;
        int zacasno = 0;

        while(sc.hasNextInt() ){
            int naslednja = sc.nextInt();

            zacasno = naDisku + naslednja;
            if(zacasno <= velikostDiskov){
                naDisku += naslednja;
                System.out.println(naslednja + "EP -> zgoscenka" + disk + "(" + naDisku + "EP)");

            }else{
                naDisku = 0;
                disk++;
                naDisku += naslednja;
                System.out.println(naslednja + "EP -> zgoscenka" + disk + "(" + naDisku + "EP)");
            }

            
        }
	}
}
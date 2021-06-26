import java.util.Scanner;

public class MedianaTrojiceI{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int mediana = 0;

        if(a > b){
            if(a < c){
                mediana = a;
            }else if(c > b){
                mediana = c;
            }else{
                mediana = b;
            }
        }else if(b < c){
            mediana = b;
        }else if(c > a){
            mediana = c;
        }else{
            mediana = a;
        }

        System.out.println(mediana);
		
	}
}
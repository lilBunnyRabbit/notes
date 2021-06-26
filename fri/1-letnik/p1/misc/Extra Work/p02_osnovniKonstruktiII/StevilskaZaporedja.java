import java.util.Scanner;

public class StevilskaZaporedja{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int k = sc.nextInt();

        int stevec = a;

        if(k == 0){
            System.out.println("NAPAKA");
        }else if(a > b && k > 0){
            System.out.println("NAPAKA");
        }else if(a < b && k < 0){
            System.out.println("NAPAKA");
        }else if(a != b){
            do{
                System.out.println(stevec);
                stevec += k;
                if(a < b){
                    if(stevec > b){
                        break;
                    }
                }
                if(a > b){
                    if(stevec < b){
                        break;
                    }
                }
                
            }while(true);

        }else{
            System.out.println(stevec);
        }
 	
	}
}
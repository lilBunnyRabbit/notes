import java.util.Scanner;

public class EvroSop{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int ena = 0;
        int dve = 0;

        int aliBankrot = 0;

        while(sc.hasNextInt() ){
            int a = sc.nextInt();
            if(a == 1){
                ena++;
            }else if(a == 2){
                if(ena == 0){
                    System.out.println("BANKROT");
                    aliBankrot = 1;
                    break;
                }else{
                    ena--;
                    dve++;
                }
            }else{
                System.out.println(ena);
                System.out.println(dve);
            }

        }
        if(aliBankrot == 0){
            System.out.println(ena);
            System.out.println(dve);
        }


        
        	
	}
}
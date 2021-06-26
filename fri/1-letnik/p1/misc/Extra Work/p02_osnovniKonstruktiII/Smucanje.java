import java.util.Scanner;

public class Smucanje{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int stTekmovalcev = sc.nextInt();
        int najboljsiTekmovalec = 0;
        int najboljsiCas = 0;

        for(int i = 0; i < stTekmovalcev; i++){
            int rezultat1 = sc.nextInt();
            if(rezultat1 != 0){
                int rezultat2 = sc.nextInt();
                if(rezultat2 != 0){
                    int skupniCas = rezultat1 + rezultat2;
                    if(i == 0 || najboljsiCas == 0){
                        najboljsiCas = skupniCas;
                    }

                    if(skupniCas <= najboljsiCas){
                        najboljsiCas = skupniCas;
                        najboljsiTekmovalec = i + 1;
                    }
                }
            }
        }    
        

        if(najboljsiCas == 0){
            System.out.println("NIHCE");
        }else{
            System.out.println(najboljsiTekmovalec);
            System.out.println(najboljsiCas);
        }
        
        	
	}
}
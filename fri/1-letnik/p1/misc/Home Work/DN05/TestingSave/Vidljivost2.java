import java.util.Scanner;
import java.util.Arrays;

class Vidljivost2{
    private static Scanner sc = new Scanner(System.in);
    private static long counter;
    public static void main(String[] args){
        int stVisin = sc.nextInt();
        int[] visine = new int[stVisin];
        int pozicijaNajvecjega = 0;

        for (int o = 0; o < stVisin; o++) {
            visine[o] = sc.nextInt();
            int v = visine[o];

            if(o == 0){ 
                counter++; 
            }

            else if(v >= visine[0]){ 
                visine[0] = visine[o];
                pozicijaNajvecjega = o;
                counter += o + 1; 
            }

            else if(v < visine[o - 1]){ 
                counter++; 
            }

            else if(v >= visine[o - 1]){
                for (int i = 1; i < stVisin - pozicijaNajvecjega; i++) {
                    counter++;
                    if(v < visine[o - i]){
                        break;   
                    }
                }  
            }
        }

        System.out.println(counter);
    } 
}
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Vidljivost4{
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int stOseb = sc.nextInt();
        int vsota = 1;
        int v1 = 0;
        int v2 = sc.nextInt();
        int najVis = 0;
        int najPoz = 0;
        int najVis2 = 0;
        int najPoz2 = 0;
        int vL = 0;
        int pL = 0;
        List<Integer> visine = new ArrayList<Integer>();
        List<Integer> pozicije = new ArrayList<Integer>();

        for (int oseba = 1; oseba < stOseb; oseba++) {
            v1 = v2;
            v2 = sc.nextInt();
            System.out.println(v2);
            if (v1 > v2){
                vsota++;

            }else if (v1 < v2 ) {
                
                if (v2 >= najVis || v2 >= visine.get(0)) {
                    vsota += oseba + 1;
                    najVis = v2;
                    najPoz = oseba + 1;
                    visine.clear();
                    System.out.println("CLEAR");

                }else{
                    int visineSize = visine.size();
                    for (int i = 1; i <= visineSize; i++) {
                        vL = visine.get(visine.size() - i);
                        pL = pozicije.get(pozicije.size() - i);

                        if( v2 >= vL){
                            System.out.println("Odstranil: " + vL);
                            visine.remove(visine.size() - i);
                            pozicije.remove(pozicije.size() - i);
                        }else if(v2 < vL){ 
                            System.out.println(vL+"2Dodal:" + v2);                           
                            visine.add(v2);
                            pozicije.add(oseba);
                            vsota += oseba - pL;
                            break;
                        }
                    }
                }
            }
            System.out.println(visine + "\n");
            //System.out.println(pozicije);
            //System.out.println("Vsota:" + vsota + "\n");

        }

        System.out.println(vsota);
        //System.out.println(Arrays.deepToString(ohranjeneVisine));
        //echo 10 2 10 5 9 7 6 2 4 3 1 | java Vidljivost4

    } 
}
import java.util.Scanner;

class DN05_63180202{
    private static int najVisina, najPoz;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int stOseb = sc.nextInt();
        int[] visine = new int[stOseb];
        visine = insertValues(visine, stOseb, sc); 
        long vsota = 0; 
        for (int i = 0; i < stOseb; i++) { vsota += checkHeight(visine, i); }
        System.out.println(vsota);
    }

    private static int[] insertValues(int[] visine, int stOseb, Scanner sc) {
        for (int oseba = 0; oseba < stOseb; oseba++) {
            visine[oseba] = sc.nextInt();
        }
        return visine;
    }

    private static int checkHeight(int[] visine, int oseba) {
        if(visine[oseba] >= najVisina){
            najVisina = visine[oseba];
            najPoz = oseba;
            return oseba + 1;
        }else{
            if(oseba <= 0){ return 1; }
            else if(visine[oseba - 1] > visine[oseba]){ return 1; }
            else{
                for (int i = 1; i <= (oseba - najPoz) + 1; i++) {
                    if(visine[oseba - i] > visine[oseba]){ return i; }
                    if (oseba - i == 0) { return i + 1; }
                }
            }
        }
        return 1;
    }
}
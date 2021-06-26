import java.util.Scanner;

class EnotirnaProga8{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas, najPostaja, najmPostaja, vsotaTa, vsotaTb;
    private static boolean soda;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stPostaj = sc.nextInt();
        shraniPostaje(sc);
        stPrimerov = sc.nextInt();
        calcSkupniCas(sc);
        System.out.println(vsotaPostaj);
        System.out.println(najmPostaja);
        System.out.println(najPostaja);
        System.out.println(skupniCas);
    }  

    private static void shraniPostaje(Scanner sc) {
        casiPostaj = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
            if(i < casiPostaj.length / 2){
                vsotaTa += cas;
            }
        }

        if(stPostaj % 2 == 0){
            vsotaTb = vsotaPostaj - vsotaTa - casiPostaj[casiPostaj.length / 2];
            soda = true;
        }else{
            vsotaTb = vsotaPostaj - vsotaTa;
            soda = false;
        }

        najmPostaja = vsotaPostaj;
        System.out.println(vsotaTa + " <> " + vsotaTb);
        System.out.println("Vsita " + vsotaPostaj);

    }
    

    private static void calcSkupniCas(Scanner sc){
        System.out.println("StPostaj: " + stPostaj);

        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                skupniCas += najmanjsiCasPrimera(tA, tB);
            }       
        }
    }

    private static int najmanjsiCasPrimera(int tA, int tB) {

        if(tA > tB){
            int casTa = tA;
            int casTb = tB + vsotaPostaj;
            int najmCas = Math.abs(casTa - casTb);
            for (int i = 1; i < stPostaj; i++) {
                casTa += casiPostaj[i - 1];
                casTb -= casiPostaj[i - 1];
    
                if(Math.abs(casTa - casTb) < najmCas){
                    najmCas = Math.abs(casTa - casTb);
                }else{
                    System.out.println(tA + " : " + tB + " = " + i);
                    return najmCas;
                }
            }

        }else{
            int casTa = tA + vsotaPostaj;
            int casTb = tB;
            int najmCas = Math.abs(casTa - casTb);
            for (int i = stPostaj - 1; i > 0; i--) {
                casTa -= casiPostaj[i - 1];
                casTb += casiPostaj[i - 1];
    
                if(Math.abs(casTa - casTb) < najmCas){
                    najmCas = Math.abs(casTa - casTb);
                }else{
                    System.out.println(tA + " : " + tB + " = " + i);
                    return najmCas;
                }
            }
        }
        return 0;
        

    }
}


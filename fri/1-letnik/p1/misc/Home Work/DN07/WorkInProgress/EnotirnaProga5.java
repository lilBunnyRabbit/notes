import java.util.Scanner;

class EnotirnaProga5{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stPostaj = sc.nextInt();
        shraniPostaje(sc);
        stPrimerov = sc.nextInt();
        calcSkupniCas(sc);

        System.out.println(skupniCas);
    }  

    private static void shraniPostaje(Scanner sc) {
        casiPostaj = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
        }
    }

    private static void calcSkupniCas(Scanner sc){
        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                skupniCas += najmanjsiCasPrimera(tA, tB);
            }
                 
        }
    }

    private static int najmanjsiCasPrimera(int tA, int tB) {
        int casTa = tA;
        int casTb = tB + vsotaPostaj;
        int najmCas = Math.abs(casTa - casTb);
        for (int i = 1; i < stPostaj; i++) {
            casTa += casiPostaj[i - 1];
            casTb -= casiPostaj[i - 1];

            if(Math.abs(casTa - casTb) < najmCas){
                najmCas = Math.abs(casTa - casTb);
            }else{
                return najmCas;
            }
        }
        return 0;
    }
}


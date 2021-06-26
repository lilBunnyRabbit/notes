import java.util.Scanner;

class EnotirnaProga12{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas, vsotaTa, vsotaTb;
    private static boolean soda;
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
        int najmCas = 0;
        int dodatekL = 0;
        int dodatekD = 0;
        int polovicaCasov = casiPostaj.length / 2;

        if(soda){
            if(tA + vsotaTa > tB + vsotaTb){
                tA += vsotaTa;
                tB += vsotaTb + casiPostaj[polovicaCasov];
                najmCas = Math.abs(tB - tA);
                dodatekL = -1;
            }else if(tA + vsotaTa < tB + vsotaTb){
                tA += vsotaTa + casiPostaj[polovicaCasov];
                tB += vsotaTb;
                najmCas = Math.abs(tA - tB);
                dodatekD = 1;
            }
        }else{
            tA += vsotaTa;
            tB += vsotaTb;
            najmCas = Math.abs(tA - tB);
            dodatekL = -1;
        }
        
        if (tA > tB) {
            for (int i = 0; i < polovicaCasov; i++) {
                tA -= casiPostaj[polovicaCasov - i + dodatekL];
                tB += casiPostaj[polovicaCasov - i + dodatekL];
                if(Math.abs(tA - tB) < najmCas){
                    najmCas = Math.abs(tA - tB);
                }else{
                    return najmCas;
                }
            }
        }else if(tA < tB){
            for (int i = 0; i < polovicaCasov; i++) {
                tA += casiPostaj[polovicaCasov + i + dodatekD];
                tB -= casiPostaj[polovicaCasov + i + dodatekD];
                if(Math.abs(tA - tB) < najmCas){
                    
                    najmCas = Math.abs(tA - tB);
                }else{
                    return najmCas;
                }
            }
        }

        return najmCas;

    }
}


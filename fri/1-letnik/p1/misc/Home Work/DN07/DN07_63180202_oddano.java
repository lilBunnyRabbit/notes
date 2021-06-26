import java.util.Scanner;

class DN07_63180202_oddano{
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
        int taOriginal = tA;
        int tbOriginal = tB;
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

        if(Math.abs((taOriginal + vsotaPostaj) - tbOriginal) < najmCas || 
           Math.abs((tbOriginal + vsotaPostaj) - taOriginal) < najmCas){
            return preglejOdZacetka(taOriginal, tbOriginal);

        }else{ 
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
        }
        return najmCas;

    }
    
    private static int preglejOdZacetka(int tA, int tB) {
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
                    return najmCas;
                }
            }
        }
        return 0;
    }
}


import java.util.Scanner;

class EnotirnaProga10{
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

        System.out.println("vostaTa " + vsotaTa + " vsotaTb " + vsotaTb);
        if(soda){
            if(tA + vsotaTa > tB + vsotaTb){
                tA += vsotaTa;
                tB += vsotaTb + casiPostaj[casiPostaj.length / 2];
                najmCas = Math.abs(tB - tA);
                dodatekL = -1;
            }else if(tA + vsotaTa < tB + vsotaTb){
                tA += vsotaTa + casiPostaj[casiPostaj.length / 2];
                tB += vsotaTb;
                najmCas = Math.abs(tA - tB);
                dodatekD = 1;
            }
            najmCas = preveriLevo(najmCas, tA, tB, dodatekL);
            najmCas = preveriDesno(najmCas, tA, tB, dodatekD);

        }else{
            tA += vsotaTa;
            tB += vsotaTb;
            najmCas = Math.abs(tA - tB);
            dodatekL = -1;

            najmCas = preveriLevo(najmCas, tA, tB, dodatekL);
            najmCas = preveriDesno(najmCas, tA, tB, dodatekD);
        }
        
        return najmCas;

    }

    private static int preveriLevo(int najmCas, int tA, int tB, int dodatekL) {
        int polovicaCasov = casiPostaj.length / 2;
        for (int i = 0; i < polovicaCasov; i++) {
            tA -= casiPostaj[polovicaCasov - i + dodatekL];
            tB += casiPostaj[polovicaCasov - i + dodatekL];
            if(Math.abs(tA - tB) < najmCas){
                najmCas = Math.abs(tA - tB);
            }else{
                return najmCas;
            }
        }
        return najmCas;
    }

    private static int preveriDesno(int najmCas, int tA, int tB, int dodatekD) {
        int polovicaCasov = casiPostaj.length / 2;
        for (int i = 0; i < polovicaCasov; i++) {
            tA += casiPostaj[polovicaCasov + i + dodatekD];
            tB -= casiPostaj[polovicaCasov + i + dodatekD];
            if(Math.abs(tA - tB) < najmCas){
                
                najmCas = Math.abs(tA - tB);
            }else{
                return najmCas;
            }
        }
        return najmCas;
    }
}


import java.util.Scanner;

class EnotirnaProga11{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas;
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
        int postajaTa = 0;
        int postajaTb = casiPostaj.length - 1;
        while (postajaTa != postajaTb) {
            if (tA > tB) {
                tB += casiPostaj[postajaTb];
                postajaTb--;
            }else if (tA < tB) {
                tA += casiPostaj[postajaTa];
                postajaTa++;
            }else{
                if(casiPostaj[postajaTa] > casiPostaj[postajaTb]){
                    tB += casiPostaj[postajaTb];
                    postajaTb--;
                }else{
                    tA += casiPostaj[postajaTa];
                    postajaTa++;
                }
            }
        }

        if (tA > tB) {
            tB += casiPostaj[postajaTb];
            postajaTb--;
        }else if (tA < tB) {
            tA += casiPostaj[postajaTa];
            postajaTa++;
        }else{
            if(casiPostaj[postajaTa] > casiPostaj[postajaTb]){
                tB += casiPostaj[postajaTb];
                postajaTb--;
            }else{
                tA += casiPostaj[postajaTa];
                postajaTa++;
            }
        }
        return Math.abs(tA - tB);
    }
}


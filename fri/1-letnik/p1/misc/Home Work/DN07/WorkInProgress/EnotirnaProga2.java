import java.util.Scanner;

class EnotirnaProga2{
    private static int[] casiPostaj, najmanjsiCasiPostaj;
    private static int[][] primeri;
    private static int stPostaj, stPrimerov, vsotaPostaj;
    private static boolean enakiCasi;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        enakiCasi = true;
        stPostaj = sc.nextInt();
        shraniPostaje(sc);
        stPrimerov = sc.nextInt();
        shraniPrimere(sc);
        int skupniCas = 0;

        if (enakiCasi = false) {
            for (int i = 0; i < stPrimerov; i++) {
                 if(stPostaj % 2 == 0){
                    skupniCas += casiPostaj[0] + Math.abs(primeri[i][0] - primeri[i][1]);
                 }else{
                    skupniCas += Math.abs(primeri[i][0] - primeri[i][1]);
                 }
            }
        }else{
            for (int i = 0; i < stPrimerov; i++) {
                if(Math.abs(primeri[i][0] - primeri[i][1]) < vsotaPostaj){
                    skupniCas += najmanjsiCasPrimera(i);
                }
            }
        }

        System.out.println(skupniCas);
    }  

    private static void shraniPostaje(Scanner sc) {
        casiPostaj = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
            if(i > 0){
                if(casiPostaj[i] != casiPostaj[i - 1]){
                    enakiCasi = false;
                }
            }
        }
    }

    private static void shraniPrimere(Scanner sc){
        primeri = new int[stPrimerov][2];
        for (int i = 0; i < stPrimerov; i++) {
            for (int j = 0; j < 2; j++) {
                primeri[i][j] = sc.nextInt();
            }
        }
    }

    private static int najmanjsiCasPrimera(int primer) {
        int casTa = primeri[primer][0];
        int casTb = primeri[primer][1] + vsotaPostaj;
        int najmCas = 0;
        for (int i = 0; i < stPostaj; i++) {
            if(i == 0){
                najmCas = Math.abs(casTa - casTb);
            }else{
                casTa += casiPostaj[i - 1];
                casTb -= casiPostaj[i - 1];

                if(Math.abs(casTa - casTb) < najmCas){
                    najmCas = Math.abs(casTa - casTb);
                }
            }
        }
        System.out.println(najmCas + " - " + primer);
        return najmCas;
    }
}


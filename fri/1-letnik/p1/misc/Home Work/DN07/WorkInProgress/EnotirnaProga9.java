import java.util.Scanner;

class EnotirnaProga9 extends Thread{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas, zadnjiTa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stPostaj = sc.nextInt();
        shraniPostaje(sc);
        stPrimerov = sc.nextInt();


        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                Multi t = new Multi(tA, tB, vsotaPostaj, stPostaj, casiPostaj);
                t.start();

            }  
            zadnjiTa = tA;     
        }

        
    }  

    private static void shraniPostaje(Scanner sc) {
        casiPostaj = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
        }
    }


    public void shraniSkupniCas(int cas, int tA){
        skupniCas += cas;
        System.out.println(skupniCas);
        
    }

        /*
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
    */

}

class Multi extends Thread{
    private int tA, tB, vsotaPostaj, stPostaj;
    private int[] casiPostaj;

    Multi(int tA, int tB, int vsotaPostaj, int stPostaj, int[] casiPostaj){
        this.tA = tA;
        this.tB = tB;
        this.vsotaPostaj = vsotaPostaj;
        this.stPostaj = stPostaj;
        this.casiPostaj = casiPostaj;
    }

    public void run(){ 
        EnotirnaProga9 e = new EnotirnaProga9();

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
                    //System.out.println(tA + " - " + tB + " = " + najmCas);
                    e.shraniSkupniCas(najmCas, tA);
                    break;
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
                    //System.out.println(tA + " - " + tB + " = " + najmCas);
                    e.shraniSkupniCas(najmCas, tA);
                    break;
                }
            }
        }
        
    }
}





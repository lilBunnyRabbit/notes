import java.util.Scanner;

class EnotirnaProga{
    public static void main(String[] args) {
        Funkcije f = new Funkcije();
        Scanner sc = new Scanner(System.in);
        
        f.setStPostaj(sc);
        f.shraniPostaje(sc);
        f.setStPrimerov(sc);
        
        f.calcSkupniCas(sc);
        
    }   
}

class Funkcije{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas;

    public void setStPostaj(Scanner sc){
        stPostaj = sc.nextInt();
    }

    public void setStPrimerov(Scanner sc){
        stPrimerov = sc.nextInt();
    }

    public int getStPrimerov(){
        return stPrimerov;
    }

    public int getVsotaPostaj(){
        return vsotaPostaj;
    }

    public void shraniPostaje(Scanner sc) {
        casiPostaj = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
        }
    }

    public void calcSkupniCas(Scanner sc){
        for (int i = 0; i < stPrimerov; i++) {

            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                StartThread t = new StartThread(tA, tB, i);
                t.start();
                
            }

        }
        
                 
        
    }

    public void najmanjsiCasPrimera(int tA, int tB, int j) {
        int casTa = tA;
        int casTb = tB + vsotaPostaj;
        int najmCas = Math.abs(casTa - casTb);

        for (int i = 1; i < stPostaj; i++) {
            casTa += casiPostaj[i - 1];
            casTb -= casiPostaj[i - 1];

            if(Math.abs(casTa - casTb) < najmCas){
                najmCas = Math.abs(casTa - casTb);
            }
        }
        skupniCas += najmCas;
        if(j == stPrimerov - 1){
            System.out.println(skupniCas);
        }
    }


}

class StartThread extends Thread { 
    private Funkcije f;
    private Thread t;
    private int i, tA, tB;
    StartThread(int i, int tA, int tB){
        this.i = i;
        this.tA = tA;
        this.tB = tB;
        this.f = new Funkcije();
    }

    public void run() { 
        f.najmanjsiCasPrimera(tA, tB, i);
    } 
}

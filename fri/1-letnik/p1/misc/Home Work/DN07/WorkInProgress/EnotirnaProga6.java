import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class EnotirnaProga6{
    private static int[] casiPostaj;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas;
    private static List<Primeri> primeri;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stPostaj = sc.nextInt();
        shraniPostaje(sc);
        stPrimerov = sc.nextInt();
        calcSkupniCas(sc);
        najmanjsiCasPrimera();
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
        primeri = new ArrayList<Primeri>();
        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                primeri.add(new Primeri(tA, tB));
            }
                 
        }
    }

    private static void najmanjsiCasPrimera() {
        int casTa = 0;
        int casTb = vsotaPostaj;
        for (Primeri p : primeri) {
            p.setNajmCas(casTa, casTb);
        }

        for (int i = 1; i < stPostaj; i++) {
            casTa += casiPostaj[i - 1];
            casTb -= casiPostaj[i - 1];
            
            /*
            for (Primeri p : primeri) {
                p.compareAndAddNajmCas(casTa, casTb);
                
            }
            */
            for (int j = 0; j < primeri.size(); j++) {
                Primeri primer = primeri.get(j);
                if(primer.compareAndAddNajmCas(casTa, casTb)){
                    skupniCas += primer.getNajmCas();
                    primeri.remove(j);
                }

            }
        }
    
        System.out.println(skupniCas);
    }

}

class Primeri{
    private int tA, tB, najmCas;
    public Primeri(){
    }
    public Primeri(int tA, int tB){
        this.tA = tA;
        this.tB = tB;
    }

    public void setNajmCas(int casTa, int casTb) {
        this.najmCas = Math.abs((casTa + this.tA) - (casTb + this.tB));
    }

    public int getNajmCas() {
        return this.najmCas;
    }

    public boolean compareAndAddNajmCas(int casTa, int casTb){
        int najmCas = Math.abs((casTa + this.tA) - (casTb + this.tB));
        if(najmCas < this.najmCas){
            this.najmCas = najmCas;
            return false;
        }
        return true;
    }
}


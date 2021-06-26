import java.util.Scanner;

import com.sun.prism.ps.Shader;

class EnotirnaProga4{
    private static int[] casiPostaj, casiTa;
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
        casiTa = new int[stPostaj - 1];
        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
            if (i == 0) {
                casiTa[0] = cas;
            }else{
                casiTa[i] = casiTa[i - 1] + cas;
            }
        }
    }

    private static void calcSkupniCas(Scanner sc){
        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            
            if (Math.abs(tA - tB) < vsotaPostaj){
                skupniCas += shraniCase(tA, tB);
            }
                 
        }
    }

    private static int shraniCase(int tA, int tB){
        int casiTb = casiPostaj[casiPostaj.length - 1];
        int najmRazlika = Math.abs(casiTa[casiTa.length - 1] - casiTb);
        int trenutnaRazlika = 0;
        int razlikaTaTb = Math.abs(tA - tB);
        for (int i = 1; i < casiPostaj.length - 1; i++) {
            trenutnaRazlika = Math.abs(casiTb - casiTa[casiTa.length - 1 - i]);

            if(trenutnaRazlika < najmRazlika && trenutnaRazlika >= razlikaTaTb){
                najmRazlika = trenutnaRazlika;
            }
            casiTb += casiPostaj[casiPostaj.length - 1 - i];
        }

        return najmRazlika - razlikaTaTb;
    }

}


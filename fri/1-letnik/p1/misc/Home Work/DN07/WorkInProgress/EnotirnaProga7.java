import java.util.Scanner;

class EnotirnaProga7{
    private static int[] casiPostaj, casiTa, casiRazlika;
    private static int stPostaj, stPrimerov, vsotaPostaj, skupniCas, najmRazlika;
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
        casiTa = new int[casiPostaj.length];
        casiRazlika = new int[casiPostaj.length + 1];

        for (int i = 0; i < casiPostaj.length; i++) {
            int cas = sc.nextInt();
            casiPostaj[i] = cas;
            vsotaPostaj += cas;
            if(i == 0){
                casiTa[0] = cas;
            }else{
                casiTa[i] = casiTa[i - 1] + cas;
            }
        }
        najmRazlika = vsotaPostaj;
        casiRazlika[0] = vsotaPostaj;
        int razlika = 0;
        for (int i = 1; i < casiTa.length + 1; i++) {
            razlika = Math.abs(vsotaPostaj - 2 * casiTa[i - 1]);
            casiRazlika[i] = razlika;
            if(razlika < najmRazlika){
                najmRazlika = razlika;
            }
        }
        
    }

    private static void calcSkupniCas(Scanner sc){
        for (int i = 0; i < stPrimerov; i++) {
            int tA = sc.nextInt();
            int tB = sc.nextInt();

            if (Math.abs(tA - tB) < vsotaPostaj){
                skupniCas += poisciNajmanjsega(tA, tB);
            }
                 
        }
    }

    private static int poisciNajmanjsega(int tA, int tB){
        //System.out.println(tA + " in " + tB);
        int najmCas = vsotaPostaj;

        if(tA > tB){
            for (int i = 0; i < casiRazlika.length; i++) {
                int razlika = Math.abs(casiRazlika[i] - Math.abs(tB - tA));
                //System.out.println(casiRazlika[i] + " + " + tB + " - " + tA + " = " + razlika);
    
                if(Math.abs(razlika) <= najmCas){
                    //System.out.println("Manjsa od najmCas");
                    //System.out.println(tA + " - " + tB + " = " + Math.abs(tA - tB));
                    if(tA - tB <= casiRazlika[i]){
                        //System.out.println(">=0");
                        najmCas = razlika;
                    }
                }else{
                    //System.out.println("Zakljucil: " + najmCas);
                    //System.out.println();
                    return najmCas;
                }
            }
            //System.out.println("Ni v pogoju: " + najmRazlika);
            //System.out.println();
            return najmRazlika;
        }else{
            for (int i = casiRazlika.length - 1; i > 0; i--) {
                int razlika = Math.abs(casiRazlika[i] - Math.abs(tB - tA));
                //System.out.println(casiRazlika[i] + " + " + tB + " - " + tA + " = " + razlika);
    
                if(Math.abs(razlika) <= najmCas){
                    //System.out.println("Manjsa od najmCas");
                    //System.out.println(tA + " - " + tB + " = " + Math.abs(tA - tB));
                    if(tA - tB <= casiRazlika[i]){
                        //System.out.println(">=0");
                        najmCas = razlika;
                    }
                }else{
                    //System.out.println("Zakljucil: " + najmCas);
                    //System.out.println();
                    return najmCas;
                }
            }
            //System.out.println("Ni v pogoju: " + najmRazlika);
            //System.out.println();
            return najmRazlika;
        }


        /*
        if(tA > tB){
            System.out.println(tA + " > " + tB);
            
            int najmCas = vsotaPostaj;
            for (int i = 0; i < casiRazlika.length; i++) {
                int razlika = casiRazlika[i] + tB - tA;
                System.out.println(casiRazlika[i] + " + " + tB + " - " + tA + " = " + razlika);

                if(Math.abs(razlika) < najmCas){
                    System.out.println("Manjsa od najmCas");
                    if(razlika >= 0){
                        System.out.println(">=0");
                        najmCas = razlika;
                    }
                }else{
                    System.out.println("Zakljucil: " + najmCas);
                    System.out.println();
                    return najmCas;
                }
            }
            
            
        }else if (tA < tB){
            System.out.println(tA + " < " + tB);

            int najmCas = vsotaPostaj;
            for (int i = casiRazlika.length - 1; i >= 0; i--) {
                int razlika = casiRazlika[i] + tA - tB;

                System.out.println(casiRazlika[i] + " + " + tA + " - " + tB + " = " + razlika);

                if(Math.abs(razlika) < najmCas){

                    System.out.println("Manjsa od najmCas");

                    if(razlika >= 0){

                        System.out.println(">=0");

                        najmCas = razlika;
                    }
                    
                }else{
                    System.out.println("Zakljucil: " + najmCas);
                    System.out.println();
                    return najmCas;
                }
            }
            
        }
        System.out.println("Ni v pogoju: " + najmRazlika);
        System.out.println();
        return najmRazlika;
        */
        
    }

}


import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DN03_1{
    private static int mL, dM, dT, f, p, mZac, lZac, mKon, lKon;
    private static int zacetna, koncna;
    private static int stevecP, forSize;
    private static List<Integer> zamikList = new ArrayList<Integer>();

	public static void main(String[] args){
        getInputs();
        setDate();
        makeZamikList();
        setMonth();
    }

    public static void getInputs() {
        Scanner sc = new Scanner(System.in);

        mL = sc.nextInt(); // st mescov v letu
        dM = sc.nextInt(); // st dni v mescu
        dT = sc.nextInt(); // st dni v tednu
        f = sc.nextInt(); // f-ti dan je dela prost
        p = sc.nextInt(); // p-ti dan je praznik
        mZac = sc.nextInt(); 
        lZac = sc.nextInt();
        mKon = sc.nextInt();
        lKon = sc.nextInt();

        sc.close();
    }

    public static void setDate() {
        zacetna = mZac + (lZac - 1) * mL;
        koncna = mKon + (lKon - 1) * mL;
        stevecP = (zacetna - 1 ) * dM + 1;
    }

    public static void makeZamikList() {
        int zamik = 0;
        int stZadnjih = 0;
        
        while(true){
            int stVrstic = (int)((zamik + dM) / dT);
            stZadnjih = (zamik + dM) - dT * stVrstic;
            zamik = stZadnjih;
            zamikList.add(zamik);
            if(zamik == zamikList.get(0) && zamikList.size() != 1){
                zamikList.remove(zamikList.size() - 1);       
                break;
            }    
        }
    }

    public static int getZamik(int mesec) {
        if(zamikList.size() == 1 && zamikList.get(0) == 0){
            return  0;
        }else{
            forSize = mesec - zamikList.size() * (int)(mesec / zamikList.size());
            if(mZac == mKon && lZac == lKon){
                return 0;
            }else{
                if(forSize < 2){
                    return zamikList.get(zamikList.size() + forSize - 2);
                }else{
                    return zamikList.get(forSize - 2);
                }
            }
        }
    }

    public static void setMonth() {
        int zamik = 0;
        for (int i = zacetna; i < koncna + 1; i++) {
            zamik = getZamik(i);

            printDate(i);     
            makeMonth(zamik, i);
        }
    }

    public static void printDate(int i) {
        int mesec = (i - mL * (int)(i / mL));
        int leto = (int)(i / mL) + 1;

        if(mesec == 0){
            mesec = mL;
            leto = leto - 1;
        }
        System.out.printf("%d/%d\n", mesec, leto);
    }

    public static void makeMonth(int zamik, int stM) {
        int stevecVrstic = 0;
        /*
        String[] listMeseca = new String[stEl];
        for (int vrs = 0; vrs < stEl; vrs++) {
            for (int i = 0; i < zamik; i++) {
                listMeseca[vrs] = " ";
                vrs++;
            }
            for (int i = 1; i <= dM; i++) {
                listMeseca[vrs] = Integer.toString(i) + "_";
                if(stevecP % p == 0){
                    if(((vrs + 1) - (int)(vrs / dT) * dT) % f == 0){
                        listMeseca[vrs] = "".format("%d%s",i,"*");                    
                    }else{
                        listMeseca[vrs] = "".format("%d%s",i,"+");
                    }
                }else if(((vrs + 1) - (int)(vrs / dT) * dT) % f == 0){
                    listMeseca[vrs] = "".format("%d%s",i,"x");                    
                }
                vrs++;
                stevecP++;
            }
        } 
        */

        for (int i = 0; i < zamik; i++) {
            System.out.print("     ");
            stevecVrstic++;
        }
        for (int j = 1 + zamik; j <= dM + zamik; j++) {

            if(j - zamik < 10){
                if(((stevecVrstic + 1) - (int)(stevecVrstic / dT) * dT) % f == 0){
                    if(stevecP % p == 0){
                        System.out.printf("   %s*", j - zamik);
                    }else{
                        System.out.printf("   %sx", j - zamik);
                    }
                }else{
                    if(stevecP % p == 0){
                        System.out.printf("   %s+", j - zamik);
                    }else{
                        System.out.printf("   %s_", j - zamik);
                    }
                }

            }else{
                if(((stevecVrstic + 1) - (int)(stevecVrstic / dT) * dT) % f == 0){
                    if(stevecP % p == 0){
                        System.out.printf("  %s*", j - zamik);
                    }else{
                        System.out.printf("  %sx", j - zamik);
                    }
                }else{
                    if(stevecP % p == 0){
                        System.out.printf("  %s+", j - zamik);
                    }else{
                        System.out.printf("  %s_", j - zamik);
                    }
                }
            }

            if(j % dT == 0){System.out.println();}

            stevecVrstic++;
            stevecP++;            
        }
        
        if((stevecVrstic + zamik - 1) % dT != 0){System.out.println();}

        //printMonth(listMeseca);   
 
    }

    public static void printMonth(String[] listMeseca) {
        int stevec = 0;
        /*
        for(String el : listMeseca){
            stevec++;
            if(el.length() == 1){
                System.out.printf("    %s", el);
            }else if(el.length() == 2){
                System.out.printf("   %s", el);
            }else if(el.length() == 3){
                System.out.printf("  %s", el);
            }
                       
            if (stevec == dT) {
                System.out.println();
                stevec = 0;
            }
        }

        if (stevec != 0) {
            System.out.println();
        }

        */
    }
}
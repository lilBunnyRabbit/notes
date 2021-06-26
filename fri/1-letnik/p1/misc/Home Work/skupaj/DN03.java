import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DN03{
    private static int mL, dM, dT, f, p, mZac, lZac, mKon, lKon;
    private static int zacetna, koncna, stevecP;
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
        int stVrstic = 0;
        int stZadnjih = 0;

        while(true){
            stVrstic = (int)((zamik + dM) / dT);
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
        int zamikStevec = 0;
        if(zamikList.size() == 1 && zamikList.get(0) == 0){
            return  0;
        }else{
            zamikStevec = mesec - zamikList.size() * (int)(mesec / zamikList.size());
            if(mZac == mKon && lZac == lKon){
                return 0;
            }else{
                if(zamikStevec < 2){
                    return zamikList.get(zamikList.size() + zamikStevec - 2);
                }else{
                    return zamikList.get(zamikStevec - 2);
                }
            }
        }
    }

    public static void setMonth() {
        int zamik = 0;
        for (int m = zacetna; m < koncna + 1; m++) {
            zamik = getZamik(m);

            printDate(m);     
            printMonth(zamik);
        }
    }

    public static void printDate(int m) {
        int mesec = (m - mL * (int)(m / mL));
        int leto = (int)(m / mL) + 1;

        if(mesec == 0){
            mesec = mL;
            leto = leto - 1;
        }
        System.out.printf("%d/%d\n", mesec, leto);
    }

    public static void printMonth(int zamik) {
        int stevecVrstic = 0;
        String space = "";

        for (int z = 0; z < zamik; z++) {
            System.out.print("     ");
            stevecVrstic++;
        }

        boolean newLine = false;
        for (int d = 1 + zamik; d <= dM + zamik; d++) {
            if(d - zamik < 10){space = "   ";}
            else{space = "  ";}

            if(((stevecVrstic + 1) - (int)(stevecVrstic / dT) * dT) % f == 0){
                if(stevecP % p == 0){
                    System.out.printf("%s%s*", space, d - zamik);
                }else{
                    System.out.printf("%s%sx", space, d - zamik);
                }

            }else{
                if(stevecP % p == 0){
                    System.out.printf("%s%s+", space, d - zamik);
                }else{
                    System.out.printf("%s%s_", space, d - zamik);
                }
            }
        
            stevecVrstic++;
            stevecP++;   
            newLine = false;

            if(d % dT == 0){
                System.out.println();
                newLine = true;
            }
        }
        
        if(newLine == false){System.out.println();}
    }

}
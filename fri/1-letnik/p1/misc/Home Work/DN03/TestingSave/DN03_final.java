import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class DN03_final{
    private static int mL, dM, dT, f, p, mZac, lZac, mKon, lKon;
    private static int zacetna, koncna, razlika, zacZamik, zacOstanek, zacMesec, zacLeto;
    private static int stevecP = 1;

	public static void main(String[] args){
        getInputs();
        setDate();
        izpis();
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
        razlika = koncna + 1 - zacetna;
    }

    public static void makeMonth(int zamik, int ostanek, int stEl, int stM) {
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
        
        if(stM + 1 >= zacetna){
            printMonth(listMeseca);
        
        
            if(ostanek != 0 && stM + 1 <= koncna){
                System.out.println();
            }
        }
    }

    public static void printMonth(String[] listMeseca) {
        int stevec = 0;
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
    }

    public static void izpis() {
        int zamik = 0;
        int ostanek = 0;
        for (int i = 0; i < koncna; i++) {
            int stVrstic = (int)((zamik + dM) / dT);
            int stZadnjih = (zamik + dM) - dT * stVrstic;
            ostanek = dT - stZadnjih;

            if(stZadnjih == 0){ostanek = 0;}
            int mesec = (i - mL * (int)(i / mL)) + 1;
            if(mesec == 0){mesec = mL;}
            int leto = (int)(i / mL) + 1;

            if(i + 1 >= zacetna){
                System.out.printf("%d/%d\n", mesec, leto);
            }
            
            makeMonth(zamik, ostanek, zamik + dM, i);

            zamik = stZadnjih;
        }
    }
}
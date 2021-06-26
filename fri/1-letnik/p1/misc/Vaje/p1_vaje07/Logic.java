import javax.swing.*;
import java.util.Arrays;  
import java.util.Scanner;

public class Logic {  
    public static Scanner sc = new Scanner(System.in);
    public static int stSpremenljivk = getSprAmount();
    public static int stVrstic = (int)(Math.pow(2, stSpremenljivk));
    public static int polovicaVrstic = stVrstic / 2;
    public static String[][] spremenljivke = new String[stSpremenljivk][stVrstic];
    public static String[][] reoSpremenljivke = new String[stVrstic][stSpremenljivk];
    public static String[] top = new String[stSpremenljivk + 1];
    public static String[][] finished = new String[stVrstic][stSpremenljivk + 1];

      
    JFrame f;    
    Logic(){    
        f=new JFrame();           
        JTable jt=new JTable(finished,top);    
        jt.setBounds(30,40,200,300);          
        JScrollPane sp=new JScrollPane(jt);    
        f.add(sp);          
        f.setSize(300,400);    
        f.setVisible(true);  
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    } 
    
    public static int getSprAmount() {
        System.out.print("Stevilo Spremenljivk: ");
        int st = sc.nextInt();
        return st;
    }

    public static void makeSpr() {
        for (int spr = 0; spr < stSpremenljivk; spr++) {
            int stevecVrstic = 0;
            while (stevecVrstic != stVrstic) {
                for (int nic = 0; nic < polovicaVrstic; nic++) {
                    spremenljivke[spr][stevecVrstic] = "0";
                    stevecVrstic++;
                }
                for (int ena = 0; ena < polovicaVrstic; ena++) {
                    spremenljivke[spr][stevecVrstic] = "1";
                    stevecVrstic++;
                }
            }
            polovicaVrstic = polovicaVrstic / 2;
        }
        reoList();
    }   
    
    public static void reoList() {
        for (int i = 0; i < stVrstic; i++) {
            for (int j = 0; j < stSpremenljivk; j++) {
                reoSpremenljivke[i][j] = spremenljivke[j][i];
            }
        }
    }

    public static void imenaStolpcev() { 
        for (int spr = 0; spr < stSpremenljivk; spr++) {
            top[spr] = String.format("x%d", spr);
        }

        top[stSpremenljivk] = "F";
    }

    public static void addFunction() {
        for (int i = 0; i < stVrstic; i++) {
            for (int j = 0; j < stSpremenljivk; j++) {
                finished[i][j] = reoSpremenljivke[i][j];
            }
            finished[i][stSpremenljivk] = izracun(i);
        }
    }

    public static String izracun(int vrstica) {
        String x0 = reoSpremenljivke[vrstica][0];
        String x1 = reoSpremenljivke[vrstica][1];

        return kon(dis(neg(x0),x1),dis(x0,neg(x1)));
    }


    public static String kon(String x0, String x1){
        if(x0 == "1" && x1 == "1"){
            return "1";
        }else{
            return "0";
        }
    }

    public static String dis(String x0, String x1){
        if(x0 == "1" || x1 == "1"){
            return "1";
        }else{
            return "0";
        }
    }

    public static String neg(String x0) {
        if(x0 == "1"){
            return "0";
        }else{
            return "1";
        }
    }

    public static void main(String[] args) {    
        makeSpr();
        imenaStolpcev();
        addFunction();
        new Logic();    
    }    


}  
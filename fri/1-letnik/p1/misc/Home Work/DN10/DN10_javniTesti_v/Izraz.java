// 63180202
import java.lang.StringBuilder;

abstract class Izraz {
    private static int stOperatorjev, vsota, dodal;
    private static StringBuilder postFixenZapis;
    public static Izraz zgradi(String niz) {
        postFixenZapis = new StringBuilder();
        int dolzinaNiza = niz.length();
        Izraz skupniIzraz = null;
        Izraz levi = null;
        Izraz desni = null;
        char trenOperator = 'n';
        char glavOperator = 'n';


        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            if(Character.isDigit(element)) {

            }
    }


    public int steviloOperatorjev() { return stOperatorjev; }

    public String postfiksno(){ return postFixenZapis.toString(); }

    public int vrednost() { return vsota; }
}

class Stevilo extends Izraz {
    int stevilo;
    public Stevilo(int stevilo) { this.stevilo = stevilo; }
    public int getStevilo() { return this.stevilo; }
}

class SestavljenIzraz extends Izraz {
    private Izraz levi, desni;
    private char operator;

    public SestavljenIzraz(Izraz levi, char operator, Izraz desni) {
        this.levi = levi;
        this.operator = operator;
        this.desni = desni;
    }

    public Izraz getLevi() { return this.levi; }
    public Izraz getDesni() { return this.desni; }
    public char getOperator() { return this.operator; }
}


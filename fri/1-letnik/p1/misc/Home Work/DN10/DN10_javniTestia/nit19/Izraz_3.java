import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

abstract class Izraz {
    private static int stOperatorjev, sestevek;
    private static StringBuilder postFiksni;

    public static Izraz zgradi(String niz) {
        int dolzinaNiza = niz.length();
        Izraz levi = null;
        Izraz desni = null;
        char operator = 'n';
        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            //System.out.println("Element: " + element);
            char op = poicsciOperatorja(element);

            // Nastavi operator
            if(op != 'n') {
                operator = op;
                //System.out.println("OPERATOR: " + operator);
            }

            // Nastavi Levega
            if(levi == null && operator == 'n') {
                levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                //System.out.println("LEVI: " + Integer.parseInt(niz.substring(i, i + 1)));
            }

            // Ce imamo levega in operator in smo na desnem stevilu in nimamo desnega
            if(operator != 'n' && levi != null && op == 'n') {  
                if(i + 1 != dolzinaNiza) {
                    if(operator == '+' || operator == '-') {
                        // Doda skupaj levi in desni, ki je sestavljeno
                        //System.out.println("STARTA");
                        desni = zgradi(niz.substring(i));
                        //System.out.println("SESTAVLJEN" + levi + " " + operator + " " + desni);
                        return new SestavljenIzraz(levi, operator, desni);
    
                    }else if(operator == '*' || operator == '/') {
                        // zdruzi skupaj levega in desnega v levega
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        //System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                        levi = new SestavljenIzraz(levi, operator, desni);
                        //System.out.println("NOV LEVI");
                    }
                }else {
                    // Fix prou
                    desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                    //System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                    //System.out.println("SESTAVLJEN" + levi + " " + operator + " " + desni);
                    return new SestavljenIzraz(levi, operator, desni);
                }
            }


            //System.out.println();
        }
        return null;
    }



    public static char poicsciOperatorja(char element) {
        char[] operatorji = new char[]{'+','-','*','/'};
        for (char o : operatorji) {
            if(element == o) {
                stOperatorjev++; 
                return o; 
            }
        }
        return 'n';  
    }

    public int steviloOperatorjev() { return stOperatorjev; }

    public String postfiksno(){
        postFiksni = new StringBuilder();
        sestevek = devideAndCalculate(this);
        postFix(this);
        return postFiksni.toString();
    }

    public int vrednost() {
        return sestevek;
    }

    public int devideAndCalculate(Izraz izraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        int lSt = 0;
        int dSt = 0;

        if(levi != null) {
            if(Stevilo.class.isInstance(levi)) {
                lSt = ((Stevilo)levi).getStevilo();
            }else if(SestavljenIzraz.class.isInstance(levi)){
                lSt = devideAndCalculate(levi);
            }
        }

        if(desni != null) {
            if(Stevilo.class.isInstance(desni)) {
                dSt = ((Stevilo)desni).getStevilo();
                char operator = ((SestavljenIzraz)izraz).getOperator();
                return calculate(lSt, dSt, operator);

            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = devideAndCalculate(desni);
                char operator = ((SestavljenIzraz)izraz).getOperator();
                return calculate(lSt, dSt, operator);
            }
        }
        return 0;
    }

    public void postFix(Izraz izraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        int lSt = 0;
        int dSt = 0;
        String post = "";
        if(levi != null) {
            if(Stevilo.class.isInstance(levi)) {
                lSt = ((Stevilo)desni).getStevilo();
            }else if(SestavljenIzraz.class.isInstance(levi)){

            }
        }

        if(desni != null) {
            if(Stevilo.class.isInstance(desni)) {
                dSt = ((Stevilo)desni).getStevilo();
            }else if(SestavljenIzraz.class.isInstance(desni)){

            }
        }

    }

    public int calculate(int levi, int desni, char operator) {
        switch(operator) {
            case '+':
                return levi + desni;    
            case '-':
                return levi - desni; 
            case '*':
                return levi * desni; 
            case '/':
                if(desni != 0) { return levi / desni; } 
                else { return 0; }
        }
        return 0;
    }
}

class Stevilo extends Izraz {
    int stevilo;
    public Stevilo(int stevilo) {
        this.stevilo = stevilo;
    }

    public int getStevilo() {
        return this.stevilo;
    }
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


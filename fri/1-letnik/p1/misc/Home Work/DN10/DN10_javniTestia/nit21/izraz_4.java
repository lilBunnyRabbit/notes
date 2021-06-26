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
            char op = poicsciOperatorja(element);

            if(op != 'n') { operator = op; }

            if(levi == null && operator == 'n') { levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1))); }

            if(dolzinaNiza == 1){ return new SestavljenIzraz(levi, operator, desni); }

            if(operator != 'n' && levi != null && op == 'n') {  
                if(i + 1 != dolzinaNiza) {
                    if(operator == '+' || operator == '-') {
                        desni = zgradi(niz.substring(i));
                        return new SestavljenIzraz(levi, operator, desni);
    
                    }else if(operator == '*' || operator == '/') {
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        levi = new SestavljenIzraz(levi, operator, desni);
                    }

                }else {
                    desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                    return new SestavljenIzraz(levi, operator, desni);
                }
            }
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
        
        return postFix(this);
    }

    public int vrednost() { return sestevek; }

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
                //System.out.println(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);

            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = devideAndCalculate(desni);
                char operator = ((SestavljenIzraz)izraz).getOperator();
                //System.out.println(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);
            }
        }
        return 0;
    }

    public String postFix(Izraz izraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        String lIzraz = "";
        String dIzraz = "";
        char operator = (((SestavljenIzraz)izraz).getOperator());


        if(levi != null) {
            // Ce je levi STEVILO
            if(Stevilo.class.isInstance(levi)) {
                int lSt = ((Stevilo)levi).getStevilo(); 
                lIzraz = Integer.toString(lSt);
            
            // Ce je levi SESTAVLJEN
            }else if(SestavljenIzraz.class.isInstance(levi)){
                //lIzraz = postFix((((SestavljenIzraz)levi).getLevi()));
            }
        }

        if(desni != null) {
            // Ce je desni STEVILO
            if(Stevilo.class.isInstance(desni)) {
                int dSt = ((Stevilo)desni).getStevilo();
                dIzraz = Integer.toString(dSt);

            // Ce je desni SESTAVLJEN
            }else if(SestavljenIzraz.class.isInstance(desni)){
                dIzraz = postFix((((SestavljenIzraz)desni).getLevi()));
                lIzraz = String.format("%s%s%c", lIzraz, dIzraz, operator);
                dIzraz = postFix((((SestavljenIzraz)desni).getDesni()));
            }
        }


        if(operator == 'n'){ 
            return lIzraz; 
        }

        System.out.println(String.format("%s%s%c", lIzraz, dIzraz, operator));
        return String.format("%s%s%c", lIzraz, dIzraz, operator);

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


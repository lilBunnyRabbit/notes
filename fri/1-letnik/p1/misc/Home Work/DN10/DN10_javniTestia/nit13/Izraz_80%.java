import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

abstract class Izraz {
    private static String trenutniNiz;
    private static int stOperatorjev;
    private static List<Character> operatorji = new ArrayList<Character>();

    public static Izraz zgradi(String niz) {
        if(trenutniNiz == null) { trenutniNiz = niz; }

        int dolzinaNiza = niz.length();
        Izraz levi = null;
        Izraz desni = null;
        char operator = 'n';

        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            char op = poicsciOperatorja(element);

            if(op != 'n') { 
                operator = op; 
                if(op == '+' || op == '-') { operatorji.add(op); }
            }

            if(levi == null && operator == 'n') { 
                levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1))); 
            }

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

    public String postfiksno(){ return getPostFix(trenutniNiz); }

    public int vrednost() { return devideAndCalculate(this); }

    public int devideAndCalculate(Izraz izraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        int lSt = 0;
        int dSt = 0;

        if(desni == null) { 
            return ((Stevilo)levi).getStevilo();
        }

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

    public static String getPostFix(String niz) {
        StringBuilder post = new StringBuilder();
        char zunanjiOp = 'n';
        char notranjiOp = 'n';

        for (int i = 0; i < niz.length(); i++) {
            char element = niz.charAt(i);
            if(Character.isDigit(element)) {
                post.append(element);

                if(notranjiOp != 'n') {
                    post.append(notranjiOp);
                    notranjiOp = 'n';
                }

                if(i + 1 == niz.length()) {
                    if(zunanjiOp != 'n') { post.append(zunanjiOp); }
                    return post.toString();
                }

            }else if(element == '+' || element == '-') {
                if(zunanjiOp != 'n') { post.append(zunanjiOp); }
                zunanjiOp = element;

            }else if(element == '*' || element == '/') { notranjiOp = element; }
        }
        return post.toString();
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


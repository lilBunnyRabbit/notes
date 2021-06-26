import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

abstract class Izraz {
    private static int stOperatorjev, vsota;
    private static StringBuilder postFixenZapis;

    public static Izraz zgradi(String niz) {
        postFixenZapis = new StringBuilder();
        int dolzinaNiza = niz.length();
        int trenutnaVsota = 0;
        Izraz skupniIzraz = null;
        Izraz levi = null;
        Izraz desni = null;
        char trenOperator = 'n';
        char glavOperator = 'n';


        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);

            if(Character.isDigit(element)) {
                if(levi == null) {
                    postFixenZapis.append(element);
                    levi = new Stevilo(Integer.parseInt(String.valueOf(element))); 
                    
                    if(i + 1 == niz.length()) {
                        if(skupniIzraz != null) {
                            postFixenZapis.append(glavOperator);
                            return new SestavljenIzraz(skupniIzraz, glavOperator, levi);

                        }else {
                            vsota = Integer.parseInt(String.valueOf(niz));
                            levi = new Stevilo(vsota); 
                            return new SestavljenIzraz(levi, trenOperator, desni);
                        }

                    }else {
                        if(niz.charAt(i + 1) == '+' || niz.charAt(i + 1) == '-') {
                            if(skupniIzraz != null) {
                                postFixenZapis.append(glavOperator);
                                skupniIzraz = new SestavljenIzraz(skupniIzraz, glavOperator, levi);

                            }else { skupniIzraz = levi; }
                            levi = null;
                        }
                    }

                }else { 
                    desni = new Stevilo(Integer.parseInt(String.valueOf(element))); 
                    postFixenZapis.append(element);
                    postFixenZapis.append(trenOperator);

                    if(i + 1 == niz.length()) {
                        if(skupniIzraz != null) {
                            if(glavOperator != 'n') { postFixenZapis.append(glavOperator); }
                            Izraz leviInDesni = new SestavljenIzraz(levi, trenOperator, desni);
                            return new SestavljenIzraz(skupniIzraz, glavOperator, leviInDesni);

                        }else { return new SestavljenIzraz(levi, trenOperator, desni); }
                    }

                    if(niz.charAt(i + 1) == '*' || niz.charAt(i + 1) == '/') { levi = new SestavljenIzraz(levi, trenOperator, desni); }
                    else if(niz.charAt(i + 1) == '+' || niz.charAt(i + 1) == '-') {
                        if(skupniIzraz != null) {
                            postFixenZapis.append(glavOperator);
                            Izraz leviInDesni = new SestavljenIzraz(levi, trenOperator, desni);
                            skupniIzraz = new SestavljenIzraz(skupniIzraz, glavOperator, leviInDesni);
                        
                        }else { skupniIzraz = new SestavljenIzraz(levi, trenOperator, desni); }
                        levi = null;
                    }
                }

            }else {
                if(element == '(') { System.out.println("OKLEPAJ"); }               
                else if(element == ')') { System.out.println("ZAKLEPAJ"); }        
                else {
                    stOperatorjev++;
                    if(element == '+' || element == '-') { glavOperator = element; }
                    else if(element == '*' || element == '/') { trenOperator = element; }
                }
            }
        }
        return null;
    }

    public int steviloOperatorjev() { return stOperatorjev; }

    public String postfiksno(){ return postFixenZapis.toString(); }

    public int vrednost() { return divideAndCalculate(this); }

    public int divideAndCalculate(Izraz izraz) {
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
                lSt = divideAndCalculate(levi);
            }
        }

        if(desni != null) {
            if(Stevilo.class.isInstance(desni)) {
                dSt = ((Stevilo)desni).getStevilo();
                char operator = ((SestavljenIzraz)izraz).getOperator();
                return calculate(lSt, dSt, operator);

            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = divideAndCalculate(desni);
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


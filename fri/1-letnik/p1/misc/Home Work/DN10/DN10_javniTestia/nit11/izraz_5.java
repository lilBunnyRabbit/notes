import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

abstract class Izraz {
    private static int stOperatorjev;
    private static StringBuilder pf = new StringBuilder();
    private static boolean prvic = true;
    private static List<Character> operatorji = new ArrayList<Character>();

    public static Izraz zgradi(String niz) {
        int dolzinaNiza = niz.length();
        Izraz levi = null;
        Izraz desni = null;
        char operator = 'n';

        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            char op = poicsciOperatorja(element);

            if(op != 'n') { 
                operator = op; 
                if(op == '+' || op == '-') {
                    operatorji.add(op);
                }
            }

            if(levi == null && operator == 'n') { 
                levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1))); 
                pf.append(Integer.parseInt(niz.substring(i, i + 1)));
                //System.out.println("LEVI: " + Integer.parseInt(niz.substring(i, i + 1)));
            }

            if(dolzinaNiza == 1){ return new SestavljenIzraz(levi, operator, desni); }

            if(operator != 'n' && levi != null && op == 'n') {  
                if(i + 1 != dolzinaNiza) {
                    if(operator == '+' || operator == '-') {
                        if(prvic) {
                            prvic = false;
                        }else {
                            pf.append(operatorji.get(0));
                            operatorji.remove(0);
                        }

                        desni = zgradi(niz.substring(i));
                        //System.out.println("SESTAVIL1");
                        return new SestavljenIzraz(levi, operator, desni);
    
                    }else if(operator == '*' || operator == '/') {
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        //System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                        pf.append(Integer.parseInt(niz.substring(i, i + 1)));
                        pf.append(operator);
                        //System.out.println("NEW LEVI: " + levi);
                        levi = new SestavljenIzraz(levi, operator, desni);


                    }

                }else {
                    desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                    //System.out.println("DESNI:" + Integer.parseInt(niz.substring(i, i + 1)));
                    pf.append(Integer.parseInt(niz.substring(i, i + 1)));
                    pf.append(operator);
                    if(operatorji.size() != 0 && operatorji.get(0) != operator) {
                        pf.append(operatorji.get(0));
                    }
                    

                    //System.out.println("SESTAVIL");
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
        //return postFix(this, "");
        ////System.out.println("POSTFIX " + postFix(this, ""));

        return pf.toString();
    }

    public int vrednost() { 
        return devideAndCalculate(this); 
    }

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
                ////System.out.println(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);

            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = devideAndCalculate(desni);
                char operator = ((SestavljenIzraz)izraz).getOperator();
                ////System.out.println(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);
            }
        }
        return 0;
    }

    public String postFix(Izraz izraz, String lIzraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        String dIzraz = "";
        char operator = (((SestavljenIzraz)izraz).getOperator());
        int stevilo = 0;
        if(lIzraz == "") {
            if(levi != null) {
                // Ce je levi STEVILO
                if(Stevilo.class.isInstance(levi)) {
                    ////System.out.print("LEVI JE STEVILO: ");
                    stevilo = ((Stevilo)levi).getStevilo(); 
                    lIzraz = Integer.toString(stevilo);

                // Ce je levi SESTAVLJEN
                }else if(SestavljenIzraz.class.isInstance(levi)){
                    ////System.out.print("LEVI JE SESTAVLJEN: ");
                    lIzraz = postFix(((SestavljenIzraz)levi), "");
                }
            }
    
            if(desni != null) {
                // Ce je desni STEVILO
                if(Stevilo.class.isInstance(desni)) {
                    ////System.out.print("DESNI JE STEVILO: ");
                    if(dIzraz == "") {
                        stevilo = ((Stevilo)desni).getStevilo();
                        dIzraz = Integer.toString(stevilo);
                    }
    
                // Ce je desni SESTAVLJEN
                }else if(SestavljenIzraz.class.isInstance(desni)){
                    ////System.out.print("DESNI JE SESTAVLJEN: ");
                    dIzraz = postFix((((SestavljenIzraz)desni).getLevi()), "");
                    lIzraz = String.format("%s%s%c", lIzraz, dIzraz, operator);
                    dIzraz = postFix(((SestavljenIzraz)desni).getDesni(), lIzraz);                         
                }
            }
        }else {
            if(levi != null) {
                // Ce je levi STEVILO
                if(Stevilo.class.isInstance(levi)) {
                // Ce je levi SESTAVLJEN

                }else if(SestavljenIzraz.class.isInstance(levi)){
                }
            }
    
            if(desni != null) {
                // Ce je desni STEVILO
                if(Stevilo.class.isInstance(desni)) {
    
                // Ce je desni SESTAVLJEN
                }else if(SestavljenIzraz.class.isInstance(desni)){

                }
            }
        }


        if(operator == 'n'){ 
            return lIzraz; 
        }

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


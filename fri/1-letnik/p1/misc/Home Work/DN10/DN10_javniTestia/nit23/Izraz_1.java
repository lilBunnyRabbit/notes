import java.util.List;

import com.sun.org.apache.regexp.internal.recompile;

import java.util.ArrayList;

abstract class Izraz {
    private static int stOperatorjev, sestevek, stevec;
    private static List<Izraz> izrazi;

    public static Izraz zgradi(String niz) {
        /*
            new SestavljeniIzraz(
                new SestavljeniIzraz(
                    new SestavljeniIzraz(new Stevilo(3), '+', new Stevilo(4)),'*',new Stevilo(5)),
                    '/',new Stevilo(6))
        */
        return devideInput(niz);
    }

    public static Izraz devideInput(String niz) {
        int dolzinaNiza = niz.length();
        Izraz levi = null;
        Izraz desni = null;
        char operator = 'n';
        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            if(operator == 'n') {
                operator = poicsciOperatorja(element);
                if(operator == 'n') {
                    levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                }
            }else {
                if(i == dolzinaNiza - 1) {
                    desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                    stevec++;
                    return new SestavljenIzraz(levi, operator, desni, stevec);

                } else {
                    desni = devideInput(niz.substring(i));
                    stevec++;
                    return new SestavljenIzraz(levi, operator, desni, stevec);
                }
                
            }

        }
        return new SestavljenIzraz(levi, operator, desni, stevec);
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

        
        int lStevilo = ((Stevilo)((SestavljenIzraz)this).getLevi()).getStevilo();

        try {
            int dStevilo = ((Stevilo)((SestavljenIzraz)this).getDesni()).getStevilo();
            char operator = ((SestavljenIzraz)this).getOperator();  
            return String.format("%d%d%c", lStevilo, dStevilo, operator); 
        } catch (Exception e) {
        }
        
        return String.format("%d", lStevilo);
    }

    public int vrednost() {
        izrazi = new ArrayList<Izraz>();
        sestevek = test(this);

        
        for (Izraz iz : izrazi) {
            if(Stevilo.class.isInstance(iz)) {
                int stevilo = ((Stevilo)iz).getStevilo();
                System.out.print(stevilo + " ");
            }else {
                char operator = ((SestavljenIzraz)iz).getOperator();
                System.out.print(operator + " ");
            }
        }
        System.out.println("=");

        return sestevek;
    }

    public int test(Izraz izraz) {
        Izraz levi = (((SestavljenIzraz)izraz).getLevi());
        Izraz desni = (((SestavljenIzraz)izraz).getDesni());
        int lSt = 0;
        int dSt = 0;
        char operator = 'n';

        if(levi != null) {
            if(Stevilo.class.isInstance(levi)) {
                izrazi.add(levi);
                izrazi.add(izraz);

                lSt = ((Stevilo)levi).getStevilo();
                System.out.println(lSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                operator = ((SestavljenIzraz)izraz).getOperator();

            }else if(SestavljenIzraz.class.isInstance(levi)){
                lSt = test(levi);
                System.out.println(lSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
            }
        }
        if(desni != null) {
            if(Stevilo.class.isInstance(desni)) {
                izrazi.add(desni);
                dSt = ((Stevilo)desni).getStevilo();
                System.out.println();
                System.out.println(dSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                System.out.print(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);
            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = test(desni);
                System.out.println();
                System.out.println(dSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                System.out.print(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);
            }
        }

        return 0;

        //System.out.println(SestavljenIzraz.class.isInstance(desni));
        //System.out.println(Stevilo.class.isInstance(desni));

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
                if(desni != 0) { 
                    return levi / desni; 
                } else {
                    return 0;
                }

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
    private int id;

    public SestavljenIzraz(Izraz levi, char operator, Izraz desni, int id) {
        this.levi = levi;
        this.operator = operator;
        this.desni = desni;
        this.id = id;
    }

    public Izraz getLevi() { return this.levi; }
    public Izraz getDesni() { return this.desni; }
    public char getOperator() { return this.operator; }
    public int getID() { return this.id; }
}
        /*
        int dolzinaNiza = niz.length();
        int stOklepajev = 0;
        Izraz l = null;
        Izraz d = null;
        if(dolzinaNiza > 0) { 
            Izraz trenIzraz = null;
            for (int i = 0; i < dolzinaNiza; i++) {
                char element = niz.charAt(i);
                if(!poicsciOperatorja(element)) {
                    if(element == '('){
                        stOklepajev++;
                        for (int j = i; j < dolzinaNiza; j++) {
                            char element2 = niz.charAt(j);
                            if(element2 == ')') {
                                stOklepajev--;
                                if(stOklepajev == 0) {
                                    trenIzraz =  zgradi(niz.substring(i+1 , j));
                                    break;
                                }
                            }
                        }
                    }else {
                    }

                    if(izraz == null) {
                        izraz = new SestavljenIzraz(l , operator, d);
                    }else {
                        izraz = new SestavljenIzraz(izraz, operator, d);
                    }
                }
            }
        }
        return izraz;
        */


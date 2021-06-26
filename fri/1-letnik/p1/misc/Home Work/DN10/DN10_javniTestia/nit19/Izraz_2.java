import java.util.List;
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
        return devideInput(niz, null);
    }

    public static Izraz devideInput(String niz, Izraz levi) {
        int dolzinaNiza = niz.length();
        Izraz desni = null;
        Izraz trenutniIzraz = null;
        char operator = 'n';
        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            System.out.println("Element: " + element);

            char op = poicsciOperatorja(element);

            if(levi == null && operator == 'n') {
                levi = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                System.out.println("LEVI: " + Integer.parseInt(niz.substring(i, i + 1)));
            }

            if(op != 'n') {
                operator = op;
                System.out.println("OPERATOR: " + operator);
            }
/*
            if(dolzinaNiza == 1) {
                desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                //System.out.println(Integer.parseInt(niz.substring(i, i + 1)) + " Desni");
                System.out.println("SESTAVLJEN " + levi + " " + operator + " " + desni);
                return new SestavljenIzraz(levi, operator, desni, stevec);
            }
*/
            // Ce imamo levega in operator in smo na desnem stevilu

            if(operator != 'n' && levi != null && op == 'n') {
                stevec++;

                if(operator == '+' || operator == '-') { 
                    if(i + 1 != dolzinaNiza) {
                        desni = devideInput(niz.substring(i), null);
                        System.out.println("SESTAVLJEN(" + element + ") " + levi + " " + operator + " " + desni);
                        return new SestavljenIzraz(levi, operator, desni, stevec);
                    }else {
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                        System.out.println("SESTAVLJEN(" + element + ") " + levi + " " + operator + " " + desni);
                        return new SestavljenIzraz(levi, operator, desni, stevec);
                    }                    

                } else if(operator == '*' || operator == '/') {
                    if(i + 1 != dolzinaNiza) {
                        if(trenutniIzraz == null) {
                            desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                            
                            System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                            trenutniIzraz = new SestavljenIzraz(levi, operator, desni, stevec);
                            System.out.println("SESTAVLJEN(T) " + ((Stevilo)levi).getStevilo() + " " + operator + " " + ((Stevilo)desni).getStevilo());
                        }else {                       
                            desni = devideInput(niz.substring(i), null);
                            System.out.println("SESTAVLJEN(" + element + ") " + levi + " " + operator + " " + desni + "~~~");
                           
                            return new SestavljenIzraz(levi, operator, desni, stevec);
                        }
                        

                    
                        
                    } else {
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                        System.out.println("SESTAVLJEN(" + element + ") " + levi + " " + operator + " " + desni);
                        return new SestavljenIzraz(levi, operator, desni, stevec);
                    }
                }
            }
            System.out.println();
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
        char operator = 'z';

        if(levi != null) {
            if(Stevilo.class.isInstance(levi)) {
                izrazi.add(levi);
                izrazi.add(izraz);

                lSt = ((Stevilo)levi).getStevilo();
                //System.out.println(lSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                operator = ((SestavljenIzraz)izraz).getOperator();

            }else if(SestavljenIzraz.class.isInstance(levi)){
                lSt = test(levi);
                //System.out.println(lSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
            }
        }
        if(desni != null) {
            if(Stevilo.class.isInstance(desni)) {
                izrazi.add(desni);
                dSt = ((Stevilo)desni).getStevilo();
                //System.out.println(dSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                //System.out.println(lSt + " " + operator + " " + dSt);
                return calculate(lSt, dSt, operator);
            }else if(SestavljenIzraz.class.isInstance(desni)){
                dSt = test(desni);
                //System.out.println(dSt + ":" + ((SestavljenIzraz)izraz).getID() + " ");
                //System.out.println(lSt + " " + operator + " " + dSt);
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
/*
    public static Izraz devideInput(String niz, Izraz levi) {
        int dolzinaNiza = niz.length();
        Izraz desni = null;
        Izraz trenutniIzraz = null;
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
                        desni = devideInput(niz.substring(i), null);
                        //System.out.println("SESTAVLJEN" + levi + " " + operator + " " + desni);
                        return new SestavljenIzraz(levi, operator, desni, stevec);
    
                    }else if(operator == '*' || operator == '/') {
                        // zdruzi skupaj levega in desnega v levega
                        desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                        //System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                        levi = new SestavljenIzraz(levi, operator, desni, stevec);
                        //System.out.println("NOV LEVI");
                    }
                }else {
                    // Fix prou
                    desni = new Stevilo(Integer.parseInt(niz.substring(i, i + 1)));
                    //System.out.println("DESNI: " + Integer.parseInt(niz.substring(i, i + 1)));
                    //System.out.println("SESTAVLJEN" + levi + " " + operator + " " + desni);
                    return new SestavljenIzraz(levi, operator, desni, stevec);
                }
            }


            //System.out.println();
        }
        return null;
    }
    */


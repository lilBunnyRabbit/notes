import java.lang.StringBuilder;
class Izraz {
    private static int numOfOperators, sum;
    private static StringBuilder pf = new StringBuilder();

    public static Izraz zgradi(String niz) {
        if(niz.length() == 1){
            int firstN = Character.getNumericValue(niz.charAt(0));
            sum = firstN;
            pf.append(firstN);
        }else {
            int fN = 0;
            int sN = 0;
            char op = 'e';
            for (int i = 0; i < niz.length(); i++) {
                char e = niz.charAt(i);
                System.out.println(e);
                if(Character.isDigit(e)) {
                    pf.append(e);
                    if(fN == 0){
                        fN = e;
                        sum = e;
                    }else {
                        sN = e;
                        sum = getValue(sum, op, sN);
                        pf.append(op);
                    }
                }else {
                    op = e;
                    numOfOperators++;

                }
            }
    
        }


        return new Izraz();
    }

    
    public static int getValue(int f, char op, int s) {
        System.out.println(f + " " + op + " " +s);
        switch(op) {
            case '+':
                return f + s;    
            case '-':
                return f - s; 
            case '*':
                return f * s; 
            case '/':
                if(s != 0) { return f / s; } 
                else { return 0; }
        }
        return 0;
    }

    public int steviloOperatorjev() { return numOfOperators; }

    public String postfiksno(){ return pf.toString(); }

    public int vrednost() { return sum; }
}


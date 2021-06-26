class Izraz {
    private static int numOfOperators, sum;
    private static String postFix;

    public static Izraz zgradi(String niz) {
        if(niz.length() != 1) {
            int firstN = Character.getNumericValue(niz.charAt(0));
            char operator = niz.charAt(1);
            int secondN = Character.getNumericValue(niz.charAt(2));
            numOfOperators = 1;
            postFix = String.format("%d%d%c", firstN, secondN, operator);

            switch (operator) {
                case '+':
                    sum = firstN + secondN;
                    break;
                case '-':
                    sum = firstN - secondN;
                    break;
                case '*':
                    sum = firstN * secondN;
                    break;
                case '/':
                    sum = firstN / secondN;
                    break;
            }
        }else {
            int firstN = Character.getNumericValue(niz.charAt(0));
            postFix = String.format("%d", firstN);
            sum = firstN;
        }

        return new Izraz();
    }


    public int steviloOperatorjev() { return numOfOperators; }

    public String postfiksno(){ return postFix; }

    public int vrednost() { return sum; }
}


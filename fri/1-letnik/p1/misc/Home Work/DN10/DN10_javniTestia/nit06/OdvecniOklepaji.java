import java.lang.StringBuilder;

class OdvecniOklepaji {
    private static StringBuilder string;
    public static void main(String[] args) {
        string = new StringBuilder();
        //System.out.println(odstraniOdvecneOklepaje("((((3)+(((2*6)+(7))))))"));
        String niz = "((2-((0-(3+9/(7/(3)/2)*(4-((8-3))*9))*7)-6)*3))*((3-4)-5))";
        System.out.println(niz);
        System.out.println(odstraniOklepaje(niz));
    }
    
    public static String odstraniOdvecneOklepaje(String niz) {
        int dolzinaNiza = niz.length();
        if(niz.charAt(0) == '(' && niz.charAt(dolzinaNiza - 1) == ')' &&
            niz.charAt(1) == '(' && niz.charAt(dolzinaNiza - 2) == ')') {   
            return odstraniOdvecneOklepaje(niz.substring(1, dolzinaNiza - 1));
        }

        System.out.println(niz);
        System.out.println("STRINGBUILDER: " + string.toString());
        for (int i = 0; i < dolzinaNiza; i++){
            char element = niz.charAt(i);
            if(element == '(') {
                if(niz.charAt(i + 2) == ')') {
                    string.append(niz.charAt(i + 1));
                    //System.out.println(string.toString());
                    if(i + 3 >= dolzinaNiza) {
                        return odstraniOdvecneOklepaje(niz.substring(i + 3));
                    }

                }

            }else {
                string.append(element);
                return odstraniOdvecneOklepaje(niz.substring(i + 1));
            }


        }
        int a = ((2-((0-(3+9/(7/(3)/2)*(4-((8-3))*9))*7)-6)*3))*((3-4)-5);
        return "";
    }

    private static String odstraniOklepaje(String izraz){
        String temp=izraz;
        for(int i = 0; i < izraz.length(); i++){
          if(izraz.charAt(i) == '(' && izraz.charAt(izraz.length()-1-i)==')'){
            if(preveriStanjeOklepajev(izraz.substring(i+1, izraz.length()-i-1) )){
              temp = izraz.substring(i+1, izraz.length()-i-1);
            }else{
              break;
            }
          }else{
            break;
          }
        }
        return temp;
      }
    
      private static boolean preveriStanjeOklepajev(String izraz){
        int stevec = 0;
        for(int i = 0; i < izraz.length(); i++){
          if(izraz.charAt(i)=='('){
            stevec++;
          }else if(izraz.charAt(i)==')'){
            stevec--;
          }
          if(stevec<0){
            return false;
          }
        }
        if(stevec==0){
          return true;
        }else{
          return false;
        }
      }

    
}
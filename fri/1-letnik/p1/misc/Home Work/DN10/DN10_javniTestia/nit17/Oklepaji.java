class Oklepaji {
    public static void main(String[] args) {
        String izraz = "((2-((0-(3+9/(7/(3)/2)*(4-((8-3))*9))*7)-6)*3))*((3-4)-5)";
        String izr = "((2-((0-(3+9/(7/(3)/2)*(4-((8-3))*9))*7)-6)*3))";
        int iz = ((2-((0-(3+9/(7/(3)/2)*(4-((8-3))*9))*7)-6)*3))*((3-4)-5);
        okl(izraz);
        //System.out.println(odstraniOklepaje(izraz));
    }

    public static void okl(String izraz) {
        int dolzinaNiza = izraz.length();
        //System.out.println(izraz);
        for (int i = 0; i < dolzinaNiza; i++){
            char element = izraz.charAt(i);

            if(element == '(') {
                int stOk = 1;
                int stZak = 0;
                int zacI = i;

                while (stOk != stZak) {
                    i++;
                    element = izraz.charAt(i);
                    if (element == '(') {
                        stOk++;
                    }else if(element == ')') {
                        stZak++;
                    }
                }
                
                if(izraz.substring(zacI, i + 1) == izraz) {
                    System.out.println(izraz.substring(1, dolzinaNiza - 1));
                    okl(izraz.substring(1, dolzinaNiza - 1));
                }else {
                    System.out.print(izraz.substring(zacI, i + 1));
                    System.out.print(" :: " + izraz.charAt(i + 1) + " :: ");
                    System.out.println(izraz.substring(i + 2));
                    okl(izraz.substring(zacI, i + 1));
                    okl(izraz.substring(i + 2));
                    //okl(izraz.substring(zacI, i + 1));
                }

                
  
                System.out.println("-----");
                break;
            }
        }
    }
}
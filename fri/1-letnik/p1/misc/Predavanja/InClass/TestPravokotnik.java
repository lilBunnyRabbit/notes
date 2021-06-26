class TestPravokotnik{

    public static void main(String[] args){

        //kreiramo dva pravokotnika in izpisemo njuno vsebino
        Pravokotnik p1 = new Pravokotnik();
        Pravokotnik p2 = new Pravokotnik(5, 3, 4, -1);

        p1.izpisi();
        p2.izpisi();
        System.out.println();

        //prvemu spremenimo velikost in lego
        p1.nastaviVelikost(7, 3);
        p1.nastaviLego(2, 3);
        p1.izpisi();
        System.out.println();

        //drugi pravokotnik premaknemo
        p2.premakni(-1, 4);
        p2.izpisi();


    }
}
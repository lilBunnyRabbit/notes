class TestPravokotnik1{

    public static void main(String[] args){
        System.out.println(Pravokotnik1.vrniStPravokotnikov());

        //kreiramo vec pravokotnikov
        Pravokotnik1 p1 = new Pravokotnik1();
        p1.izpisi();
        System.out.println(Pravokotnik1.vrniStPravokotnikov());

        Pravokotnik1 p2 = new Pravokotnik1(1, 5, 0, 0);
        p2.izpisi();
        System.out.println(Pravokotnik1.vrniStPravokotnikov());

        Pravokotnik1 p3 = new Pravokotnik1(4, 2, 3, -1);
        p3.izpisi();
        System.out.println(Pravokotnik1.vrniStPravokotnikov());
    
    }


}

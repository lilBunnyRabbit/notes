class TestDelavec1{
    public static void main(String[] args){
        // kreiramo 3 obj, vsakega s svojim konsr
        Delavec1 d1 = new Delavec1(1000,"Novak","Janez");
        Delavec1 d2 = new Delavec1(1001,"Petel","Peter",180);
        Delavec1 d3 = new Delavec1(1002);

        // izpisemo vsebino vseh objektov

        d1.izpisiVse();
        d2.izpisiVse();
        d3.izpisiVse();

        // vpisemo mankajoce podatke 

        d1.setStUr(176);
        d2.setPriimek("Koren");
        d3.setIme("Martina");
        d3.setStUr(200);
        
        //izracunamo zasluzek prvega in tretjega delavca
        System.out.println(d1.zasluzek(10));
        System.out.println(d2.zasluzek(8.5));

    }
}
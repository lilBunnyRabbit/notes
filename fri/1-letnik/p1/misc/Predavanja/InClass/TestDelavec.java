class TestDelavec{
    public static void main(String[] args){

        // kreiranje objekta
        Delavec d = new Delavec();

        // izpisi trenutne vsebine
        d.izpisiVse();
        System.out.println();

        // vpis vrednosti atributov
        d.setMatSt(1000);
        d.setPriimek("Novak");
        d.setIme("Janez");
        d.setStUr(176);

        // izpis vsebine
        d.izpisiVse();
        System.out.println();

        // izpis vsebine z metodo toString
        System.out.println(d.toString());
        System.out.println();

        // izpis vsebine s pomocjo metod getter
        System.out.println("Maticna stevilka: " + d.getMatSt());
        System.out.println("Priimek in ime: " + d.getPriimek() + " " + d.getIme());
        System.out.println("Stevilo ur: " + d.getStUr());

        // izpis zasluzka
        System.out.println("Zasluzek: " + d.zasluzek(10));
    }
}
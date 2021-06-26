class Pravokotnik1{

    //dekleracija atributov
    private double a,b;
    private double x,y;

    //stevec pravokotnikov
    private static int stPravokotnikov = 0;

    //dekleracije konstruktorjev
    public Pravokotnik1(){
        a = 1;
        b = 1;
        x = 0;
        y = 1;
        stPravokotnikov++;
    }

    public Pravokotnik1 (double a, double b, double x, double y){
        this.a = a;
        this.b = b;
        this.x = x;
        this.y = y;
        stPravokotnikov++;
    }
    

    //dekleracija metod
    public static int vrniStPravokotnikov(){
        return stPravokotnikov;
    }

    public void nastaviVelikost(double a, double b){
        this.a = a;
        this.b = b;
    }

    public void nastaviLego(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double obseg(){
        return 2*(a+b);
    }

    public double ploscina(){
        return a*b;
    }

    public void premakni(double dx, double dy){
        x += dx;
        y += dy;
    }

    public void izpisi(){
        System.out.printf("a = %.2f b=%.2f x=%.2f y=%.2f o=%.2f pl=%.2f %n", a, b, x, y, obseg(), ploscina());
    }
}
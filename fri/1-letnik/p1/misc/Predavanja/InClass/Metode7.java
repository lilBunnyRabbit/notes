Class Metode7{
    public static long faktoriela(int n){
        if(n==1){
            return 1;
        }
        else{
            return n * faktoriela(n-1);
        }
    }

    public static long faktorielaIte(int n){
        long produkt = 1;
        for(int i = 2; i <= n; i++){
            produkt = produkt * i;
        }
        return produkt;
    }

    public static void main(Sting[] args){
        for(int n = 1; n <= 10; n++){
            System.out.printf("%2d %15d %n", n, faktoriela(n), faktorielaIte(n));
        }
    }

}
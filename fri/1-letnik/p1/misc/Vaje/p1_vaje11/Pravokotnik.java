
public class Pravokotnik extends Lik{
    private int a, b;
    public Pravokotnik(int a, int b){
        this.a = a;
        this.b = b;
    }

    public String toString(){
        return String.format("pravokotnik [a = %d, b = %d] | p = %d, o = %d", a, b, ploscina, obseg);
    }
}

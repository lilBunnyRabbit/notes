
public class Kvadrat extends Lik{
    private int stranica;
    public Kvadrat(int stranica){
        this.stranica = stranica;
        this.ploscina = stranica * stranica;
        this.obseg = 4 * stranica;
    }

    public String toString(){
        return String.format("kvadrat [a = %d] | p = %d, o = %d", stranica, ploscina, obseg);
    }
}


public class Krog extends Lik{
    private int polmer, ploscina, obseg;
    public Krog(int polmer){
        this.polmer = polmer;
        this.ploscina =  Math.PI * polmer * polmer;
        this.obseg = 2 * Math.PI * polmer; 
    }

    public String toString(){
        return String.format("krog [r = %d] | p = %d, o = %d", polmer, ploscina, obseg);
    }
}

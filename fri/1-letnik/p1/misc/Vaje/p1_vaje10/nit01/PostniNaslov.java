
public class PostniNaslov {

    private String ulicaHS;  // ulica s hišno številko
    private int postnaStevilka;
    private String posta;

    public PostniNaslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    public String toString() {
        // popravite / dopolnite ...
        return String.format("%s, %d %s", this.ulicaHS, this.postnaStevilka, this.posta);
    }

    public boolean jeEnakKot(PostniNaslov pn) {
        // popravite / dopolnite ...  
        if(this.ulicaHS == pn.ulicaHS && this.postnaStevilka == pn.postnaStevilka && this.posta == pn.posta){
            return true;
            
        }else{
            return false;
        }
    }
}

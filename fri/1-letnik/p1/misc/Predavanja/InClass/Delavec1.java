class Delavec1{

    // dekleracija atributov
    private int matSt;
    private String priimek;
    private String ime;
    private int stUr;

    // dekleracije konstruktorjev
    public Delavec1(int matSt, String priimek, String ime){
        this.matSt = matSt;
        this.priimek = priimek;
        this.ime = ime;
        
    }

    public Delavec1(int matSt, String priimek, String ime, int stUr){
        this.matSt = matSt;
        this.priimek = priimek;
        this.ime = ime;
        this.stUr = stUr;
        
    }

    // metode setter
    public void setMatSt(int ms){
        matSt = ms;
    }

    // this. da se nanasamo na prvi dekleriran String priimek
    public void setPriimek(String priimek){
        this.priimek = priimek;
    }

    public void setIme(String ime){
        this.ime = ime;
    }

    public void setStUr(int stUr){
        this.stUr = stUr;
    }

    // metode getter (nimajo parametrov)
    public int getMatSt(){
        return matSt;
    }

    public String getPriimek(){
        return priimek;
    }

    public String getIme(){
        return ime;
    }

    public int getStUr(){
        return stUr;
    }

    // metode utility

    public double zasluzek(double cenaUre){
        return stUr * cenaUre;
    }

    public void izpisiVse(){
        System.out.println("Maticna stevilka: " + matSt);
        System.out.println("Priimek in ime: " + priimek + " " + ime);
        System.out.println("Stevilo ur: " + stUr);
    }

    public String toString(){
        return matSt + " " + priimek + " " + ime + " " + stUr;
    }

}
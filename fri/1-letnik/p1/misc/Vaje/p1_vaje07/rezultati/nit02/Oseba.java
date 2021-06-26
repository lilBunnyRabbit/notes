class Oseba{
    //atributi

    private String ime, priimek;
    private char spol;
    private int letoRojstva;
    private Oseba oce, mati;
    private static int stOseb = 0;

    public Oseba(String ime, String priimek, char spol, int letoRojstva){
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        stOseb++;
    }

    public Oseba(String ime, String priimek, char spol, int letoRojstva, Oseba oce, Oseba mati){
        this.ime = ime;
        this.priimek = priimek;
        this.spol = spol;
        this.letoRojstva = letoRojstva;
        this.oce = oce;
        this.mati = mati;
        stOseb++;
    }


    public String vrniIme() {
        return this.ime;
    }   
    
    public void nastaviIme(String novoIme) {
        this.ime = novoIme;
    }

    public String toString() {
        return ime + " " + priimek + " (" + spol + "), " + letoRojstva;
    }

    public int starost(int leto) {
        return leto - letoRojstva;
    }

    public boolean jeStarejsaOd(Oseba os) {
        if (letoRojstva < os.letoRojstva) {
            return true;
        }else{
            return false;
        }
    }
    
    public String imeOceta() {
        if(oce.ime != null){
            return oce.ime;
        }else{
            return "";
        }
        
    }

    public boolean jeBratAliSestraOd(Oseba os) {
        if(mati == os.mati && oce == os.oce){
            return true;
        }else{
            return false;
        }
    }

    public boolean jeSestraOd(Oseba os) {
        if(spol == 'Z'){
            if(mati == os.mati && oce == os.oce){
                return true;
            }else{
                return false;
            } 
        }else{
            return false;
        }
    }

    public boolean jeTetaOd(Oseba os) {
        if(spol == 'Z'){
            if(jeBratAliSestraOd(os.oce) == true || jeBratAliSestraOd(os.mati) == true){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean jeOcetovskiPrednikOd(Oseba os) {
        return true;
    }

    public static int steviloUstvarjenih() {
        return stOseb;
    }

    //konstruktorja

    //metode
}
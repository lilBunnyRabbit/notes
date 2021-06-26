class Datum {
    private int dan, mesec, leto;
    public Datum(int dan, int mesec, int leto) {
        this.dan = dan;
        this.mesec = mesec;
        this.leto = leto;
    }

    public int vrniDan() {
        return dan;
    }

    public int vrniMesec() {
        return mesec;
    } 

    public int vrniLeto() {
        return leto;
    }

    public String toString() {
        String dd;
        String mm;
        if(dan < 10){
            dd = "0" + Integer.toString(dan);
        }else{
            dd = Integer.toString(dan);
        }
        
        if(mesec < 10){
            mm = "0" + Integer.toString(mesec);
        }else{
            mm = Integer.toString(mesec);
        }

        String llll = Integer.toString(leto);

        return dd + "." + mm + "." + llll;
    }

    public boolean jeEnakKot(Datum datum) {
        if(this.leto == datum.leto && this.mesec == datum.mesec && this.dan == datum.dan){
            return true;
        }else{
            return false;
        }
        
    }

    
}
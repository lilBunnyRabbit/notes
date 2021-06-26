class Bankomat {
    private int k5, k2, k1, nDvig, nDanDvig, nDanDvig2; 
    private Datum nDatum, nDatum2;
    public Bankomat(){
        k5 = 0;
        k2 = 0;
        k1 = 0;
        nDvig = 0;
        nDatum = null;
        nDanDvig = 0;
        nDatum2 = null;
        nDanDvig2 = 0;
    }

    public int vrniN5() {
        return this.k5;    
    }

    public int vrniN2() {
        return this.k2;
    }

    public int vrniN1() {
        return this.k1;
    }

    public void nalozi(int k5, int k2, int k1) {
        this.k5 += k5;
        this.k2 += k2;
        this.k1 += k1;
    }

    public void izpisi() {
        System.out.printf("%d | %d | %d%n", k5, k2, k1);
    }

    public int kolicinaDenarja() {
        return k5 * 5 + k2 * 2 + k1;
    }

    public boolean dvigni(int dvig, Datum datum) {
        int stK5 = k5;
        int stK2 = k2;
        int stK1 = k1;
        int stDvig = dvig;

        if(dvig <= (k5 * 5 + k2 * 2 + k1) && dvig != 0){
            while (stK5 != 0 && stDvig != 0 && stDvig >= 5) {
                stK5--;
                stDvig -= 5;
                if (stDvig < 5 && stDvig % 2 != 0 && stK1 == 0) {
                    stK5++;
                    stDvig += 5;
                    break;
                }
            }
            while (stK2 != 0 && stDvig != 0 && stDvig >= 2) {
                stK2--;
                stDvig -= 2;
            }
            while (stDvig != 0 && stK1 != 0) {
                stK1--;
                stDvig--;
            }
            if (stDvig == 0) {
                this.k5 = stK5;
                this.k2 = stK2;
                this.k1 = stK1;
                
                if(nDatum2 == null){
                    nDanDvig2 = 0;
                    nDatum2 = datum; 
                }else{    
                    if(datum.jeEnakKot(nDatum2) == false){
                        if(nDanDvig >= nDanDvig2){
                            nDanDvig2 = 0;
                            nDatum2 = datum;
                        }else if(nDanDvig < nDanDvig2){
                            nDanDvig = nDanDvig2;
                            nDatum = nDatum2;
                            nDanDvig2 = 0;
                            nDatum2 = datum;
                        }
                    }
                }
    
                if(dvig > nDvig){
                    this.nDvig = dvig;
                }

                if(datum.jeEnakKot(nDatum2)){
                    nDanDvig2 += dvig; 
                }

                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public int najDvig() {
        return nDvig;
    }

    public Datum najDatum() {
        if (nDanDvig >= nDanDvig2) {
            return nDatum;
        }else{
            return nDatum2;
        }
        
    }
}
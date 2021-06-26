
public class Obrok {

    private Jed[] jedi;   // jedi, ki sestavljajo obrok

    public Obrok(Jed[] jedi) {
        this.jedi = jedi;
    }

    public Jed[] vrniJedi() {
        return this.jedi;
    }

    /**
     * Vrne indeks najbolj kalori"cne beljakovinske jedi v tabeli jedi obroka
     * this.  "Ce je takih jedi ve"c, vrne indeks prve med njimi, "ce pa obrok
     * this ne vsebuje beljakovinskih jedi, vrne -1.
     */
    public int indeksNajboljKaloricneBeljakovinske() {
        // Dopolnite!
        return -2;   // Spremenite!
    }

    /**
     * Vrne skupno maso sestavine (ne jedi!) s podanim nazivom v obroku this.
     */
    public double masaSestavine(String nazivSestavine) {
        // Dopolnite!
        return -1.0;   // Spremenite!
    }

    /**
     * Stabilno uredi tabelo this.jedi glede na podani primerjalnik.
     *
     * Ne spreminjajte!
     */
    public void urediJedi(Primerjalnik primerjalnik) {
        for (int i = 1;  i < this.jedi.length;  i++) {
            Jed trenutni = this.jedi[i];
            int j = i;
            while (j > 0 && primerjalnik.jePred(trenutni, this.jedi[j - 1])) {
                this.jedi[j] = this.jedi[j - 1];
                j--;
            }
            this.jedi[j] = trenutni;
        }
    }

}

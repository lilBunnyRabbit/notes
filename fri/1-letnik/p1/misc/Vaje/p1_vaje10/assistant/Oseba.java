
public class Oseba {

	private String ip;   // ime in priimek
	private int starost;
	private PostniNaslov postniNaslov;
	
	// prijatelji osebe this
	private Oseba[] prijatelji;
	
	// dejansko število prijateljev osebe this (v splošnem ni enako this.prijatelji.length)
	private int stPrijateljev;
	
	private static final int MAKS_ST_PRIJATELJEV = 100;

    /**
     * Ustvari nov objekt razreda Oseba.
     */
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        this.ip = ip;
		this.starost = starost;
		this.postniNaslov = postniNaslov;
		this.prijatelji = new Oseba[MAKS_ST_PRIJATELJEV];
		this.stPrijateljev = 0;
    }

    /**
     * Vrne ime in priimek osebe `this'.
     */
    public String vrniIP() {
        return this.ip;
    }

    /**
     * Vrne niz z osnovnimi podatki o osebi `this'.
     */
    public String toString() {
		return String.format("%s (%d), %s",
		                     this.ip, this.starost, this.postniNaslov.toString());
    }

    /**
     * Vrne število prijateljev osebe `this'.
     */
    public int steviloPrijateljev() {
		return this.stPrijateljev;
    }

    /**
     * Vrne `true' natanko v primeru, če je oseba `this' prijatelj osebe `os'.
     */
    public boolean jePrijateljOd(Oseba os) {
		for (int i = 0;  i < os.stPrijateljev;  i++) {
			if (os.prijatelji[i] == this) {
				return true;
			}
		}
		return false;
    }

    /**
     * Če sta osebi `prva' in `druga' različni in če še nista prijatelja, to
     * postaneta, sicer pa se ne zgodi nič.
     */
    public static boolean vzpostaviPrijateljstvo(Oseba prva, Oseba druga) {
		if (prva == druga || prva.jePrijateljOd(druga) || druga.jePrijateljOd(prva)) {
			return false;
		}
		prva.dodajPrijatelja(druga);
		druga.dodajPrijatelja(prva);
		return true;
    }
	
	/** Doda osebo os v tabelo prijateljev osebe this.
	*/	
	private void dodajPrijatelja(Oseba os) {
		this.prijatelji[this.stPrijateljev] = os;
		this.stPrijateljev++;
	}

    /**
     * Vrne `true' natanko v primeru, če oseba `os' prebiva na istem poštnem
     * naslovu kot oseba `this'.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        return this.postniNaslov.jeEnakKot(os.postniNaslov);
    }

    /**
     * Vrne število prijateljev osebe `this', ki živijo na istem poštnem
     * naslovu kot oseba `this'.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        int stevec = 0;
		for (int i = 0;  i < this.stPrijateljev;  i++) {
			if (this.prijatelji[i].naIstemNaslovuKot(this)) {
				stevec++;
			}
		}
		return stevec;
    }

    /**
     * Vrne najstarejšega prijatelja osebe `this' (prvega, če jih je več;
     * null, če jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
		if (this.stPrijateljev == 0) {
			return null;
		}
		int iNaj = 0;    // indeks doslej najstarejšega prijatelja osebe this
		for (int i = 1;  i < this.stPrijateljev;  i++) {
			if (this.prijatelji[i].starost > this.prijatelji[iNaj].starost) {
				iNaj = i;
			}
		}
		return this.prijatelji[iNaj];
    }
}

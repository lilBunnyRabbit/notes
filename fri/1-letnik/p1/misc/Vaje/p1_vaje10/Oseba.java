
public class Oseba {

    // dopolnite ...
    private String ip;
    private int starost, stPrijateljev;
    private PostniNaslov postniNaslov;
    private Oseba[] seznamPrijateljev;

    /**
     * Ustvari nov objekt razreda Oseba.
     */
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        // dopolnite ...
        this.ip = ip;
        this.starost = starost;
        this.postniNaslov = postniNaslov;
        this.seznamPrijateljev = new Oseba[100];
    }

    /**
     * Vrne ime in priimek osebe `this'.
     */
    public String vrniIP() {
        // popravite / dopolnite ...
        return this.ip;
    }

    /**
     * Vrne niz z osnovnimi podatki o osebi `this'.
     */
    public String toString() {
        // popravite / dopolnite ...
        return ip + " (" + starost + "), " + postniNaslov;
    }

    /**
     * Vrne število prijateljev osebe `this'.
     */
    public int steviloPrijateljev() {
        // popravite / dopolnite ...
        int stPrijateljev = 0;
        for (int i = 0; i < 100; i++) {
            if (seznamPrijateljev[i] != 0) {
                stPrijateljev++;
            }else{
                break;
            }
        }             
        return stPrijateljev;
    }

    /**
     * Vrne `true' natanko v primeru, če je oseba `this' prijatelj osebe `os'.
     */
    public boolean jePrijateljOd(Oseba os) {
        // popravite / dopolnite ...
        for (int i = 0; i < 100; i++) {
            if (seznamPrijateljev[i] == os) {
                return true;
            }else if(seznamPrijateljev[i] == 0){
                return false;
                break;
            }
        } 
    }

    /**
     * Če sta osebi `prva' in `druga' različni in če še nista prijatelja, to
     * postaneta, sicer pa se ne zgodi nič.
     */
    public static boolean vzpostaviPrijateljstvo(Oseba prva, Oseba druga) {
        // popravite / dopolnite ...
        if (prva != druga && prva.jePrijateljOd(druga) == false) {
            prva.seznamPrijateljev[prva.stPrijateljev] = druga;
            druga.seznamPrijateljev[druga.stPrijateljev] = prva;
        }else{
            return false;
        }
        return false;
    }

    /**
     * Vrne `true' natanko v primeru, če oseba `os' prebiva na istem poštnem
     * naslovu kot oseba `this'.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        // popravite / dopolnite ...
        return false;
    }

    /**
     * Vrne število prijateljev osebe `this', ki živijo na istem poštnem
     * naslovu kot oseba `this'.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        // popravite / dopolnite ...
        return -1;
    }

    /**
     * Vrne najstarejšega prijatelja osebe `this' (prvega, če jih je več;
     * null, če jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        // popravite / dopolnite ...
        return null;
    }
}

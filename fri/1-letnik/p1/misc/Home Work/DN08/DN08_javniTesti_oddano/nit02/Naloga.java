// 63180202
// V prej"snji vrstici navedite svojo vpisno "stevilko.
import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
public class Naloga {

    public static class Predmet {
        private int sifra;
        private String naziv;
        private int kt;
        private int tip;
        private Modul modul;
        private Izvajalec[] izvajalci;

        public Predmet(int sifra, String naziv, int kt, int tip, Modul modul, Izvajalec[] izvajalci) {
            this.sifra = sifra;
            this.naziv = naziv;
            this.kt = kt;
            this.tip = tip;
            this.modul = modul;
            this.izvajalci = izvajalci;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Modul {
        private int sifra;
        private String naziv;

        public Modul(int sifra, String naziv) {
            this.sifra = sifra;
            this.naziv = naziv;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }
    }

    public static class Izvajalec {
        private int sifra;
        private String ip;

        public Izvajalec(int sifra, String ip) {
            this.sifra = sifra;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.ip);
        }
    }

    public static class Predmetnik {
        private Predmet[] predmeti;

        public Predmetnik(Predmet[] predmeti) {
            this.predmeti = predmeti;
        }

        public int steviloKT() {
            int stKt = 0;
            for (Predmet p : predmeti) {
                stKt += p.kt;
            }
            return stKt;
        }

        public int[] tipiPredmetov() {
            int[] tipi = new int[3];
            for (Predmet p : predmeti) { tipi[p.tip]++; }
            return tipi;
        }

        public Predmet predmetZNajvecIzvajalci() {
            int stIzv = 0;
            Predmet najP = null;
            for (Predmet p : predmeti) {               
                if(stIzv < p.izvajalci.length) {
                    stIzv = p.izvajalci.length;
                    najP = p;
                }else if(stIzv == p.izvajalci.length && najP.sifra > p.sifra){
                    stIzv = p.izvajalci.length;
                    najP = p;
                } 
            }
            return najP;
        }

        public int predmetiModula(int sifra, String[] nazivi) {
            int stPredmetov = 0;
            for (Predmet p : predmeti) { 
                if(p.modul != null && p.modul.sifra == sifra){
                    nazivi[stPredmetov] = p.naziv;
                    stPredmetov++;
                } 
            }
            return stPredmetov;
        }

        public int steviloIzvajalcev() {
            Set<Integer> izvajalci = new HashSet<Integer>();
            for (Predmet p : predmeti) {
                for (Izvajalec i : p.izvajalci) {
                    izvajalci.add(i.sifra);
                }
            }
            return izvajalci.size();
        }

        public int steviloEnakoMocnihModulov(Predmetnik drugi) {
            int skupaj = 0;
            int[] moduli1 = new int[predmeti.length];
            int[] moduli2 = new int[drugi.predmeti.length];

            Hashtable<Integer, Integer> m1 = new Hashtable<Integer, Integer>();
            Hashtable<Integer, Integer> m2 = new Hashtable<Integer, Integer>();

            for (int i = 0; i < predmeti.length; i++) {
                if(predmeti[i].tip == 2){
                    moduli1[i] = predmeti[i].modul.sifra;
                }
            }

            for (int i = 0; i < drugi.predmeti.length; i++) {
                if(drugi.predmeti[i].tip == 2){
                    moduli2[i] = drugi.predmeti[i].modul.sifra;
                }
            }

            for (int i = 0; i < predmeti.length; ++i) {
                int mod = moduli1[i];
          
                if (m1.containsKey(mod))
                    m1.put(mod, m1.get(mod) + 1);
                else
                    m1.put(mod, 1);
            }

            for (int i = 0; i < drugi.predmeti.length; ++i) {
                int mod = moduli2[i];
          
                if (m2.containsKey(mod))
                    m2.put(mod, m2.get(mod) + 1);
                else
                    m2.put(mod, 1);
            }

            for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if(m2.get(key) != null && m2.get(key) == value && key != 0){
                    skupaj++;
                }
            }
            return skupaj;
        }
    }
}

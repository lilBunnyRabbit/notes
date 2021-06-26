
public class Test13 {

    public static void main(String[] args) {
        Snov moka = new Snov("moka");
        Snov jajca = new Snov("jajca");
        Snov sol = new Snov("sol");
        Snov mleko = new Snov("mleko");
        Snov testo = new Snov("testo");
        Snov olje = new Snov("olje");
        Snov palacinke = new Snov("palacinke");

        Korak[] koraki = {
            new Korak(new Snov[]{moka, jajca, sol, mleko}, new Snov[]{testo}, "zmesaj", 20),
            new Korak(new Snov[]{testo, olje}, new Snov[]{palacinke}, "ocvri", 10)
        };

        Recept recept = new Recept(koraki);

        System.out.println(recept.prviKorakZAkcijo("prelij"));  // -1
    }
}

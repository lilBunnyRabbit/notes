
public class Test10 {

    public static void main(String[] args) {
        Sestavina cebula = new Sestavina("cebula", 40.0, 10, 1, 0);
        Sestavina krompir = new Sestavina("krompir", 77.0, 17, 2, 0);
        Sestavina korenje = new Sestavina("korenje", 41.0, 10, 1, 0);
        Sestavina grah = new Sestavina("grah", 81.0, 14, 5, 0);
        Sestavina govedina = new Sestavina("govedina", 114.0, 0, 19, 4);
        Sestavina zelenaSolata = new Sestavina("zelena solata", 17.0, 4, 1, 0);
        Sestavina paradiznik = new Sestavina("paradiznik", 18.0, 4, 1, 0);
        Sestavina olje = new Sestavina("olje", 884.0, 0, 0, 100);
        Sestavina kis = new Sestavina("kis", 21.0, 1, 0, 0);
        Sestavina moka = new Sestavina("moka", 364.0, 76, 10, 1);
        Sestavina sol = new Sestavina("sol", 0.0, 0, 0, 0);
        Sestavina jajce = new Sestavina("jajce", 143.0, 1, 13, 10);
        Sestavina mleko = new Sestavina("mleko", 60.0, 5, 3, 3);

        Jed govejaJuha = new Jed(
            "goveja juha",
            new Sestavina[]{govedina, korenje, cebula, sol},
            new double[]{500.0, 100.0, 200.0, 2.0},
            "juha"
        );

        Jed oblozenaGovedina = new Jed(
            "oblozena govedina",
            new Sestavina[]{govedina, korenje, grah},
            new double[]{500.0, 200.0, 200.0},
            "glavna jed"
        );

        Jed prazenKrompir = new Jed(
            "prazen krompir",
            new Sestavina[]{krompir, cebula, sol, olje},
            new double[]{750.0, 200.0, 2.0, 20.0},
            "glavna jed"
        );

        Jed solata = new Jed(
            "solata",
            new Sestavina[]{zelenaSolata, paradiznik, kis, sol, olje},
            new double[]{300.0, 300.0, 10.0, 2.0, 10.0},
            "solata"
        );

        Jed palacinke = new Jed(
            "palacinke",
            new Sestavina[]{moka, sol, jajce, mleko, olje},
            new double[]{200.0, 1.0, 100.0, 300.0, 10.0},
            "sladica"
        );

        Obrok obrok = new Obrok(
            new Jed[]{oblozenaGovedina, palacinke, govejaJuha}
        );

        obrok.urediJedi(new PrimerjalnikBK());
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

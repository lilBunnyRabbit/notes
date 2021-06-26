
public class Test09 {

    public static void main(String[] args) {
        PostniNaslov naslov = new PostniNaslov("Gasilska 15", 2342, "Ruše");
        String[] imena = {
            "Karel", "Lea", "Mojca", "Nataša", "Olga", "Peter", 
            "Rok", "Sandi", "Špela", "Tanja", "Uroš", "Vasja"
        };
        int[] starosti = {46, 42, 38, 41, 52, 46,
                          22, 25, 24, 22, 27, 25};

        Oseba[] osebe = new Oseba[imena.length];
        for (int i = 0;  i < imena.length;  i++) {
            osebe[i] = new Oseba(imena[i], starosti[i], naslov);
        }

        osebe[0].nastaviPrijatelje(new Oseba[]{osebe[1], osebe[4], osebe[5]});
        osebe[1].nastaviPrijatelje(new Oseba[]{osebe[0], osebe[2]});
        osebe[2].nastaviPrijatelje(new Oseba[]{osebe[1], osebe[3]});
        osebe[3].nastaviPrijatelje(new Oseba[]{osebe[2], osebe[5]});
        osebe[4].nastaviPrijatelje(new Oseba[]{osebe[0], osebe[5]});
        osebe[5].nastaviPrijatelje(new Oseba[]{osebe[0], osebe[3], osebe[4]});

        osebe[6].nastaviPrijatelje(new Oseba[]{osebe[8]});
        osebe[7].nastaviPrijatelje(new Oseba[]{osebe[8]});
        osebe[8].nastaviPrijatelje(new Oseba[]{osebe[6], osebe[7], osebe[9], osebe[10], osebe[11]});
        osebe[9].nastaviPrijatelje(new Oseba[]{osebe[8], osebe[11]});
        osebe[10].nastaviPrijatelje(new Oseba[]{osebe[8], osebe[11]});
        osebe[11].nastaviPrijatelje(new Oseba[]{osebe[8], osebe[9], osebe[10]});

        boolean[][] povezanost = Oseba.povezanost(osebe);

        System.out.println("Povezanost:");
        for (int i = 0;  i < povezanost.length;  i++) {
            for (int j = 0;  j < povezanost[i].length;  j++) {
                if (j > 0) {
                    System.out.print(" ");
                }
                System.out.print(povezanost[i][j] ? "1" : "0");
            }
            System.out.println();
        }
    }
}


public class Test10 {

    public static void main(String[] args) {
        PostniNaslov naslov = new PostniNaslov("Ulica", 0, "Mesto");
        String[] imena = {"A", "B", "C", "D", "E"};
        int[] starosti = {20, 20, 20, 20, 20};

        Oseba[] osebe = new Oseba[imena.length];
        for (int i = 0;  i < imena.length;  i++) {
            osebe[i] = new Oseba(imena[i], starosti[i], naslov);
        }

        osebe[0].nastaviPrijatelje(new Oseba[]{osebe[4]});
        osebe[1].nastaviPrijatelje(new Oseba[]{});
        osebe[2].nastaviPrijatelje(new Oseba[]{});
        osebe[3].nastaviPrijatelje(new Oseba[]{});
        osebe[4].nastaviPrijatelje(new Oseba[]{});

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


public class Test03 {

    public static void main(String[] args) {
        PostniNaslov naslov = new PostniNaslov("Ulica", 0, "Mesto");
        String[] imena = {"A", "B", "C", "D", "E"};
        int[] starosti = {20, 20, 20, 20, 20};

        Oseba[] osebe = new Oseba[imena.length];
        for (int i = 0;  i < imena.length;  i++) {
            osebe[i] = new Oseba(imena[i], starosti[i], naslov);
        }

        osebe[0].nastaviPrijatelje(new Oseba[]{osebe[1]});
        osebe[1].nastaviPrijatelje(new Oseba[]{osebe[0], osebe[2]});
        osebe[2].nastaviPrijatelje(new Oseba[]{osebe[1], osebe[3]});
        osebe[3].nastaviPrijatelje(new Oseba[]{osebe[2], osebe[4]});
        osebe[4].nastaviPrijatelje(new Oseba[]{osebe[3]});

        System.out.println("Število prijateljev prijateljev:");
        for (int i = 0;  i < osebe.length;  i++) {
            System.out.printf("%s --> %d%n",
                    osebe[i].toString(),
                    osebe[i].steviloPrijateljevPrijateljev());
        }
    }
}

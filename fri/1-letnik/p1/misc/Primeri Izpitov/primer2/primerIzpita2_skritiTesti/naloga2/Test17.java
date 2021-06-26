public class Test17 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[5];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[3]}, "akcija1", 82);
        koraki[1] = new Korak(new Snov[]{snovi[5]}, new Snov[]{snovi[7]}, "akcija1", 86);
        koraki[2] = new Korak(new Snov[]{snovi[20]}, new Snov[]{snovi[10]}, "akcija1", 70);
        koraki[3] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[16]}, "akcija1", 91);
        koraki[4] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[47]}, "akcija1", 11);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

public class Test23 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[11]}, "akcija7", 26);
        koraki[1] = new Korak(new Snov[]{snovi[5]}, new Snov[]{snovi[12]}, "akcija9", 29);
        koraki[2] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[20]}, "akcija5", 66);
        koraki[3] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[21]}, "akcija3", 27);
        koraki[4] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[24]}, "akcija2", 54);
        koraki[5] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[30]}, "akcija10", 97);
        koraki[6] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[32]}, "akcija4", 47);
        koraki[7] = new Korak(new Snov[]{snovi[41]}, new Snov[]{snovi[33]}, "akcija9", 95);
        koraki[8] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[40]}, "akcija5", 52);
        koraki[9] = new Korak(new Snov[]{snovi[46]}, new Snov[]{snovi[49]}, "akcija1", 72);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

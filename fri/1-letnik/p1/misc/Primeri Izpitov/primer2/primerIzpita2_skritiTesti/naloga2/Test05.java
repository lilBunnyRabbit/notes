public class Test05 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[7];
        koraki[0] = new Korak(new Snov[]{snovi[6]}, new Snov[]{snovi[32]}, "akcija4", 47);
        koraki[1] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[34]}, "akcija1", 85);
        koraki[2] = new Korak(new Snov[]{snovi[19]}, new Snov[]{snovi[36]}, "akcija2", 82);
        koraki[3] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[38]}, "akcija7", 67);
        koraki[4] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[46]}, "akcija10", 32);
        koraki[5] = new Korak(new Snov[]{snovi[40]}, new Snov[]{snovi[48]}, "akcija8", 86);
        koraki[6] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[49]}, "akcija3", 26);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

public class Test07 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[14];
        koraki[0] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[1]}, "akcija7", 14);
        koraki[1] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[6]}, "akcija8", 56);
        koraki[2] = new Korak(new Snov[]{snovi[20]}, new Snov[]{snovi[9]}, "akcija7", 28);
        koraki[3] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[10]}, "akcija2", 62);
        koraki[4] = new Korak(new Snov[]{snovi[25]}, new Snov[]{snovi[11]}, "akcija5", 96);
        koraki[5] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[14]}, "akcija5", 90);
        koraki[6] = new Korak(new Snov[]{snovi[30]}, new Snov[]{snovi[23]}, "akcija5", 57);
        koraki[7] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[24]}, "akcija9", 3);
        koraki[8] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[28]}, "akcija3", 22);
        koraki[9] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[36]}, "akcija5", 3);
        koraki[10] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[38]}, "akcija7", 26);
        koraki[11] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[40]}, "akcija4", 75);
        koraki[12] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[42]}, "akcija9", 70);
        koraki[13] = new Korak(new Snov[]{snovi[49]}, new Snov[]{snovi[45]}, "akcija9", 92);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

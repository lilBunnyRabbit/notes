public class Test11 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[12];
        koraki[0] = new Korak(new Snov[]{snovi[1]}, new Snov[]{snovi[3]}, "akcija1", 62);
        koraki[1] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[18]}, "akcija8", 72);
        koraki[2] = new Korak(new Snov[]{snovi[5]}, new Snov[]{snovi[19]}, "akcija2", 49);
        koraki[3] = new Korak(new Snov[]{snovi[7]}, new Snov[]{snovi[21]}, "akcija6", 79);
        koraki[4] = new Korak(new Snov[]{snovi[14]}, new Snov[]{snovi[26]}, "akcija6", 58);
        koraki[5] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[28]}, "akcija5", 92);
        koraki[6] = new Korak(new Snov[]{snovi[22]}, new Snov[]{snovi[32]}, "akcija3", 80);
        koraki[7] = new Korak(new Snov[]{snovi[27]}, new Snov[]{snovi[33]}, "akcija10", 68);
        koraki[8] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[34]}, "akcija2", 90);
        koraki[9] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[43]}, "akcija3", 29);
        koraki[10] = new Korak(new Snov[]{snovi[41]}, new Snov[]{snovi[44]}, "akcija9", 76);
        koraki[11] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[48]}, "akcija9", 47);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

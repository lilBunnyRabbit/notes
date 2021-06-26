public class Test08 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[17];
        koraki[0] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[1]}, "akcija8", 12);
        koraki[1] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[6]}, "akcija8", 24);
        koraki[2] = new Korak(new Snov[]{snovi[8]}, new Snov[]{snovi[7]}, "akcija6", 62);
        koraki[3] = new Korak(new Snov[]{snovi[11]}, new Snov[]{snovi[10]}, "akcija5", 44);
        koraki[4] = new Korak(new Snov[]{snovi[18]}, new Snov[]{snovi[13]}, "akcija1", 61);
        koraki[5] = new Korak(new Snov[]{snovi[20]}, new Snov[]{snovi[15]}, "akcija9", 85);
        koraki[6] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[16]}, "akcija2", 71);
        koraki[7] = new Korak(new Snov[]{snovi[22]}, new Snov[]{snovi[17]}, "akcija6", 58);
        koraki[8] = new Korak(new Snov[]{snovi[25]}, new Snov[]{snovi[19]}, "akcija8", 67);
        koraki[9] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[28]}, "akcija7", 75);
        koraki[10] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[31]}, "akcija1", 95);
        koraki[11] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[36]}, "akcija3", 49);
        koraki[12] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[38]}, "akcija2", 38);
        koraki[13] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[44]}, "akcija9", 79);
        koraki[14] = new Korak(new Snov[]{snovi[42]}, new Snov[]{snovi[46]}, "akcija2", 6);
        koraki[15] = new Korak(new Snov[]{snovi[45]}, new Snov[]{snovi[48]}, "akcija9", 98);
        koraki[16] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[49]}, "akcija1", 82);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

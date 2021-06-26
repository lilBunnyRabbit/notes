public class Test06 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[16];
        koraki[0] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[1]}, "akcija6", 81);
        koraki[1] = new Korak(new Snov[]{snovi[9]}, new Snov[]{snovi[4]}, "akcija6", 67);
        koraki[2] = new Korak(new Snov[]{snovi[10]}, new Snov[]{snovi[7]}, "akcija10", 17);
        koraki[3] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[8]}, "akcija1", 15);
        koraki[4] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[21]}, "akcija9", 98);
        koraki[5] = new Korak(new Snov[]{snovi[18]}, new Snov[]{snovi[22]}, "akcija10", 56);
        koraki[6] = new Korak(new Snov[]{snovi[19]}, new Snov[]{snovi[24]}, "akcija10", 59);
        koraki[7] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[25]}, "akcija4", 9);
        koraki[8] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[27]}, "akcija6", 41);
        koraki[9] = new Korak(new Snov[]{snovi[31]}, new Snov[]{snovi[28]}, "akcija5", 27);
        koraki[10] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[29]}, "akcija1", 89);
        koraki[11] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[33]}, "akcija8", 39);
        koraki[12] = new Korak(new Snov[]{snovi[40]}, new Snov[]{snovi[35]}, "akcija8", 64);
        koraki[13] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[39]}, "akcija5", 19);
        koraki[14] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[41]}, "akcija3", 91);
        koraki[15] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[42]}, "akcija1", 60);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

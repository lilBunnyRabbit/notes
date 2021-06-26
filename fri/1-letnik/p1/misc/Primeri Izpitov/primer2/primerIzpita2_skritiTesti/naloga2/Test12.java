public class Test12 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[17];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[1]}, "akcija8", 67);
        koraki[1] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[5]}, "akcija3", 60);
        koraki[2] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[9]}, "akcija6", 15);
        koraki[3] = new Korak(new Snov[]{snovi[6]}, new Snov[]{snovi[12]}, "akcija8", 53);
        koraki[4] = new Korak(new Snov[]{snovi[10]}, new Snov[]{snovi[14]}, "akcija1", 67);
        koraki[5] = new Korak(new Snov[]{snovi[11]}, new Snov[]{snovi[18]}, "akcija1", 62);
        koraki[6] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[19]}, "akcija4", 10);
        koraki[7] = new Korak(new Snov[]{snovi[17]}, new Snov[]{snovi[21]}, "akcija8", 90);
        koraki[8] = new Korak(new Snov[]{snovi[27]}, new Snov[]{snovi[23]}, "akcija4", 4);
        koraki[9] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[24]}, "akcija2", 52);
        koraki[10] = new Korak(new Snov[]{snovi[30]}, new Snov[]{snovi[25]}, "akcija3", 60);
        koraki[11] = new Korak(new Snov[]{snovi[31]}, new Snov[]{snovi[26]}, "akcija1", 70);
        koraki[12] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[33]}, "akcija5", 18);
        koraki[13] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[44]}, "akcija3", 91);
        koraki[14] = new Korak(new Snov[]{snovi[41]}, new Snov[]{snovi[45]}, "akcija10", 59);
        koraki[15] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[46]}, "akcija5", 26);
        koraki[16] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[47]}, "akcija3", 12);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

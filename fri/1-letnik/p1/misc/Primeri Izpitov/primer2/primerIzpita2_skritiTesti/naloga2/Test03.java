public class Test03 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[17];
        koraki[0] = new Korak(new Snov[]{snovi[1]}, new Snov[]{snovi[0]}, "akcija1", 57);
        koraki[1] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[2]}, "akcija3", 40);
        koraki[2] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[4]}, "akcija10", 47);
        koraki[3] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[5]}, "akcija4", 41);
        koraki[4] = new Korak(new Snov[]{snovi[17]}, new Snov[]{snovi[6]}, "akcija2", 37);
        koraki[5] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[8]}, "akcija6", 33);
        koraki[6] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[10]}, "akcija4", 5);
        koraki[7] = new Korak(new Snov[]{snovi[25]}, new Snov[]{snovi[11]}, "akcija8", 59);
        koraki[8] = new Korak(new Snov[]{snovi[27]}, new Snov[]{snovi[12]}, "akcija6", 12);
        koraki[9] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[13]}, "akcija2", 87);
        koraki[10] = new Korak(new Snov[]{snovi[30]}, new Snov[]{snovi[14]}, "akcija1", 51);
        koraki[11] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[19]}, "akcija5", 13);
        koraki[12] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[22]}, "akcija3", 88);
        koraki[13] = new Korak(new Snov[]{snovi[42]}, new Snov[]{snovi[23]}, "akcija10", 76);
        koraki[14] = new Korak(new Snov[]{snovi[45]}, new Snov[]{snovi[31]}, "akcija6", 21);
        koraki[15] = new Korak(new Snov[]{snovi[46]}, new Snov[]{snovi[34]}, "akcija3", 34);
        koraki[16] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[38]}, "akcija2", 4);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

public class Test45 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[2], snovi[3]}, new Snov[]{snovi[0], snovi[1]}, "akcija1", 16);
        koraki[1] = new Korak(new Snov[]{snovi[4], snovi[7]}, new Snov[]{snovi[5], snovi[6]}, "akcija1", 81);
        koraki[2] = new Korak(new Snov[]{snovi[8], snovi[10]}, new Snov[]{snovi[9], snovi[11]}, "akcija1", 67);
        koraki[3] = new Korak(new Snov[]{snovi[12], snovi[18]}, new Snov[]{snovi[13], snovi[17]}, "akcija1", 52);
        koraki[4] = new Korak(new Snov[]{snovi[19], snovi[20]}, new Snov[]{snovi[22], snovi[24]}, "akcija1", 90);
        koraki[5] = new Korak(new Snov[]{snovi[25], snovi[26]}, new Snov[]{snovi[28], snovi[29]}, "akcija1", 31);
        koraki[6] = new Korak(new Snov[]{snovi[30], snovi[31]}, new Snov[]{snovi[35], snovi[37]}, "akcija1", 4);
        koraki[7] = new Korak(new Snov[]{snovi[32], snovi[33]}, new Snov[]{snovi[38], snovi[39]}, "akcija1", 11);
        koraki[8] = new Korak(new Snov[]{snovi[36], snovi[45]}, new Snov[]{snovi[40], snovi[44]}, "akcija1", 81);
        koraki[9] = new Korak(new Snov[]{snovi[46], snovi[49]}, new Snov[]{snovi[47], snovi[48]}, "akcija1", 83);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

public class Test42 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[0], snovi[1]}, "akcija1", 26);
        koraki[1] = new Korak(new Snov[]{snovi[5]}, new Snov[]{snovi[3], snovi[6]}, "akcija1", 1);
        koraki[2] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[7], snovi[9]}, "akcija1", 22);
        koraki[3] = new Korak(new Snov[]{snovi[17]}, new Snov[]{snovi[12], snovi[18]}, "akcija1", 31);
        koraki[4] = new Korak(new Snov[]{snovi[19]}, new Snov[]{snovi[20], snovi[21]}, "akcija1", 60);
        koraki[5] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[22], snovi[25]}, "akcija1", 40);
        koraki[6] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[27], snovi[29]}, "akcija1", 27);
        koraki[7] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[31], snovi[32]}, "akcija1", 37);
        koraki[8] = new Korak(new Snov[]{snovi[44]}, new Snov[]{snovi[38], snovi[39]}, "akcija1", 73);
        koraki[9] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[47], snovi[49]}, "akcija1", 88);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

public class Test48 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0], snovi[1]}, new Snov[]{snovi[0], snovi[2]}, "akcija1", 7);
        koraki[1] = new Korak(new Snov[]{snovi[11], snovi[12]}, new Snov[]{snovi[4], snovi[5]}, "akcija1", 61);
        koraki[2] = new Korak(new Snov[]{snovi[13], snovi[14]}, new Snov[]{snovi[8], snovi[13]}, "akcija1", 56);
        koraki[3] = new Korak(new Snov[]{snovi[15], snovi[17]}, new Snov[]{snovi[15], snovi[19]}, "akcija1", 71);
        koraki[4] = new Korak(new Snov[]{snovi[19], snovi[21]}, new Snov[]{snovi[24], snovi[27]}, "akcija1", 25);
        koraki[5] = new Korak(new Snov[]{snovi[22], snovi[24]}, new Snov[]{snovi[31], snovi[32]}, "akcija1", 37);
        koraki[6] = new Korak(new Snov[]{snovi[27], snovi[29]}, new Snov[]{snovi[33], snovi[34]}, "akcija1", 17);
        koraki[7] = new Korak(new Snov[]{snovi[35], snovi[36]}, new Snov[]{snovi[35], snovi[37]}, "akcija1", 81);
        koraki[8] = new Korak(new Snov[]{snovi[40], snovi[41]}, new Snov[]{snovi[38], snovi[39]}, "akcija1", 25);
        koraki[9] = new Korak(new Snov[]{snovi[44], snovi[46]}, new Snov[]{snovi[43], snovi[49]}, "akcija1", 30);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

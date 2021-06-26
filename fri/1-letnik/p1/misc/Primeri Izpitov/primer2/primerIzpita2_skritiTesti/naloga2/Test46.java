public class Test46 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0], snovi[3]}, new Snov[]{snovi[1], snovi[2]}, "akcija1", 43);
        koraki[1] = new Korak(new Snov[]{snovi[4], snovi[6]}, new Snov[]{snovi[6], snovi[8]}, "akcija1", 100);
        koraki[2] = new Korak(new Snov[]{snovi[7], snovi[10]}, new Snov[]{snovi[12], snovi[19]}, "akcija1", 78);
        koraki[3] = new Korak(new Snov[]{snovi[11], snovi[12]}, new Snov[]{snovi[21], snovi[22]}, "akcija1", 35);
        koraki[4] = new Korak(new Snov[]{snovi[15], snovi[16]}, new Snov[]{snovi[24], snovi[25]}, "akcija1", 30);
        koraki[5] = new Korak(new Snov[]{snovi[18], snovi[19]}, new Snov[]{snovi[27], snovi[32]}, "akcija1", 68);
        koraki[6] = new Korak(new Snov[]{snovi[25], snovi[33]}, new Snov[]{snovi[34], snovi[36]}, "akcija1", 58);
        koraki[7] = new Korak(new Snov[]{snovi[35], snovi[39]}, new Snov[]{snovi[37], snovi[38]}, "akcija1", 65);
        koraki[8] = new Korak(new Snov[]{snovi[41], snovi[42]}, new Snov[]{snovi[39], snovi[43]}, "akcija1", 48);
        koraki[9] = new Korak(new Snov[]{snovi[46], snovi[47]}, new Snov[]{snovi[45], snovi[49]}, "akcija1", 8);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

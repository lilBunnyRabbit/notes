public class Test44 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[2], snovi[4]}, new Snov[]{snovi[1], snovi[5]}, "akcija1", 3);
        koraki[1] = new Korak(new Snov[]{snovi[7], snovi[8]}, new Snov[]{snovi[6], snovi[10]}, "akcija1", 24);
        koraki[2] = new Korak(new Snov[]{snovi[9], snovi[12]}, new Snov[]{snovi[17], snovi[18]}, "akcija1", 10);
        koraki[3] = new Korak(new Snov[]{snovi[13], snovi[14]}, new Snov[]{snovi[19], snovi[20]}, "akcija1", 17);
        koraki[4] = new Korak(new Snov[]{snovi[15], snovi[16]}, new Snov[]{snovi[23], snovi[27]}, "akcija1", 44);
        koraki[5] = new Korak(new Snov[]{snovi[24], snovi[26]}, new Snov[]{snovi[28], snovi[29]}, "akcija1", 97);
        koraki[6] = new Korak(new Snov[]{snovi[30], snovi[37]}, new Snov[]{snovi[32], snovi[33]}, "akcija1", 70);
        koraki[7] = new Korak(new Snov[]{snovi[41], snovi[42]}, new Snov[]{snovi[34], snovi[35]}, "akcija1", 34);
        koraki[8] = new Korak(new Snov[]{snovi[43], snovi[47]}, new Snov[]{snovi[36], snovi[38]}, "akcija1", 64);
        koraki[9] = new Korak(new Snov[]{snovi[48], snovi[49]}, new Snov[]{snovi[39], snovi[40]}, "akcija1", 8);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

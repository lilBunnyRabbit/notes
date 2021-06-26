public class Test47 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[2], snovi[5]}, new Snov[]{snovi[2], snovi[4]}, "akcija1", 24);
        koraki[1] = new Korak(new Snov[]{snovi[11], snovi[12]}, new Snov[]{snovi[7], snovi[10]}, "akcija1", 66);
        koraki[2] = new Korak(new Snov[]{snovi[13], snovi[15]}, new Snov[]{snovi[12], snovi[13]}, "akcija1", 33);
        koraki[3] = new Korak(new Snov[]{snovi[16], snovi[18]}, new Snov[]{snovi[14], snovi[15]}, "akcija1", 52);
        koraki[4] = new Korak(new Snov[]{snovi[21], snovi[22]}, new Snov[]{snovi[16], snovi[18]}, "akcija1", 59);
        koraki[5] = new Korak(new Snov[]{snovi[23], snovi[24]}, new Snov[]{snovi[23], snovi[26]}, "akcija1", 32);
        koraki[6] = new Korak(new Snov[]{snovi[26], snovi[27]}, new Snov[]{snovi[30], snovi[33]}, "akcija1", 6);
        koraki[7] = new Korak(new Snov[]{snovi[31], snovi[35]}, new Snov[]{snovi[34], snovi[40]}, "akcija1", 91);
        koraki[8] = new Korak(new Snov[]{snovi[37], snovi[38]}, new Snov[]{snovi[44], snovi[46]}, "akcija1", 44);
        koraki[9] = new Korak(new Snov[]{snovi[41], snovi[49]}, new Snov[]{snovi[47], snovi[49]}, "akcija1", 31);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

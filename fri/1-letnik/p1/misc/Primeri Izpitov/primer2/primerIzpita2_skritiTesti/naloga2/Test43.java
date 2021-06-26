public class Test43 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0], snovi[1]}, new Snov[]{snovi[3]}, "akcija1", 23);
        koraki[1] = new Korak(new Snov[]{snovi[5], snovi[15]}, new Snov[]{snovi[8]}, "akcija1", 7);
        koraki[2] = new Korak(new Snov[]{snovi[17], snovi[19]}, new Snov[]{snovi[9]}, "akcija1", 50);
        koraki[3] = new Korak(new Snov[]{snovi[23], snovi[26]}, new Snov[]{snovi[10]}, "akcija1", 9);
        koraki[4] = new Korak(new Snov[]{snovi[27], snovi[28]}, new Snov[]{snovi[18]}, "akcija1", 38);
        koraki[5] = new Korak(new Snov[]{snovi[31], snovi[35]}, new Snov[]{snovi[25]}, "akcija1", 3);
        koraki[6] = new Korak(new Snov[]{snovi[37], snovi[38]}, new Snov[]{snovi[29]}, "akcija1", 33);
        koraki[7] = new Korak(new Snov[]{snovi[41], snovi[42]}, new Snov[]{snovi[30]}, "akcija1", 59);
        koraki[8] = new Korak(new Snov[]{snovi[43], snovi[44]}, new Snov[]{snovi[39]}, "akcija1", 82);
        koraki[9] = new Korak(new Snov[]{snovi[45], snovi[49]}, new Snov[]{snovi[48]}, "akcija1", 3);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

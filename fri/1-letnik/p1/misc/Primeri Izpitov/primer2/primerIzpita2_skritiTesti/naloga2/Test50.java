public class Test50 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[1], snovi[2]}, new Snov[]{snovi[0], snovi[2]}, "akcija1", 5);
        koraki[1] = new Korak(new Snov[]{snovi[3], snovi[5]}, new Snov[]{snovi[3], snovi[4]}, "akcija1", 96);
        koraki[2] = new Korak(new Snov[]{snovi[14], snovi[16]}, new Snov[]{snovi[5], snovi[6]}, "akcija1", 9);
        koraki[3] = new Korak(new Snov[]{snovi[17], snovi[18]}, new Snov[]{snovi[11], snovi[12]}, "akcija1", 88);
        koraki[4] = new Korak(new Snov[]{snovi[20], snovi[21]}, new Snov[]{snovi[16], snovi[17]}, "akcija1", 78);
        koraki[5] = new Korak(new Snov[]{snovi[26], snovi[32]}, new Snov[]{snovi[18], snovi[23]}, "akcija1", 31);
        koraki[6] = new Korak(new Snov[]{snovi[33], snovi[34]}, new Snov[]{snovi[24], snovi[29]}, "akcija1", 45);
        koraki[7] = new Korak(new Snov[]{snovi[35], snovi[36]}, new Snov[]{snovi[31], snovi[32]}, "akcija1", 18);
        koraki[8] = new Korak(new Snov[]{snovi[39], snovi[40]}, new Snov[]{snovi[34], snovi[36]}, "akcija1", 72);
        koraki[9] = new Korak(new Snov[]{snovi[46], snovi[49]}, new Snov[]{snovi[41], snovi[47]}, "akcija1", 35);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

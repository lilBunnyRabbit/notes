public class Test49 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0], snovi[2]}, new Snov[]{snovi[0], snovi[2]}, "akcija1", 43);
        koraki[1] = new Korak(new Snov[]{snovi[4], snovi[7]}, new Snov[]{snovi[9], snovi[11]}, "akcija1", 100);
        koraki[2] = new Korak(new Snov[]{snovi[9], snovi[10]}, new Snov[]{snovi[12], snovi[14]}, "akcija1", 23);
        koraki[3] = new Korak(new Snov[]{snovi[13], snovi[21]}, new Snov[]{snovi[15], snovi[17]}, "akcija1", 67);
        koraki[4] = new Korak(new Snov[]{snovi[23], snovi[24]}, new Snov[]{snovi[18], snovi[20]}, "akcija1", 78);
        koraki[5] = new Korak(new Snov[]{snovi[28], snovi[29]}, new Snov[]{snovi[23], snovi[31]}, "akcija1", 19);
        koraki[6] = new Korak(new Snov[]{snovi[32], snovi[34]}, new Snov[]{snovi[32], snovi[33]}, "akcija1", 84);
        koraki[7] = new Korak(new Snov[]{snovi[38], snovi[40]}, new Snov[]{snovi[37], snovi[40]}, "akcija1", 68);
        koraki[8] = new Korak(new Snov[]{snovi[41], snovi[43]}, new Snov[]{snovi[41], snovi[43]}, "akcija1", 52);
        koraki[9] = new Korak(new Snov[]{snovi[45], snovi[46]}, new Snov[]{snovi[45], snovi[49]}, "akcija1", 85);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

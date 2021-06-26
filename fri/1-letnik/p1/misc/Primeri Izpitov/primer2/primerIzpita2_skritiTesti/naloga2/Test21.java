public class Test21 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[2]}, "akcija2", 89);
        koraki[1] = new Korak(new Snov[]{snovi[14]}, new Snov[]{snovi[6]}, "akcija5", 62);
        koraki[2] = new Korak(new Snov[]{snovi[18]}, new Snov[]{snovi[11]}, "akcija1", 76);
        koraki[3] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[12]}, "akcija5", 36);
        koraki[4] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[19]}, "akcija4", 93);
        koraki[5] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[22]}, "akcija2", 49);
        koraki[6] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[34]}, "akcija3", 3);
        koraki[7] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[37]}, "akcija1", 86);
        koraki[8] = new Korak(new Snov[]{snovi[45]}, new Snov[]{snovi[42]}, "akcija5", 87);
        koraki[9] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[49]}, "akcija2", 21);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

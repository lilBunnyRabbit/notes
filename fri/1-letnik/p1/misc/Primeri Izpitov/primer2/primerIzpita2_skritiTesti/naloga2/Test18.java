public class Test18 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[12]}, new Snov[]{snovi[1]}, "akcija1", 24);
        koraki[1] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[5]}, "akcija1", 6);
        koraki[2] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[10]}, "akcija1", 80);
        koraki[3] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[14]}, "akcija1", 15);
        koraki[4] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[18]}, "akcija1", 14);
        koraki[5] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[19]}, "akcija1", 40);
        koraki[6] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[29]}, "akcija1", 19);
        koraki[7] = new Korak(new Snov[]{snovi[40]}, new Snov[]{snovi[31]}, "akcija1", 62);
        koraki[8] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[38]}, "akcija1", 2);
        koraki[9] = new Korak(new Snov[]{snovi[49]}, new Snov[]{snovi[45]}, "akcija1", 6);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

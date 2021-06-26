public class Test20 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[0]}, "akcija7", 12);
        koraki[1] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[5]}, "akcija6", 28);
        koraki[2] = new Korak(new Snov[]{snovi[8]}, new Snov[]{snovi[10]}, "akcija5", 49);
        koraki[3] = new Korak(new Snov[]{snovi[9]}, new Snov[]{snovi[25]}, "akcija8", 32);
        koraki[4] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[29]}, "akcija4", 59);
        koraki[5] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[33]}, "akcija1", 35);
        koraki[6] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[39]}, "akcija10", 64);
        koraki[7] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[40]}, "akcija4", 10);
        koraki[8] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[41]}, "akcija9", 5);
        koraki[9] = new Korak(new Snov[]{snovi[49]}, new Snov[]{snovi[46]}, "akcija7", 40);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

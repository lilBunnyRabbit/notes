public class Test24 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[23]}, "akcija9", 52);
        koraki[1] = new Korak(new Snov[]{snovi[7]}, new Snov[]{snovi[28]}, "akcija4", 68);
        koraki[2] = new Korak(new Snov[]{snovi[11]}, new Snov[]{snovi[31]}, "akcija5", 34);
        koraki[3] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[33]}, "akcija1", 29);
        koraki[4] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[34]}, "akcija6", 57);
        koraki[5] = new Korak(new Snov[]{snovi[19]}, new Snov[]{snovi[41]}, "akcija9", 31);
        koraki[6] = new Korak(new Snov[]{snovi[27]}, new Snov[]{snovi[44]}, "akcija7", 37);
        koraki[7] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[46]}, "akcija2", 46);
        koraki[8] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[47]}, "akcija4", 93);
        koraki[9] = new Korak(new Snov[]{snovi[49]}, new Snov[]{snovi[48]}, "akcija2", 12);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

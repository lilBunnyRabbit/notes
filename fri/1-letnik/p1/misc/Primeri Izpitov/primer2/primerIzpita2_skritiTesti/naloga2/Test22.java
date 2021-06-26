public class Test22 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[5]}, "akcija9", 76);
        koraki[1] = new Korak(new Snov[]{snovi[1]}, new Snov[]{snovi[9]}, "akcija2", 39);
        koraki[2] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[12]}, "akcija1", 8);
        koraki[3] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[22]}, "akcija8", 22);
        koraki[4] = new Korak(new Snov[]{snovi[10]}, new Snov[]{snovi[23]}, "akcija10", 68);
        koraki[5] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[32]}, "akcija8", 53);
        koraki[6] = new Korak(new Snov[]{snovi[20]}, new Snov[]{snovi[36]}, "akcija3", 47);
        koraki[7] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[42]}, "akcija9", 78);
        koraki[8] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[48]}, "akcija2", 67);
        koraki[9] = new Korak(new Snov[]{snovi[39]}, new Snov[]{snovi[49]}, "akcija6", 41);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

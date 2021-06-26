public class Test25 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[2]}, "akcija8", 51);
        koraki[1] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[5]}, "akcija6", 66);
        koraki[2] = new Korak(new Snov[]{snovi[12]}, new Snov[]{snovi[8]}, "akcija3", 64);
        koraki[3] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[24]}, "akcija8", 2);
        koraki[4] = new Korak(new Snov[]{snovi[22]}, new Snov[]{snovi[30]}, "akcija9", 31);
        koraki[5] = new Korak(new Snov[]{snovi[25]}, new Snov[]{snovi[35]}, "akcija3", 60);
        koraki[6] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[40]}, "akcija8", 83);
        koraki[7] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[42]}, "akcija6", 97);
        koraki[8] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[43]}, "akcija3", 59);
        koraki[9] = new Korak(new Snov[]{snovi[39]}, new Snov[]{snovi[48]}, "akcija6", 29);
        Recept recept = new Recept(koraki);
        System.out.println(recept.prviKorakZAkcijo("akcija1"));
    }
}

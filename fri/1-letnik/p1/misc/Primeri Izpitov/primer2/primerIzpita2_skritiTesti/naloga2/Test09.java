public class Test09 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[6];
        koraki[0] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[7]}, "akcija6", 25);
        koraki[1] = new Korak(new Snov[]{snovi[6]}, new Snov[]{snovi[11]}, "akcija8", 70);
        koraki[2] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[13]}, "akcija1", 60);
        koraki[3] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[34]}, "akcija8", 52);
        koraki[4] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[39]}, "akcija5", 47);
        koraki[5] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[42]}, "akcija2", 58);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

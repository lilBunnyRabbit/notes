public class Test10 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[2];
        koraki[0] = new Korak(new Snov[]{snovi[9]}, new Snov[]{snovi[19]}, "akcija7", 46);
        koraki[1] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[48]}, "akcija3", 13);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

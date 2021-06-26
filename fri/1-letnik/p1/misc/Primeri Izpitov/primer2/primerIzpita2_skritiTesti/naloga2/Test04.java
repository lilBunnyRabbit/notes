public class Test04 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[2];
        koraki[0] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[35]}, "akcija7", 33);
        koraki[1] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[38]}, "akcija9", 28);
        Recept recept = new Recept(koraki);
        System.out.println(recept.trajanje());
    }
}

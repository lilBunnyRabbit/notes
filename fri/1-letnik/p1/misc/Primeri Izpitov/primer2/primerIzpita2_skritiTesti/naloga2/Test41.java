public class Test41 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[1];
        koraki[0] = new Korak(new Snov[]{snovi[19]}, new Snov[]{snovi[7]}, "akcija1", 86);
        Recept recept = new Recept(koraki);
        System.out.println(recept.steviloVstopnihSnovi());
    }
}

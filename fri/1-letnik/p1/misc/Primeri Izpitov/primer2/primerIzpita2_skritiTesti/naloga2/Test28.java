public class Test28 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[1];
        koraki[0] = new Korak(new Snov[]{snovi[18]}, new Snov[]{snovi[1]}, "akcija1", 73);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[2].naIzhodu(recept));
        System.out.println(snovi[14].naIzhodu(recept));
        System.out.println(snovi[18].naIzhodu(recept));
        System.out.println(snovi[19].naIzhodu(recept));
        System.out.println(snovi[22].naIzhodu(recept));
        System.out.println(snovi[27].naIzhodu(recept));
        System.out.println(snovi[29].naIzhodu(recept));
        System.out.println(snovi[30].naIzhodu(recept));
        System.out.println(snovi[32].naIzhodu(recept));
        System.out.println(snovi[40].naIzhodu(recept));
        System.out.println(snovi[48].naIzhodu(recept));
    }
}

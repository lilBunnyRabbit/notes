public class Test29 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[5];
        koraki[0] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[14]}, "akcija1", 51);
        koraki[1] = new Korak(new Snov[]{snovi[31]}, new Snov[]{snovi[16]}, "akcija1", 13);
        koraki[2] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[22]}, "akcija1", 65);
        koraki[3] = new Korak(new Snov[]{snovi[41]}, new Snov[]{snovi[30]}, "akcija1", 43);
        koraki[4] = new Korak(new Snov[]{snovi[49]}, new Snov[]{snovi[33]}, "akcija1", 64);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[0].naIzhodu(recept));
        System.out.println(snovi[2].naIzhodu(recept));
        System.out.println(snovi[4].naIzhodu(recept));
        System.out.println(snovi[10].naIzhodu(recept));
        System.out.println(snovi[15].naIzhodu(recept));
        System.out.println(snovi[21].naIzhodu(recept));
        System.out.println(snovi[26].naIzhodu(recept));
        System.out.println(snovi[29].naIzhodu(recept));
        System.out.println(snovi[38].naIzhodu(recept));
        System.out.println(snovi[40].naIzhodu(recept));
        System.out.println(snovi[42].naIzhodu(recept));
        System.out.println(snovi[46].naIzhodu(recept));
        System.out.println(snovi[49].naIzhodu(recept));
    }
}

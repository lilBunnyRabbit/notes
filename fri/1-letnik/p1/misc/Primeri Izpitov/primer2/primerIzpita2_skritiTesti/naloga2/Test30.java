public class Test30 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[0]}, "akcija1", 1);
        koraki[1] = new Korak(new Snov[]{snovi[7]}, new Snov[]{snovi[5]}, "akcija1", 70);
        koraki[2] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[11]}, "akcija1", 53);
        koraki[3] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[12]}, "akcija1", 95);
        koraki[4] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[24]}, "akcija1", 63);
        koraki[5] = new Korak(new Snov[]{snovi[33]}, new Snov[]{snovi[26]}, "akcija1", 19);
        koraki[6] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[27]}, "akcija1", 16);
        koraki[7] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[45]}, "akcija1", 18);
        koraki[8] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[46]}, "akcija1", 30);
        koraki[9] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[48]}, "akcija1", 83);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[0].naIzhodu(recept));
        System.out.println(snovi[4].naIzhodu(recept));
        System.out.println(snovi[5].naIzhodu(recept));
        System.out.println(snovi[7].naIzhodu(recept));
        System.out.println(snovi[9].naIzhodu(recept));
        System.out.println(snovi[12].naIzhodu(recept));
        System.out.println(snovi[13].naIzhodu(recept));
        System.out.println(snovi[17].naIzhodu(recept));
        System.out.println(snovi[21].naIzhodu(recept));
        System.out.println(snovi[23].naIzhodu(recept));
        System.out.println(snovi[30].naIzhodu(recept));
        System.out.println(snovi[33].naIzhodu(recept));
        System.out.println(snovi[34].naIzhodu(recept));
        System.out.println(snovi[37].naIzhodu(recept));
        System.out.println(snovi[38].naIzhodu(recept));
        System.out.println(snovi[42].naIzhodu(recept));
        System.out.println(snovi[43].naIzhodu(recept));
        System.out.println(snovi[44].naIzhodu(recept));
        System.out.println(snovi[45].naIzhodu(recept));
        System.out.println(snovi[49].naIzhodu(recept));
    }
}

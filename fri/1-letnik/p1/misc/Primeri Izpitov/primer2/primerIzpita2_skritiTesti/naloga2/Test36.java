public class Test36 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[1], snovi[2], snovi[3]}, "akcija1", 19);
        koraki[1] = new Korak(new Snov[]{snovi[8]}, new Snov[]{snovi[5], snovi[6], snovi[7]}, "akcija1", 22);
        koraki[2] = new Korak(new Snov[]{snovi[9]}, new Snov[]{snovi[11], snovi[12], snovi[14]}, "akcija1", 82);
        koraki[3] = new Korak(new Snov[]{snovi[10]}, new Snov[]{snovi[15], snovi[18], snovi[19]}, "akcija1", 1);
        koraki[4] = new Korak(new Snov[]{snovi[16]}, new Snov[]{snovi[20], snovi[21], snovi[24]}, "akcija1", 36);
        koraki[5] = new Korak(new Snov[]{snovi[28]}, new Snov[]{snovi[25], snovi[29], snovi[30]}, "akcija1", 20);
        koraki[6] = new Korak(new Snov[]{snovi[31]}, new Snov[]{snovi[32], snovi[35], snovi[36]}, "akcija1", 4);
        koraki[7] = new Korak(new Snov[]{snovi[40]}, new Snov[]{snovi[38], snovi[39], snovi[41]}, "akcija1", 43);
        koraki[8] = new Korak(new Snov[]{snovi[43]}, new Snov[]{snovi[42], snovi[44], snovi[45]}, "akcija1", 18);
        koraki[9] = new Korak(new Snov[]{snovi[47]}, new Snov[]{snovi[46], snovi[48], snovi[49]}, "akcija1", 97);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[4].naIzhodu(recept));
        System.out.println(snovi[9].naIzhodu(recept));
        System.out.println(snovi[10].naIzhodu(recept));
        System.out.println(snovi[19].naIzhodu(recept));
        System.out.println(snovi[20].naIzhodu(recept));
        System.out.println(snovi[23].naIzhodu(recept));
        System.out.println(snovi[25].naIzhodu(recept));
        System.out.println(snovi[35].naIzhodu(recept));
        System.out.println(snovi[36].naIzhodu(recept));
        System.out.println(snovi[38].naIzhodu(recept));
        System.out.println(snovi[41].naIzhodu(recept));
        System.out.println(snovi[45].naIzhodu(recept));
        System.out.println(snovi[48].naIzhodu(recept));
    }
}

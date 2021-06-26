public class Test32 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[1]}, new Snov[]{snovi[5], snovi[7]}, "akcija1", 9);
        koraki[1] = new Korak(new Snov[]{snovi[3]}, new Snov[]{snovi[8], snovi[9]}, "akcija1", 18);
        koraki[2] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[12], snovi[17]}, "akcija1", 69);
        koraki[3] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[19], snovi[20]}, "akcija1", 80);
        koraki[4] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[22], snovi[23]}, "akcija1", 69);
        koraki[5] = new Korak(new Snov[]{snovi[35]}, new Snov[]{snovi[25], snovi[27]}, "akcija1", 44);
        koraki[6] = new Korak(new Snov[]{snovi[39]}, new Snov[]{snovi[28], snovi[30]}, "akcija1", 9);
        koraki[7] = new Korak(new Snov[]{snovi[42]}, new Snov[]{snovi[33], snovi[36]}, "akcija1", 50);
        koraki[8] = new Korak(new Snov[]{snovi[45]}, new Snov[]{snovi[37], snovi[38]}, "akcija1", 34);
        koraki[9] = new Korak(new Snov[]{snovi[46]}, new Snov[]{snovi[41], snovi[48]}, "akcija1", 73);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[1].naIzhodu(recept));
        System.out.println(snovi[4].naIzhodu(recept));
        System.out.println(snovi[6].naIzhodu(recept));
        System.out.println(snovi[12].naIzhodu(recept));
        System.out.println(snovi[14].naIzhodu(recept));
        System.out.println(snovi[16].naIzhodu(recept));
        System.out.println(snovi[18].naIzhodu(recept));
        System.out.println(snovi[20].naIzhodu(recept));
        System.out.println(snovi[22].naIzhodu(recept));
        System.out.println(snovi[25].naIzhodu(recept));
        System.out.println(snovi[26].naIzhodu(recept));
        System.out.println(snovi[27].naIzhodu(recept));
        System.out.println(snovi[30].naIzhodu(recept));
        System.out.println(snovi[31].naIzhodu(recept));
        System.out.println(snovi[38].naIzhodu(recept));
        System.out.println(snovi[40].naIzhodu(recept));
        System.out.println(snovi[43].naIzhodu(recept));
        System.out.println(snovi[45].naIzhodu(recept));
        System.out.println(snovi[47].naIzhodu(recept));
        System.out.println(snovi[49].naIzhodu(recept));
    }
}

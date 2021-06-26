public class Test37 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[1], snovi[2], snovi[3]}, "akcija1", 14);
        koraki[1] = new Korak(new Snov[]{snovi[5]}, new Snov[]{snovi[4], snovi[6], snovi[7]}, "akcija1", 44);
        koraki[2] = new Korak(new Snov[]{snovi[12]}, new Snov[]{snovi[8], snovi[10], snovi[11]}, "akcija1", 48);
        koraki[3] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[15], snovi[16], snovi[18]}, "akcija1", 66);
        koraki[4] = new Korak(new Snov[]{snovi[17]}, new Snov[]{snovi[19], snovi[20], snovi[22]}, "akcija1", 88);
        koraki[5] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[24], snovi[27], snovi[29]}, "akcija1", 42);
        koraki[6] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[30], snovi[31], snovi[35]}, "akcija1", 74);
        koraki[7] = new Korak(new Snov[]{snovi[25]}, new Snov[]{snovi[37], snovi[38], snovi[39]}, "akcija1", 73);
        koraki[8] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[42], snovi[43], snovi[45]}, "akcija1", 88);
        koraki[9] = new Korak(new Snov[]{snovi[44]}, new Snov[]{snovi[46], snovi[48], snovi[49]}, "akcija1", 46);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[3].naIzhodu(recept));
        System.out.println(snovi[7].naIzhodu(recept));
        System.out.println(snovi[12].naIzhodu(recept));
        System.out.println(snovi[17].naIzhodu(recept));
        System.out.println(snovi[20].naIzhodu(recept));
        System.out.println(snovi[21].naIzhodu(recept));
        System.out.println(snovi[23].naIzhodu(recept));
        System.out.println(snovi[27].naIzhodu(recept));
        System.out.println(snovi[42].naIzhodu(recept));
        System.out.println(snovi[43].naIzhodu(recept));
        System.out.println(snovi[44].naIzhodu(recept));
        System.out.println(snovi[45].naIzhodu(recept));
        System.out.println(snovi[47].naIzhodu(recept));
        System.out.println(snovi[49].naIzhodu(recept));
    }
}

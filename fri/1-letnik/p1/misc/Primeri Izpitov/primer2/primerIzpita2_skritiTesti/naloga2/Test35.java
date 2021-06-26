public class Test35 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[1]}, new Snov[]{snovi[3], snovi[4], snovi[5]}, "akcija1", 66);
        koraki[1] = new Korak(new Snov[]{snovi[2]}, new Snov[]{snovi[7], snovi[8], snovi[9]}, "akcija1", 19);
        koraki[2] = new Korak(new Snov[]{snovi[6]}, new Snov[]{snovi[10], snovi[11], snovi[12]}, "akcija1", 39);
        koraki[3] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[14], snovi[16], snovi[17]}, "akcija1", 27);
        koraki[4] = new Korak(new Snov[]{snovi[21]}, new Snov[]{snovi[19], snovi[20], snovi[22]}, "akcija1", 22);
        koraki[5] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[23], snovi[25], snovi[26]}, "akcija1", 69);
        koraki[6] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[28], snovi[30], snovi[31]}, "akcija1", 65);
        koraki[7] = new Korak(new Snov[]{snovi[44]}, new Snov[]{snovi[32], snovi[33], snovi[34]}, "akcija1", 100);
        koraki[8] = new Korak(new Snov[]{snovi[46]}, new Snov[]{snovi[35], snovi[37], snovi[39]}, "akcija1", 45);
        koraki[9] = new Korak(new Snov[]{snovi[48]}, new Snov[]{snovi[41], snovi[42], snovi[47]}, "akcija1", 52);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[1].naIzhodu(recept));
        System.out.println(snovi[2].naIzhodu(recept));
        System.out.println(snovi[7].naIzhodu(recept));
        System.out.println(snovi[14].naIzhodu(recept));
        System.out.println(snovi[19].naIzhodu(recept));
        System.out.println(snovi[26].naIzhodu(recept));
        System.out.println(snovi[31].naIzhodu(recept));
        System.out.println(snovi[33].naIzhodu(recept));
        System.out.println(snovi[37].naIzhodu(recept));
        System.out.println(snovi[40].naIzhodu(recept));
        System.out.println(snovi[42].naIzhodu(recept));
        System.out.println(snovi[43].naIzhodu(recept));
        System.out.println(snovi[44].naIzhodu(recept));
    }
}

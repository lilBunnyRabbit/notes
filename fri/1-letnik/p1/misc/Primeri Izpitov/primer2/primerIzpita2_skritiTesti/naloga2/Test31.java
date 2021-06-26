public class Test31 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[13]}, new Snov[]{snovi[0]}, "akcija1", 52);
        koraki[1] = new Korak(new Snov[]{snovi[15]}, new Snov[]{snovi[1]}, "akcija1", 46);
        koraki[2] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[5]}, "akcija1", 33);
        koraki[3] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[6]}, "akcija1", 20);
        koraki[4] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[10]}, "akcija1", 34);
        koraki[5] = new Korak(new Snov[]{snovi[30]}, new Snov[]{snovi[17]}, "akcija1", 6);
        koraki[6] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[32]}, "akcija1", 40);
        koraki[7] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[34]}, "akcija1", 21);
        koraki[8] = new Korak(new Snov[]{snovi[39]}, new Snov[]{snovi[35]}, "akcija1", 7);
        koraki[9] = new Korak(new Snov[]{snovi[40]}, new Snov[]{snovi[42]}, "akcija1", 1);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[0].naIzhodu(recept));
        System.out.println(snovi[8].naIzhodu(recept));
        System.out.println(snovi[10].naIzhodu(recept));
        System.out.println(snovi[13].naIzhodu(recept));
        System.out.println(snovi[14].naIzhodu(recept));
        System.out.println(snovi[19].naIzhodu(recept));
        System.out.println(snovi[26].naIzhodu(recept));
        System.out.println(snovi[27].naIzhodu(recept));
        System.out.println(snovi[29].naIzhodu(recept));
        System.out.println(snovi[39].naIzhodu(recept));
        System.out.println(snovi[42].naIzhodu(recept));
        System.out.println(snovi[46].naIzhodu(recept));
    }
}

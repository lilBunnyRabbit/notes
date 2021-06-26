public class Test34 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[2], snovi[3]}, "akcija1", 42);
        koraki[1] = new Korak(new Snov[]{snovi[18]}, new Snov[]{snovi[4], snovi[5]}, "akcija1", 87);
        koraki[2] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[6], snovi[7]}, "akcija1", 77);
        koraki[3] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[9], snovi[10]}, "akcija1", 93);
        koraki[4] = new Korak(new Snov[]{snovi[26]}, new Snov[]{snovi[11], snovi[12]}, "akcija1", 16);
        koraki[5] = new Korak(new Snov[]{snovi[32]}, new Snov[]{snovi[13], snovi[16]}, "akcija1", 85);
        koraki[6] = new Korak(new Snov[]{snovi[36]}, new Snov[]{snovi[20], snovi[29]}, "akcija1", 10);
        koraki[7] = new Korak(new Snov[]{snovi[37]}, new Snov[]{snovi[31], snovi[33]}, "akcija1", 81);
        koraki[8] = new Korak(new Snov[]{snovi[38]}, new Snov[]{snovi[39], snovi[40]}, "akcija1", 79);
        koraki[9] = new Korak(new Snov[]{snovi[42]}, new Snov[]{snovi[44], snovi[46]}, "akcija1", 93);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[0].naIzhodu(recept));
        System.out.println(snovi[3].naIzhodu(recept));
        System.out.println(snovi[4].naIzhodu(recept));
        System.out.println(snovi[7].naIzhodu(recept));
        System.out.println(snovi[8].naIzhodu(recept));
        System.out.println(snovi[16].naIzhodu(recept));
        System.out.println(snovi[17].naIzhodu(recept));
        System.out.println(snovi[18].naIzhodu(recept));
        System.out.println(snovi[22].naIzhodu(recept));
        System.out.println(snovi[26].naIzhodu(recept));
        System.out.println(snovi[33].naIzhodu(recept));
        System.out.println(snovi[41].naIzhodu(recept));
        System.out.println(snovi[46].naIzhodu(recept));
    }
}

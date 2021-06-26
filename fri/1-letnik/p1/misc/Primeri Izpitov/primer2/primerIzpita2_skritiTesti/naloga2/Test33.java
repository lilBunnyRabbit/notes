public class Test33 {
    public static void main(String[] args) {
        Snov[] snovi = new Snov[50];
        for (int i = 0;  i < snovi.length;  i++) {
            snovi[i] = new Snov("snov" + i);
        }
        Korak[] koraki = new Korak[10];
        koraki[0] = new Korak(new Snov[]{snovi[0]}, new Snov[]{snovi[1], snovi[3]}, "akcija1", 75);
        koraki[1] = new Korak(new Snov[]{snovi[4]}, new Snov[]{snovi[6], snovi[7]}, "akcija1", 32);
        koraki[2] = new Korak(new Snov[]{snovi[9]}, new Snov[]{snovi[10], snovi[13]}, "akcija1", 37);
        koraki[3] = new Korak(new Snov[]{snovi[17]}, new Snov[]{snovi[14], snovi[15]}, "akcija1", 10);
        koraki[4] = new Korak(new Snov[]{snovi[23]}, new Snov[]{snovi[16], snovi[19]}, "akcija1", 34);
        koraki[5] = new Korak(new Snov[]{snovi[24]}, new Snov[]{snovi[20], snovi[21]}, "akcija1", 15);
        koraki[6] = new Korak(new Snov[]{snovi[29]}, new Snov[]{snovi[28], snovi[31]}, "akcija1", 39);
        koraki[7] = new Korak(new Snov[]{snovi[34]}, new Snov[]{snovi[38], snovi[42]}, "akcija1", 100);
        koraki[8] = new Korak(new Snov[]{snovi[39]}, new Snov[]{snovi[43], snovi[44]}, "akcija1", 45);
        koraki[9] = new Korak(new Snov[]{snovi[46]}, new Snov[]{snovi[45], snovi[47]}, "akcija1", 29);
        Recept recept = new Recept(koraki);
        System.out.println(snovi[0].naIzhodu(recept));
        System.out.println(snovi[3].naIzhodu(recept));
        System.out.println(snovi[8].naIzhodu(recept));
        System.out.println(snovi[11].naIzhodu(recept));
        System.out.println(snovi[12].naIzhodu(recept));
        System.out.println(snovi[22].naIzhodu(recept));
        System.out.println(snovi[27].naIzhodu(recept));
        System.out.println(snovi[30].naIzhodu(recept));
        System.out.println(snovi[35].naIzhodu(recept));
        System.out.println(snovi[36].naIzhodu(recept));
        System.out.println(snovi[37].naIzhodu(recept));
        System.out.println(snovi[39].naIzhodu(recept));
        System.out.println(snovi[48].naIzhodu(recept));
    }
}

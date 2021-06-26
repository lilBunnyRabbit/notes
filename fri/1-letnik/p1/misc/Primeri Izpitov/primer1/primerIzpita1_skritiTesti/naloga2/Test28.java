public class Test28 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[20];
        sestavine[0] = new Sestavina("s0", 400.0, 41, 25, 3);
        sestavine[1] = new Sestavina("s1", 400.0, 5, 18, 30);
        sestavine[2] = new Sestavina("s2", 500.0, 44, 49, 17);
        sestavine[3] = new Sestavina("s3", 500.0, 25, 31, 14);
        sestavine[4] = new Sestavina("s4", 700.0, 47, 39, 47);
        sestavine[5] = new Sestavina("s5", 300.0, 41, 21, 18);
        sestavine[6] = new Sestavina("s6", 1000.0, 28, 11, 18);
        sestavine[7] = new Sestavina("s7", 500.0, 21, 14, 41);
        sestavine[8] = new Sestavina("s8", 800.0, 31, 15, 50);
        sestavine[9] = new Sestavina("s9", 400.0, 9, 1, 1);
        sestavine[10] = new Sestavina("s10", 400.0, 12, 48, 23);
        sestavine[11] = new Sestavina("s11", 900.0, 47, 19, 28);
        sestavine[12] = new Sestavina("s12", 100.0, 18, 26, 18);
        sestavine[13] = new Sestavina("s13", 500.0, 29, 49, 26);
        sestavine[14] = new Sestavina("s14", 1000.0, 25, 35, 14);
        sestavine[15] = new Sestavina("s15", 300.0, 31, 20, 1);
        sestavine[16] = new Sestavina("s16", 500.0, 50, 7, 15);
        sestavine[17] = new Sestavina("s17", 900.0, 37, 46, 48);
        sestavine[18] = new Sestavina("s18", 100.0, 24, 18, 10);
        sestavine[19] = new Sestavina("s19", 800.0, 46, 20, 40);
        Jed[] jedi = new Jed[4];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[16], sestavine[18]}, new double[]{1000.0, 900.0, 900.0, 900.0, 600.0, 900.0, 600.0, 700.0, 500.0, 700.0, 400.0, 300.0, 300.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9], sestavine[18]}, new double[]{800.0, 400.0, 600.0, 800.0, 400.0, 300.0, 700.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[17], sestavine[18], sestavine[19]}, new double[]{600.0, 400.0, 500.0, 500.0, 600.0, 900.0, 400.0, 900.0, 600.0, 600.0, 900.0, 300.0, 700.0, 800.0, 600.0, 300.0, 200.0, 100.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[7], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[16], sestavine[17], sestavine[19]}, new double[]{200.0, 800.0, 800.0, 800.0, 200.0, 700.0, 100.0, 400.0, 1000.0, 1000.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

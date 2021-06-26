public class Test27 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[20];
        sestavine[0] = new Sestavina("s0", 900.0, 6, 25, 24);
        sestavine[1] = new Sestavina("s1", 1000.0, 37, 33, 15);
        sestavine[2] = new Sestavina("s2", 200.0, 23, 45, 19);
        sestavine[3] = new Sestavina("s3", 600.0, 15, 26, 48);
        sestavine[4] = new Sestavina("s4", 800.0, 18, 34, 49);
        sestavine[5] = new Sestavina("s5", 900.0, 45, 46, 42);
        sestavine[6] = new Sestavina("s6", 800.0, 34, 46, 39);
        sestavine[7] = new Sestavina("s7", 600.0, 32, 35, 14);
        sestavine[8] = new Sestavina("s8", 700.0, 11, 38, 49);
        sestavine[9] = new Sestavina("s9", 600.0, 1, 41, 20);
        sestavine[10] = new Sestavina("s10", 800.0, 1, 26, 30);
        sestavine[11] = new Sestavina("s11", 500.0, 2, 49, 5);
        sestavine[12] = new Sestavina("s12", 600.0, 2, 34, 11);
        sestavine[13] = new Sestavina("s13", 600.0, 3, 48, 16);
        sestavine[14] = new Sestavina("s14", 900.0, 38, 29, 39);
        sestavine[15] = new Sestavina("s15", 900.0, 7, 39, 27);
        sestavine[16] = new Sestavina("s16", 600.0, 24, 44, 5);
        sestavine[17] = new Sestavina("s17", 900.0, 18, 42, 10);
        sestavine[18] = new Sestavina("s18", 100.0, 42, 50, 50);
        sestavine[19] = new Sestavina("s19", 1000.0, 20, 41, 4);
        Jed[] jedi = new Jed[6];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[10], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{300.0, 900.0, 700.0, 700.0, 300.0, 100.0, 300.0, 400.0, 1000.0, 100.0, 600.0, 400.0, 400.0, 300.0, 700.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{100.0, 500.0, 1000.0, 500.0, 200.0, 900.0, 700.0, 800.0, 400.0, 300.0, 700.0, 400.0, 100.0, 700.0, 400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[13], sestavine[16], sestavine[17], sestavine[18]}, new double[]{700.0, 100.0, 1000.0, 1000.0, 200.0, 900.0, 600.0, 500.0, 600.0, 100.0, 200.0, 200.0, 300.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[11], sestavine[12], sestavine[16], sestavine[19]}, new double[]{1000.0, 1000.0, 400.0, 900.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18]}, new double[]{600.0, 100.0, 400.0, 900.0, 900.0, 600.0, 800.0, 500.0, 900.0, 800.0, 800.0, 1000.0, 100.0, 1000.0, 600.0, 800.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[2], sestavine[10], sestavine[15], sestavine[16], sestavine[19]}, new double[]{900.0, 200.0, 200.0, 1000.0, 900.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

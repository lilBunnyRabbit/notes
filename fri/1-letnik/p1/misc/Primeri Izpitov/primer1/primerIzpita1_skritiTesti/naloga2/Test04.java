public class Test04 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[20];
        sestavine[0] = new Sestavina("s0", 300.0, 14, 14, 37);
        sestavine[1] = new Sestavina("s1", 400.0, 41, 7, 25);
        sestavine[2] = new Sestavina("s2", 300.0, 37, 0, 36);
        sestavine[3] = new Sestavina("s3", 700.0, 5, 11, 31);
        sestavine[4] = new Sestavina("s4", 200.0, 40, 3, 49);
        sestavine[5] = new Sestavina("s5", 800.0, 36, 14, 13);
        sestavine[6] = new Sestavina("s6", 500.0, 1, 7, 16);
        sestavine[7] = new Sestavina("s7", 300.0, 14, 13, 30);
        sestavine[8] = new Sestavina("s8", 300.0, 42, 8, 35);
        sestavine[9] = new Sestavina("s9", 400.0, 31, 6, 3);
        sestavine[10] = new Sestavina("s10", 100.0, 38, 14, 34);
        sestavine[11] = new Sestavina("s11", 300.0, 15, 14, 42);
        sestavine[12] = new Sestavina("s12", 500.0, 44, 11, 3);
        sestavine[13] = new Sestavina("s13", 700.0, 22, 14, 11);
        sestavine[14] = new Sestavina("s14", 600.0, 20, 0, 33);
        sestavine[15] = new Sestavina("s15", 900.0, 7, 9, 27);
        sestavine[16] = new Sestavina("s16", 300.0, 33, 14, 4);
        sestavine[17] = new Sestavina("s17", 300.0, 8, 9, 35);
        sestavine[18] = new Sestavina("s18", 400.0, 21, 12, 4);
        sestavine[19] = new Sestavina("s19", 1000.0, 30, 9, 8);
        Jed[] jedi = new Jed[11];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[2], sestavine[6], sestavine[8], sestavine[12], sestavine[17]}, new double[]{400.0, 700.0, 800.0, 1000.0, 800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[10]}, new double[]{400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[8], sestavine[12], sestavine[16], sestavine[18]}, new double[]{400.0, 800.0, 200.0, 400.0, 700.0, 800.0, 1000.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{900.0, 500.0, 400.0, 200.0, 600.0, 1000.0, 200.0, 600.0, 900.0, 300.0, 800.0, 500.0, 900.0, 400.0, 300.0, 600.0, 700.0, 1000.0, 1000.0, 400.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[2], sestavine[3], sestavine[7], sestavine[9], sestavine[11], sestavine[13], sestavine[14], sestavine[16], sestavine[19]}, new double[]{700.0, 100.0, 1000.0, 800.0, 800.0, 300.0, 900.0, 900.0, 800.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{200.0, 600.0, 600.0, 900.0, 800.0, 1000.0, 300.0, 400.0, 700.0, 100.0, 500.0, 300.0, 800.0, 500.0, 400.0, 300.0, 500.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[10], sestavine[12], sestavine[16], sestavine[19]}, new double[]{200.0, 900.0, 400.0, 300.0, 700.0, 500.0, 500.0, 100.0, 900.0, 300.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{800.0, 800.0, 200.0, 700.0, 1000.0, 100.0, 200.0, 1000.0, 500.0, 1000.0, 500.0, 700.0, 500.0, 900.0, 500.0, 100.0, 400.0, 100.0, 400.0, 500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[1], sestavine[8], sestavine[10], sestavine[13], sestavine[18], sestavine[19]}, new double[]{100.0, 800.0, 100.0, 600.0, 200.0, 200.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[13], sestavine[15], sestavine[16], sestavine[17]}, new double[]{200.0, 200.0, 1000.0, 100.0, 500.0, 800.0, 700.0, 900.0, 300.0, 900.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[13], sestavine[16]}, new double[]{1000.0, 100.0, 300.0, 800.0, 100.0, 1000.0, 900.0}, "vrsta");
        System.out.println(jedi[9].jeBeljakovinska());
    }
}

public class Test07 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[20];
        sestavine[0] = new Sestavina("s0", 900.0, 37, 12, 6);
        sestavine[1] = new Sestavina("s1", 800.0, 25, 12, 2);
        sestavine[2] = new Sestavina("s2", 900.0, 46, 12, 27);
        sestavine[3] = new Sestavina("s3", 400.0, 29, 1, 31);
        sestavine[4] = new Sestavina("s4", 400.0, 30, 9, 49);
        sestavine[5] = new Sestavina("s5", 400.0, 37, 15, 15);
        sestavine[6] = new Sestavina("s6", 200.0, 38, 7, 50);
        sestavine[7] = new Sestavina("s7", 1000.0, 28, 14, 35);
        sestavine[8] = new Sestavina("s8", 100.0, 9, 5, 19);
        sestavine[9] = new Sestavina("s9", 200.0, 24, 7, 48);
        sestavine[10] = new Sestavina("s10", 100.0, 49, 9, 13);
        sestavine[11] = new Sestavina("s11", 400.0, 25, 14, 42);
        sestavine[12] = new Sestavina("s12", 700.0, 33, 14, 8);
        sestavine[13] = new Sestavina("s13", 1000.0, 40, 5, 8);
        sestavine[14] = new Sestavina("s14", 200.0, 19, 9, 8);
        sestavine[15] = new Sestavina("s15", 100.0, 1, 7, 7);
        sestavine[16] = new Sestavina("s16", 200.0, 31, 12, 25);
        sestavine[17] = new Sestavina("s17", 800.0, 46, 6, 31);
        sestavine[18] = new Sestavina("s18", 100.0, 26, 15, 22);
        sestavine[19] = new Sestavina("s19", 100.0, 45, 7, 41);
        Jed[] jedi = new Jed[17];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{400.0, 800.0, 600.0, 800.0, 1000.0, 400.0, 800.0, 600.0, 1000.0, 600.0, 300.0, 700.0, 100.0, 400.0, 100.0, 700.0, 200.0, 900.0, 1000.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[1], sestavine[3]}, new double[]{300.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15], sestavine[17], sestavine[18], sestavine[19]}, new double[]{600.0, 100.0, 800.0, 900.0, 400.0, 200.0, 600.0, 800.0, 300.0, 300.0, 400.0, 1000.0, 900.0, 1000.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[5], sestavine[8], sestavine[16], sestavine[17], sestavine[19]}, new double[]{200.0, 100.0, 400.0, 500.0, 300.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[6], sestavine[7], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18]}, new double[]{200.0, 300.0, 100.0, 800.0, 800.0, 900.0, 500.0, 100.0, 900.0, 100.0, 900.0, 200.0, 400.0, 900.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[2], sestavine[6]}, new double[]{400.0, 900.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{200.0, 400.0, 800.0, 1000.0, 100.0, 900.0, 700.0, 400.0, 700.0, 900.0, 500.0, 400.0, 700.0, 1000.0, 500.0, 200.0, 1000.0, 600.0, 600.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{1000.0, 600.0, 900.0, 600.0, 200.0, 300.0, 300.0, 700.0, 900.0, 500.0, 500.0, 500.0, 600.0, 300.0, 200.0, 200.0, 700.0, 200.0, 800.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[19]}, new double[]{800.0, 1000.0, 400.0, 200.0, 800.0, 200.0, 500.0, 100.0, 1000.0, 1000.0, 100.0, 600.0, 200.0, 1000.0, 600.0, 500.0, 800.0, 800.0, 600.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18], sestavine[19]}, new double[]{700.0, 900.0, 700.0, 700.0, 700.0, 400.0, 500.0, 800.0, 400.0, 300.0, 100.0, 100.0, 600.0, 300.0, 500.0, 300.0, 1000.0, 1000.0, 700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[9], sestavine[14], sestavine[18], sestavine[19]}, new double[]{600.0, 900.0, 200.0, 700.0, 1000.0, 1000.0, 100.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[3], sestavine[4], sestavine[5], sestavine[14], sestavine[15]}, new double[]{100.0, 900.0, 200.0, 500.0, 500.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[2], sestavine[6], sestavine[8], sestavine[9], sestavine[11], sestavine[16], sestavine[18], sestavine[19]}, new double[]{600.0, 700.0, 1000.0, 600.0, 900.0, 1000.0, 500.0, 200.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[7], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15], sestavine[18], sestavine[19]}, new double[]{800.0, 1000.0, 200.0, 200.0, 800.0, 200.0, 900.0, 700.0, 400.0, 700.0, 100.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[2], sestavine[8], sestavine[9], sestavine[12]}, new double[]{1000.0, 700.0, 900.0, 700.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[19]}, new double[]{1000.0, 800.0, 700.0, 600.0, 100.0, 800.0, 1000.0, 600.0, 500.0, 900.0, 1000.0, 800.0, 1000.0, 100.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[1]}, new double[]{800.0}, "vrsta");
        System.out.println(jedi[11].jeBeljakovinska());
        System.out.println(jedi[12].jeBeljakovinska());
    }
}

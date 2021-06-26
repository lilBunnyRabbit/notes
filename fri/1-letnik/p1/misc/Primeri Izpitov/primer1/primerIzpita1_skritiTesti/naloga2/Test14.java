public class Test14 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[18];
        sestavine[0] = new Sestavina("s0", 200.0, 9, 28, 49);
        sestavine[1] = new Sestavina("s1", 300.0, 5, 24, 12);
        sestavine[2] = new Sestavina("s2", 400.0, 50, 15, 18);
        sestavine[3] = new Sestavina("s3", 500.0, 25, 9, 49);
        sestavine[4] = new Sestavina("s4", 700.0, 10, 32, 23);
        sestavine[5] = new Sestavina("s5", 500.0, 38, 37, 19);
        sestavine[6] = new Sestavina("s6", 1000.0, 24, 49, 39);
        sestavine[7] = new Sestavina("s7", 600.0, 47, 47, 43);
        sestavine[8] = new Sestavina("s8", 500.0, 24, 7, 39);
        sestavine[9] = new Sestavina("s9", 900.0, 50, 23, 47);
        sestavine[10] = new Sestavina("s10", 800.0, 6, 6, 13);
        sestavine[11] = new Sestavina("s11", 500.0, 4, 26, 10);
        sestavine[12] = new Sestavina("s12", 700.0, 36, 18, 2);
        sestavine[13] = new Sestavina("s13", 200.0, 35, 17, 6);
        sestavine[14] = new Sestavina("s14", 100.0, 9, 26, 3);
        sestavine[15] = new Sestavina("s15", 300.0, 13, 0, 2);
        sestavine[16] = new Sestavina("s16", 900.0, 12, 8, 38);
        sestavine[17] = new Sestavina("s17", 800.0, 43, 3, 0);
        Jed[] jedi = new Jed[17];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{500.0, 800.0, 600.0, 200.0, 300.0, 300.0, 100.0, 1000.0, 300.0, 900.0, 400.0, 400.0, 300.0, 500.0, 900.0, 600.0, 800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[3], sestavine[10]}, new double[]{100.0, 300.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[2], sestavine[3], sestavine[9], sestavine[12], sestavine[14], sestavine[15]}, new double[]{1000.0, 500.0, 800.0, 300.0, 200.0, 400.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[15], sestavine[16], sestavine[17]}, new double[]{400.0, 100.0, 600.0, 300.0, 700.0, 400.0, 800.0, 500.0, 200.0, 300.0, 200.0, 600.0, 400.0, 600.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{400.0, 900.0, 200.0, 400.0, 800.0, 1000.0, 400.0, 700.0, 600.0, 200.0, 400.0, 500.0, 200.0, 700.0, 600.0, 300.0, 100.0, 1000.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0]}, new double[]{800.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{500.0, 900.0, 300.0, 100.0, 700.0, 700.0, 100.0, 1000.0, 900.0, 100.0, 600.0, 200.0, 300.0, 900.0, 800.0, 800.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[7], sestavine[9], sestavine[13], sestavine[15]}, new double[]{1000.0, 700.0, 600.0, 500.0, 900.0, 800.0, 300.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[2], sestavine[4], sestavine[5], sestavine[9], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{600.0, 700.0, 1000.0, 900.0, 600.0, 500.0, 500.0, 600.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[1], sestavine[7], sestavine[10], sestavine[13], sestavine[16]}, new double[]{200.0, 1000.0, 200.0, 700.0, 400.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[17]}, new double[]{300.0, 600.0, 800.0, 200.0, 300.0, 200.0, 100.0, 100.0, 100.0, 700.0, 900.0, 600.0, 800.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[1], sestavine[6], sestavine[8], sestavine[9], sestavine[16]}, new double[]{700.0, 300.0, 300.0, 500.0, 100.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{1000.0, 900.0, 800.0, 200.0, 900.0, 400.0, 600.0, 1000.0, 800.0, 400.0, 600.0, 700.0, 200.0, 100.0, 900.0, 100.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16]}, new double[]{800.0, 400.0, 700.0, 800.0, 500.0, 500.0, 800.0, 600.0, 600.0, 600.0, 800.0, 1000.0, 200.0, 1000.0, 800.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[11], sestavine[13], sestavine[14], sestavine[17]}, new double[]{400.0, 100.0, 500.0, 900.0, 200.0, 400.0, 600.0, 500.0, 500.0, 400.0, 100.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{900.0, 100.0, 100.0, 1000.0, 600.0, 100.0, 500.0, 200.0, 200.0, 700.0, 1000.0, 900.0, 300.0, 200.0, 400.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[2], sestavine[11], sestavine[17]}, new double[]{200.0, 100.0, 200.0}, "vrsta");
        System.out.println(Math.round(jedi[4].kalorije()));
    }
}

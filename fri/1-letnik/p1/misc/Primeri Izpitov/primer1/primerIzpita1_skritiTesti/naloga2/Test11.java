public class Test11 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[18];
        sestavine[0] = new Sestavina("s0", 500.0, 38, 15, 8);
        sestavine[1] = new Sestavina("s1", 1000.0, 20, 14, 30);
        sestavine[2] = new Sestavina("s2", 100.0, 39, 19, 50);
        sestavine[3] = new Sestavina("s3", 400.0, 44, 21, 45);
        sestavine[4] = new Sestavina("s4", 700.0, 10, 16, 27);
        sestavine[5] = new Sestavina("s5", 900.0, 48, 46, 27);
        sestavine[6] = new Sestavina("s6", 100.0, 37, 39, 27);
        sestavine[7] = new Sestavina("s7", 500.0, 0, 34, 25);
        sestavine[8] = new Sestavina("s8", 800.0, 20, 21, 19);
        sestavine[9] = new Sestavina("s9", 500.0, 50, 15, 34);
        sestavine[10] = new Sestavina("s10", 700.0, 33, 41, 7);
        sestavine[11] = new Sestavina("s11", 600.0, 9, 18, 24);
        sestavine[12] = new Sestavina("s12", 900.0, 14, 8, 46);
        sestavine[13] = new Sestavina("s13", 900.0, 4, 42, 36);
        sestavine[14] = new Sestavina("s14", 400.0, 39, 17, 7);
        sestavine[15] = new Sestavina("s15", 500.0, 31, 11, 39);
        sestavine[16] = new Sestavina("s16", 300.0, 33, 42, 38);
        sestavine[17] = new Sestavina("s17", 500.0, 1, 41, 15);
        Jed[] jedi = new Jed[17];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[16], sestavine[17]}, new double[]{100.0, 900.0, 500.0, 600.0, 300.0, 400.0, 700.0, 100.0, 700.0, 500.0, 900.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{600.0, 300.0, 500.0, 500.0, 500.0, 1000.0, 100.0, 800.0, 900.0, 500.0, 700.0, 600.0, 500.0, 500.0, 700.0, 400.0, 900.0, 1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[3], sestavine[9], sestavine[13]}, new double[]{900.0, 500.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{500.0, 900.0, 200.0, 500.0, 800.0, 700.0, 400.0, 500.0, 900.0, 400.0, 900.0, 200.0, 1000.0, 900.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{1000.0, 700.0, 100.0, 500.0, 1000.0, 400.0, 100.0, 100.0, 900.0, 700.0, 300.0, 1000.0, 400.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[16], sestavine[17]}, new double[]{400.0, 600.0, 700.0, 200.0, 400.0, 600.0, 300.0, 400.0, 300.0, 200.0, 200.0, 200.0, 200.0, 100.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14], sestavine[17]}, new double[]{200.0, 200.0, 100.0, 400.0, 900.0, 100.0, 200.0, 600.0, 800.0, 400.0, 600.0, 900.0, 400.0, 800.0, 800.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[2], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[17]}, new double[]{600.0, 1000.0, 1000.0, 700.0, 400.0, 800.0, 100.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[4], sestavine[6], sestavine[8], sestavine[9], sestavine[11], sestavine[14]}, new double[]{1000.0, 700.0, 900.0, 900.0, 100.0, 100.0, 300.0, 900.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{1000.0, 400.0, 900.0, 1000.0, 900.0, 800.0, 800.0, 200.0, 800.0, 100.0, 600.0, 700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[7], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[17]}, new double[]{400.0, 800.0, 700.0, 500.0, 400.0, 1000.0, 400.0, 900.0, 400.0, 600.0, 1000.0, 200.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[13], sestavine[15], sestavine[16], sestavine[17]}, new double[]{700.0, 1000.0, 600.0, 100.0, 100.0, 300.0, 500.0, 500.0, 200.0, 100.0, 100.0, 600.0, 400.0, 700.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[3], sestavine[4], sestavine[9], sestavine[14], sestavine[17]}, new double[]{900.0, 600.0, 700.0, 200.0, 800.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{300.0, 900.0, 100.0, 800.0, 100.0, 400.0, 800.0, 300.0, 800.0, 600.0, 200.0, 200.0, 600.0, 200.0, 100.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[10], sestavine[11], sestavine[13], sestavine[16]}, new double[]{1000.0, 200.0, 1000.0, 300.0, 1000.0, 500.0, 900.0, 300.0, 900.0, 400.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[12], sestavine[15]}, new double[]{500.0, 300.0, 400.0, 500.0, 200.0, 400.0, 500.0, 1000.0, 700.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[14], sestavine[15], sestavine[16]}, new double[]{700.0, 1000.0, 400.0, 900.0, 400.0, 800.0, 400.0, 1000.0, 600.0, 200.0, 300.0, 100.0, 800.0, 1000.0}, "vrsta");
        System.out.println(Math.round(jedi[10].kalorije()));
    }
}

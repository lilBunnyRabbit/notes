public class Test29 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[17];
        sestavine[0] = new Sestavina("s0", 800.0, 22, 40, 38);
        sestavine[1] = new Sestavina("s1", 900.0, 22, 43, 8);
        sestavine[2] = new Sestavina("s2", 1000.0, 15, 39, 46);
        sestavine[3] = new Sestavina("s3", 500.0, 25, 38, 39);
        sestavine[4] = new Sestavina("s4", 700.0, 25, 26, 46);
        sestavine[5] = new Sestavina("s5", 200.0, 30, 31, 13);
        sestavine[6] = new Sestavina("s6", 100.0, 14, 30, 6);
        sestavine[7] = new Sestavina("s7", 400.0, 13, 7, 24);
        sestavine[8] = new Sestavina("s8", 200.0, 49, 6, 49);
        sestavine[9] = new Sestavina("s9", 200.0, 24, 34, 6);
        sestavine[10] = new Sestavina("s10", 800.0, 21, 21, 33);
        sestavine[11] = new Sestavina("s11", 400.0, 30, 30, 9);
        sestavine[12] = new Sestavina("s12", 1000.0, 22, 19, 16);
        sestavine[13] = new Sestavina("s13", 700.0, 12, 9, 42);
        sestavine[14] = new Sestavina("s14", 200.0, 37, 20, 11);
        sestavine[15] = new Sestavina("s15", 500.0, 22, 31, 2);
        sestavine[16] = new Sestavina("s16", 200.0, 19, 5, 12);
        Jed[] jedi = new Jed[17];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2], sestavine[14], sestavine[15]}, new double[]{1000.0, 100.0, 300.0, 800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[13]}, new double[]{200.0, 600.0, 900.0, 900.0, 200.0, 400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[12], sestavine[14], sestavine[15]}, new double[]{300.0, 400.0, 1000.0, 500.0, 700.0, 800.0, 700.0, 400.0, 500.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[11], sestavine[12], sestavine[16]}, new double[]{200.0, 700.0, 500.0, 900.0, 900.0, 600.0, 600.0, 800.0, 100.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[5], sestavine[6], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15]}, new double[]{700.0, 1000.0, 200.0, 900.0, 1000.0, 200.0, 100.0, 900.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[7], sestavine[12], sestavine[14]}, new double[]{600.0, 300.0, 400.0, 900.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[8], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{200.0, 900.0, 800.0, 900.0, 1000.0, 400.0, 200.0, 100.0, 1000.0, 600.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[14], sestavine[15], sestavine[16]}, new double[]{200.0, 600.0, 200.0, 900.0, 500.0, 500.0, 1000.0, 800.0, 500.0, 700.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16]}, new double[]{400.0, 600.0, 700.0, 200.0, 300.0, 700.0, 100.0, 800.0, 900.0, 500.0, 600.0, 600.0, 700.0, 200.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[12], sestavine[16]}, new double[]{500.0, 500.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15], sestavine[16]}, new double[]{700.0, 1000.0, 200.0, 400.0, 600.0, 800.0, 100.0, 300.0, 900.0, 500.0, 900.0, 300.0, 600.0, 800.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[2], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[13], sestavine[15], sestavine[16]}, new double[]{600.0, 500.0, 1000.0, 700.0, 500.0, 400.0, 700.0, 1000.0, 700.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[16]}, new double[]{600.0, 900.0, 900.0, 500.0, 600.0, 500.0, 100.0, 1000.0, 400.0, 700.0, 800.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9], sestavine[12], sestavine[15]}, new double[]{200.0, 600.0, 200.0, 300.0, 1000.0, 200.0, 100.0, 800.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[5], sestavine[10], sestavine[13], sestavine[16]}, new double[]{300.0, 200.0, 1000.0, 500.0, 700.0, 400.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{700.0, 1000.0, 300.0, 500.0, 900.0, 600.0, 700.0, 500.0, 700.0, 600.0, 800.0, 1000.0, 100.0, 400.0, 100.0, 800.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[10]}, new double[]{900.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

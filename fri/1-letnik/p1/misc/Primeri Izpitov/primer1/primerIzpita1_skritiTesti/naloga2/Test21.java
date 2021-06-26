public class Test21 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[18];
        sestavine[0] = new Sestavina("s0", 1000.0, 25, 50, 21);
        sestavine[1] = new Sestavina("s1", 700.0, 37, 37, 14);
        sestavine[2] = new Sestavina("s2", 500.0, 25, 46, 2);
        sestavine[3] = new Sestavina("s3", 100.0, 15, 38, 34);
        sestavine[4] = new Sestavina("s4", 900.0, 33, 47, 14);
        sestavine[5] = new Sestavina("s5", 1000.0, 48, 24, 27);
        sestavine[6] = new Sestavina("s6", 700.0, 11, 36, 46);
        sestavine[7] = new Sestavina("s7", 400.0, 18, 38, 11);
        sestavine[8] = new Sestavina("s8", 300.0, 30, 30, 30);
        sestavine[9] = new Sestavina("s9", 300.0, 40, 25, 41);
        sestavine[10] = new Sestavina("s10", 700.0, 6, 49, 11);
        sestavine[11] = new Sestavina("s11", 1000.0, 32, 24, 11);
        sestavine[12] = new Sestavina("s12", 800.0, 1, 23, 36);
        sestavine[13] = new Sestavina("s13", 1000.0, 11, 47, 38);
        sestavine[14] = new Sestavina("s14", 500.0, 22, 47, 32);
        sestavine[15] = new Sestavina("s15", 300.0, 50, 36, 40);
        sestavine[16] = new Sestavina("s16", 900.0, 34, 31, 4);
        sestavine[17] = new Sestavina("s17", 800.0, 15, 22, 39);
        Jed[] jedi = new Jed[19];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[2], sestavine[15], sestavine[16]}, new double[]{200.0, 800.0, 1000.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{800.0, 200.0, 900.0, 200.0, 500.0, 700.0, 100.0, 1000.0, 300.0, 400.0, 400.0, 400.0, 300.0, 100.0, 600.0, 400.0, 700.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[2], sestavine[7], sestavine[10], sestavine[11], sestavine[13], sestavine[15], sestavine[17]}, new double[]{800.0, 500.0, 200.0, 1000.0, 300.0, 400.0, 900.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[2], sestavine[6], sestavine[10], sestavine[12], sestavine[14], sestavine[15]}, new double[]{500.0, 700.0, 100.0, 1000.0, 200.0, 300.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[9], sestavine[11], sestavine[12], sestavine[14], sestavine[15], sestavine[17]}, new double[]{600.0, 300.0, 1000.0, 900.0, 900.0, 100.0, 800.0, 100.0, 200.0, 200.0, 300.0, 400.0, 100.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[2], sestavine[9], sestavine[11], sestavine[12], sestavine[17]}, new double[]{200.0, 800.0, 200.0, 600.0, 800.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15]}, new double[]{1000.0, 100.0, 100.0, 500.0, 700.0, 400.0, 900.0, 600.0, 1000.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{500.0, 500.0, 400.0, 1000.0, 500.0, 500.0, 200.0, 900.0, 100.0, 900.0, 800.0, 900.0, 100.0, 1000.0, 400.0, 500.0, 900.0, 900.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[10]}, new double[]{100.0, 1000.0, 800.0, 500.0, 300.0, 400.0, 1000.0, 1000.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[17]}, new double[]{1000.0, 400.0, 600.0, 700.0, 800.0, 300.0, 400.0, 100.0, 600.0, 600.0, 900.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{1000.0, 100.0, 100.0, 1000.0, 300.0, 300.0, 900.0, 200.0, 200.0, 1000.0, 800.0, 200.0, 1000.0, 900.0, 700.0, 800.0, 900.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[5], sestavine[10], sestavine[12]}, new double[]{200.0, 1000.0, 100.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[2], sestavine[5], sestavine[11], sestavine[14], sestavine[16]}, new double[]{200.0, 600.0, 800.0, 1000.0, 400.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[3], sestavine[5], sestavine[8], sestavine[11], sestavine[12], sestavine[14], sestavine[17]}, new double[]{300.0, 700.0, 1000.0, 500.0, 400.0, 100.0, 400.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{300.0, 100.0, 200.0, 900.0, 800.0, 200.0, 1000.0, 700.0, 700.0, 400.0, 600.0, 500.0, 100.0, 300.0, 200.0, 400.0, 100.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[6]}, new double[]{600.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[2], sestavine[6], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[16], sestavine[17]}, new double[]{300.0, 800.0, 400.0, 300.0, 600.0, 800.0, 400.0, 500.0}, "vrsta");
        jedi[17] = new Jed("j17", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[16]}, new double[]{700.0, 1000.0, 100.0, 900.0, 500.0, 200.0, 400.0, 500.0, 300.0, 100.0, 800.0, 100.0, 200.0, 100.0}, "vrsta");
        jedi[18] = new Jed("j18", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{600.0, 600.0, 800.0, 600.0, 500.0, 100.0, 300.0, 700.0, 1000.0, 1000.0, 400.0, 300.0, 100.0, 600.0, 1000.0, 400.0, 700.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

public class Test31 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[14];
        sestavine[0] = new Sestavina("s0", 900.0, 17, 40, 6);
        sestavine[1] = new Sestavina("s1", 100.0, 12, 40, 47);
        sestavine[2] = new Sestavina("s2", 200.0, 33, 25, 46);
        sestavine[3] = new Sestavina("s3", 800.0, 11, 38, 29);
        sestavine[4] = new Sestavina("s4", 200.0, 24, 11, 41);
        sestavine[5] = new Sestavina("s5", 100.0, 29, 24, 4);
        sestavine[6] = new Sestavina("s6", 1000.0, 37, 25, 39);
        sestavine[7] = new Sestavina("s7", 1000.0, 23, 37, 28);
        sestavine[8] = new Sestavina("s8", 600.0, 20, 20, 23);
        sestavine[9] = new Sestavina("s9", 1000.0, 49, 17, 12);
        sestavine[10] = new Sestavina("s10", 300.0, 23, 25, 35);
        sestavine[11] = new Sestavina("s11", 400.0, 21, 50, 43);
        sestavine[12] = new Sestavina("s12", 800.0, 25, 27, 23);
        sestavine[13] = new Sestavina("s13", 1000.0, 36, 24, 38);
        Jed[] jedi = new Jed[14];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{800.0, 900.0, 100.0, 1000.0, 500.0, 900.0, 200.0, 700.0, 400.0, 900.0, 100.0, 100.0, 300.0, 900.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[9]}, new double[]{1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{200.0, 200.0, 500.0, 300.0, 100.0, 1000.0, 700.0, 800.0, 600.0, 500.0, 200.0, 1000.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{400.0, 900.0, 500.0, 400.0, 800.0, 900.0, 900.0, 300.0, 500.0, 500.0, 700.0, 400.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[4], sestavine[11], sestavine[12]}, new double[]{200.0, 800.0, 400.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[9], sestavine[10]}, new double[]{700.0, 700.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[13]}, new double[]{800.0, 500.0, 1000.0, 900.0, 200.0, 400.0, 500.0, 500.0, 200.0, 800.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{1000.0, 400.0, 600.0, 500.0, 1000.0, 400.0, 100.0, 1000.0, 900.0, 800.0, 300.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[5], sestavine[8], sestavine[11]}, new double[]{300.0, 500.0, 200.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[5], sestavine[11]}, new double[]{800.0, 500.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{500.0, 500.0, 700.0, 800.0, 500.0, 400.0, 200.0, 800.0, 800.0, 600.0, 700.0, 600.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[4], sestavine[11]}, new double[]{700.0, 300.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[8], sestavine[12], sestavine[13]}, new double[]{400.0, 400.0, 100.0, 700.0, 1000.0, 700.0, 800.0, 200.0, 200.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[11], sestavine[12], sestavine[13]}, new double[]{400.0, 300.0, 800.0, 500.0, 800.0, 500.0, 800.0, 700.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s2")));
    }
}

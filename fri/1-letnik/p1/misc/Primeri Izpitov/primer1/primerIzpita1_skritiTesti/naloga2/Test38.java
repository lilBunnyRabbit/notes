public class Test38 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 400.0, 31, 15, 48);
        sestavine[1] = new Sestavina("s1", 500.0, 27, 34, 0);
        sestavine[2] = new Sestavina("s2", 700.0, 40, 0, 49);
        sestavine[3] = new Sestavina("s3", 900.0, 16, 40, 45);
        sestavine[4] = new Sestavina("s4", 300.0, 17, 4, 42);
        sestavine[5] = new Sestavina("s5", 600.0, 14, 47, 48);
        sestavine[6] = new Sestavina("s6", 600.0, 49, 42, 20);
        sestavine[7] = new Sestavina("s7", 600.0, 26, 2, 11);
        sestavine[8] = new Sestavina("s8", 600.0, 28, 45, 50);
        sestavine[9] = new Sestavina("s9", 1000.0, 16, 22, 29);
        sestavine[10] = new Sestavina("s10", 700.0, 1, 37, 11);
        sestavine[11] = new Sestavina("s11", 900.0, 39, 32, 35);
        sestavine[12] = new Sestavina("s12", 200.0, 41, 12, 32);
        sestavine[13] = new Sestavina("s13", 800.0, 4, 17, 49);
        sestavine[14] = new Sestavina("s14", 800.0, 42, 44, 18);
        Jed[] jedi = new Jed[11];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[4]}, new double[]{800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[5]}, new double[]{500.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[10], sestavine[12], sestavine[14]}, new double[]{1000.0, 800.0, 800.0, 200.0, 400.0, 500.0, 700.0, 100.0, 300.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[5], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14]}, new double[]{600.0, 1000.0, 600.0, 500.0, 200.0, 600.0, 400.0, 1000.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{400.0, 800.0, 400.0, 100.0, 100.0, 400.0, 200.0, 300.0, 200.0, 800.0, 1000.0, 700.0, 400.0, 1000.0, 500.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{600.0, 600.0, 700.0, 500.0, 100.0, 700.0, 200.0, 100.0, 1000.0, 200.0, 600.0, 300.0, 100.0, 500.0, 300.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{300.0, 900.0, 300.0, 200.0, 600.0, 400.0, 600.0, 500.0, 300.0, 700.0, 600.0, 1000.0, 1000.0, 600.0, 200.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[7]}, new double[]{600.0, 800.0, 600.0, 100.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[5]}, new double[]{700.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{100.0, 200.0, 500.0, 500.0, 400.0, 1000.0, 100.0, 800.0, 400.0, 800.0, 100.0, 500.0, 200.0, 400.0, 400.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[7]}, new double[]{200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s9")));
    }
}

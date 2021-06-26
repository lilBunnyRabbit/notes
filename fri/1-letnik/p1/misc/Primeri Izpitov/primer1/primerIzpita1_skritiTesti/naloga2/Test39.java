public class Test39 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 300.0, 1, 44, 37);
        sestavine[1] = new Sestavina("s1", 800.0, 50, 5, 14);
        sestavine[2] = new Sestavina("s2", 800.0, 33, 27, 27);
        sestavine[3] = new Sestavina("s3", 300.0, 21, 35, 16);
        sestavine[4] = new Sestavina("s4", 900.0, 16, 21, 4);
        sestavine[5] = new Sestavina("s5", 800.0, 27, 40, 12);
        sestavine[6] = new Sestavina("s6", 700.0, 4, 50, 35);
        sestavine[7] = new Sestavina("s7", 700.0, 23, 16, 1);
        sestavine[8] = new Sestavina("s8", 300.0, 32, 31, 39);
        sestavine[9] = new Sestavina("s9", 200.0, 8, 2, 2);
        sestavine[10] = new Sestavina("s10", 500.0, 50, 30, 22);
        sestavine[11] = new Sestavina("s11", 500.0, 12, 28, 9);
        sestavine[12] = new Sestavina("s12", 700.0, 42, 35, 12);
        sestavine[13] = new Sestavina("s13", 400.0, 44, 38, 39);
        sestavine[14] = new Sestavina("s14", 800.0, 32, 30, 41);
        Jed[] jedi = new Jed[12];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[3], sestavine[4], sestavine[7], sestavine[9], sestavine[12], sestavine[13]}, new double[]{700.0, 900.0, 300.0, 900.0, 700.0, 700.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[7], sestavine[8], sestavine[12], sestavine[14]}, new double[]{300.0, 600.0, 300.0, 900.0, 100.0, 1000.0, 800.0, 700.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[2], sestavine[6], sestavine[8], sestavine[10], sestavine[13], sestavine[14]}, new double[]{1000.0, 100.0, 200.0, 400.0, 300.0, 600.0, 1000.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[4], sestavine[11]}, new double[]{200.0, 100.0, 500.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14]}, new double[]{700.0, 800.0, 200.0, 1000.0, 1000.0, 200.0, 1000.0, 100.0, 1000.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[2], sestavine[5], sestavine[8], sestavine[12], sestavine[13], sestavine[14]}, new double[]{1000.0, 800.0, 900.0, 500.0, 600.0, 500.0, 900.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14]}, new double[]{200.0, 1000.0, 1000.0, 400.0, 300.0, 100.0, 900.0, 700.0, 900.0, 900.0, 600.0, 200.0, 900.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[6], sestavine[8], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{200.0, 500.0, 800.0, 200.0, 400.0, 400.0, 700.0, 400.0, 800.0, 400.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[2], sestavine[7], sestavine[11]}, new double[]{200.0, 300.0, 500.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9], sestavine[12]}, new double[]{100.0, 900.0, 600.0, 300.0, 500.0, 1000.0, 500.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[12], sestavine[13]}, new double[]{100.0, 400.0, 500.0, 100.0, 300.0, 900.0, 400.0, 1000.0, 100.0, 100.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[5], sestavine[6], sestavine[9], sestavine[12], sestavine[13]}, new double[]{100.0, 800.0, 600.0, 100.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s2")));
    }
}

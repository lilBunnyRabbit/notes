public class Test20 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 100.0, 26, 1, 38);
        sestavine[1] = new Sestavina("s1", 800.0, 1, 11, 2);
        sestavine[2] = new Sestavina("s2", 900.0, 26, 2, 42);
        sestavine[3] = new Sestavina("s3", 600.0, 32, 25, 12);
        sestavine[4] = new Sestavina("s4", 200.0, 11, 8, 21);
        sestavine[5] = new Sestavina("s5", 300.0, 35, 50, 25);
        sestavine[6] = new Sestavina("s6", 700.0, 28, 23, 38);
        sestavine[7] = new Sestavina("s7", 900.0, 23, 15, 0);
        sestavine[8] = new Sestavina("s8", 600.0, 45, 18, 37);
        sestavine[9] = new Sestavina("s9", 300.0, 11, 17, 49);
        sestavine[10] = new Sestavina("s10", 500.0, 17, 29, 21);
        sestavine[11] = new Sestavina("s11", 800.0, 2, 29, 39);
        sestavine[12] = new Sestavina("s12", 500.0, 12, 13, 27);
        sestavine[13] = new Sestavina("s13", 800.0, 24, 13, 35);
        sestavine[14] = new Sestavina("s14", 1000.0, 9, 26, 44);
        Jed[] jedi = new Jed[13];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[4], sestavine[5], sestavine[8], sestavine[11]}, new double[]{600.0, 500.0, 700.0, 100.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{900.0, 800.0, 500.0, 500.0, 900.0, 500.0, 400.0, 400.0, 1000.0, 700.0, 1000.0, 100.0, 800.0, 200.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[7], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14]}, new double[]{700.0, 700.0, 300.0, 600.0, 300.0, 600.0, 800.0, 900.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[3], sestavine[5], sestavine[7], sestavine[10], sestavine[12], sestavine[13]}, new double[]{500.0, 800.0, 300.0, 500.0, 1000.0, 100.0, 400.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[8], sestavine[9], sestavine[11], sestavine[13]}, new double[]{300.0, 700.0, 200.0, 800.0, 1000.0, 200.0, 1000.0, 1000.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[4], sestavine[6], sestavine[7], sestavine[14]}, new double[]{200.0, 200.0, 300.0, 300.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[11], sestavine[14]}, new double[]{600.0, 1000.0, 200.0, 200.0, 400.0, 1000.0, 200.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[2], sestavine[5], sestavine[12], sestavine[13]}, new double[]{800.0, 800.0, 700.0, 900.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[3], sestavine[5], sestavine[6], sestavine[10], sestavine[11], sestavine[13]}, new double[]{500.0, 100.0, 800.0, 200.0, 800.0, 400.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{500.0, 400.0, 300.0, 300.0, 200.0, 100.0, 900.0, 500.0, 300.0, 300.0, 700.0, 600.0, 300.0, 500.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[3]}, new double[]{100.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10], sestavine[11], sestavine[13], sestavine[14]}, new double[]{900.0, 1000.0, 200.0, 100.0, 200.0, 1000.0, 500.0, 700.0, 900.0, 800.0, 1000.0, 300.0, 300.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12]}, new double[]{100.0, 100.0, 500.0, 400.0, 400.0, 400.0, 100.0, 500.0, 100.0, 500.0}, "vrsta");
        System.out.println(Math.round(jedi[11].kalorije()));
    }
}

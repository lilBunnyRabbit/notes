public class Test13 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 300.0, 19, 34, 1);
        sestavine[1] = new Sestavina("s1", 400.0, 14, 8, 34);
        sestavine[2] = new Sestavina("s2", 700.0, 28, 33, 0);
        sestavine[3] = new Sestavina("s3", 600.0, 0, 50, 21);
        sestavine[4] = new Sestavina("s4", 200.0, 43, 38, 26);
        sestavine[5] = new Sestavina("s5", 400.0, 19, 38, 41);
        sestavine[6] = new Sestavina("s6", 200.0, 0, 1, 2);
        sestavine[7] = new Sestavina("s7", 300.0, 12, 9, 16);
        sestavine[8] = new Sestavina("s8", 600.0, 1, 49, 44);
        sestavine[9] = new Sestavina("s9", 500.0, 14, 4, 25);
        sestavine[10] = new Sestavina("s10", 700.0, 21, 48, 46);
        sestavine[11] = new Sestavina("s11", 300.0, 27, 27, 7);
        sestavine[12] = new Sestavina("s12", 300.0, 42, 33, 44);
        sestavine[13] = new Sestavina("s13", 800.0, 40, 26, 45);
        sestavine[14] = new Sestavina("s14", 400.0, 43, 6, 16);
        Jed[] jedi = new Jed[11];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[2], sestavine[6], sestavine[8], sestavine[14]}, new double[]{300.0, 100.0, 100.0, 1000.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[8], sestavine[12]}, new double[]{900.0, 900.0, 700.0, 200.0, 600.0, 800.0, 1000.0, 400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{100.0, 200.0, 500.0, 400.0, 900.0, 1000.0, 200.0, 200.0, 100.0, 500.0, 900.0, 900.0, 900.0, 100.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[7], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{400.0, 600.0, 900.0, 700.0, 1000.0, 800.0, 200.0, 400.0, 900.0, 100.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10], sestavine[11]}, new double[]{1000.0, 400.0, 600.0, 1000.0, 400.0, 400.0, 400.0, 800.0, 200.0, 900.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{900.0, 600.0, 600.0, 900.0, 600.0, 900.0, 600.0, 400.0, 300.0, 1000.0, 200.0, 1000.0, 1000.0, 900.0, 800.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[9], sestavine[14]}, new double[]{900.0, 500.0, 900.0, 900.0, 200.0, 900.0, 500.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[1], sestavine[8], sestavine[9], sestavine[13], sestavine[14]}, new double[]{300.0, 500.0, 700.0, 600.0, 100.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12]}, new double[]{600.0, 800.0, 100.0, 200.0, 600.0, 300.0, 500.0, 100.0, 200.0, 800.0, 900.0, 900.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[2], sestavine[5], sestavine[6], sestavine[10], sestavine[12], sestavine[13]}, new double[]{200.0, 100.0, 600.0, 1000.0, 200.0, 600.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[4], sestavine[5], sestavine[7], sestavine[9], sestavine[10], sestavine[12], sestavine[13]}, new double[]{800.0, 200.0, 300.0, 800.0, 500.0, 700.0, 500.0}, "vrsta");
        System.out.println(Math.round(jedi[10].kalorije()));
    }
}

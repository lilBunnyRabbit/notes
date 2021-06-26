public class Test33 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[10];
        sestavine[0] = new Sestavina("s0", 200.0, 34, 29, 0);
        sestavine[1] = new Sestavina("s1", 400.0, 23, 42, 29);
        sestavine[2] = new Sestavina("s2", 300.0, 26, 38, 47);
        sestavine[3] = new Sestavina("s3", 200.0, 25, 9, 18);
        sestavine[4] = new Sestavina("s4", 800.0, 36, 6, 46);
        sestavine[5] = new Sestavina("s5", 700.0, 15, 4, 33);
        sestavine[6] = new Sestavina("s6", 1000.0, 38, 7, 11);
        sestavine[7] = new Sestavina("s7", 200.0, 15, 22, 41);
        sestavine[8] = new Sestavina("s8", 900.0, 45, 30, 2);
        sestavine[9] = new Sestavina("s9", 500.0, 0, 11, 16);
        Jed[] jedi = new Jed[9];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[8]}, new double[]{400.0, 800.0, 200.0, 800.0, 400.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[5], sestavine[6], sestavine[9]}, new double[]{500.0, 500.0, 300.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9]}, new double[]{800.0, 500.0, 200.0, 600.0, 1000.0, 400.0, 300.0, 400.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9]}, new double[]{100.0, 100.0, 300.0, 100.0, 300.0, 300.0, 300.0, 800.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[9]}, new double[]{700.0, 900.0, 400.0, 700.0, 900.0, 300.0, 600.0, 1000.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9]}, new double[]{1000.0, 400.0, 700.0, 500.0, 1000.0, 400.0, 200.0, 1000.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[9]}, new double[]{1000.0, 600.0, 300.0, 1000.0, 900.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8]}, new double[]{300.0, 400.0, 1000.0, 700.0, 1000.0, 200.0, 1000.0, 300.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[6], sestavine[7], sestavine[8]}, new double[]{100.0, 100.0, 600.0, 200.0, 200.0, 100.0, 300.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s4")));
    }
}

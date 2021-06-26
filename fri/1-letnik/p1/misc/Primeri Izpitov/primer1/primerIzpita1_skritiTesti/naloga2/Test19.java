public class Test19 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[4];
        sestavine[0] = new Sestavina("s0", 200.0, 32, 4, 0);
        sestavine[1] = new Sestavina("s1", 700.0, 32, 23, 6);
        sestavine[2] = new Sestavina("s2", 700.0, 14, 1, 29);
        sestavine[3] = new Sestavina("s3", 100.0, 12, 28, 21);
        Jed[] jedi = new Jed[18];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[1], sestavine[3]}, new double[]{300.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{300.0, 400.0, 800.0, 100.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{300.0, 200.0, 100.0, 600.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[3]}, new double[]{900.0, 1000.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1]}, new double[]{700.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0]}, new double[]{300.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{600.0, 500.0, 900.0, 200.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[3]}, new double[]{900.0, 500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3]}, new double[]{600.0, 900.0, 100.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{800.0, 300.0, 500.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[1]}, new double[]{500.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{700.0, 300.0, 800.0, 900.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3]}, new double[]{200.0, 100.0, 700.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{700.0, 200.0, 200.0, 200.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{400.0, 1000.0, 300.0, 500.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{400.0, 900.0, 1000.0, 700.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{900.0, 500.0, 100.0}, "vrsta");
        jedi[17] = new Jed("j17", new Sestavina[]{sestavine[3]}, new double[]{800.0}, "vrsta");
        System.out.println(Math.round(jedi[8].kalorije()));
    }
}

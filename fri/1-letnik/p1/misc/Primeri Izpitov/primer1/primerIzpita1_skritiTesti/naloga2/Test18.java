public class Test18 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[5];
        sestavine[0] = new Sestavina("s0", 900.0, 44, 43, 29);
        sestavine[1] = new Sestavina("s1", 600.0, 9, 15, 37);
        sestavine[2] = new Sestavina("s2", 700.0, 40, 34, 39);
        sestavine[3] = new Sestavina("s3", 600.0, 9, 32, 16);
        sestavine[4] = new Sestavina("s4", 200.0, 14, 20, 35);
        Jed[] jedi = new Jed[15];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{900.0, 700.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[3], sestavine[4]}, new double[]{100.0, 100.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{400.0, 600.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{400.0, 200.0, 200.0, 700.0, 700.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4]}, new double[]{400.0, 800.0, 900.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4]}, new double[]{700.0, 800.0, 700.0, 700.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1]}, new double[]{900.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0]}, new double[]{500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{100.0, 100.0, 700.0, 300.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4]}, new double[]{700.0, 600.0, 700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{100.0, 600.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{400.0, 200.0, 300.0, 300.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{300.0, 800.0, 500.0, 600.0, 400.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[4]}, new double[]{700.0, 600.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3]}, new double[]{800.0, 900.0, 200.0}, "vrsta");
        System.out.println(Math.round(jedi[11].kalorije()));
    }
}

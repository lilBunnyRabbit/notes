public class Test12 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[8];
        sestavine[0] = new Sestavina("s0", 600.0, 18, 50, 19);
        sestavine[1] = new Sestavina("s1", 900.0, 50, 40, 20);
        sestavine[2] = new Sestavina("s2", 300.0, 46, 28, 23);
        sestavine[3] = new Sestavina("s3", 600.0, 34, 11, 44);
        sestavine[4] = new Sestavina("s4", 200.0, 47, 39, 25);
        sestavine[5] = new Sestavina("s5", 400.0, 24, 34, 12);
        sestavine[6] = new Sestavina("s6", 900.0, 11, 28, 21);
        sestavine[7] = new Sestavina("s7", 500.0, 6, 34, 46);
        Jed[] jedi = new Jed[10];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[5]}, new double[]{500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4], sestavine[6], sestavine[7]}, new double[]{700.0, 500.0, 700.0, 600.0, 1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7]}, new double[]{500.0, 100.0, 1000.0, 100.0, 900.0, 800.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0]}, new double[]{700.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6]}, new double[]{700.0, 100.0, 900.0, 1000.0, 100.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[7]}, new double[]{900.0, 200.0, 400.0, 1000.0, 700.0, 500.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{300.0, 1000.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4]}, new double[]{700.0, 400.0, 400.0, 200.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[6]}, new double[]{100.0, 500.0, 600.0, 700.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{300.0, 200.0, 700.0, 300.0, 1000.0, 100.0, 900.0, 400.0}, "vrsta");
        System.out.println(Math.round(jedi[9].kalorije()));
    }
}

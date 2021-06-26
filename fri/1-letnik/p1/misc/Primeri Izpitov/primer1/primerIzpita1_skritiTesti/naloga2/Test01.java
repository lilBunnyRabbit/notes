public class Test01 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[8];
        sestavine[0] = new Sestavina("s0", 200.0, 8, 7, 42);
        sestavine[1] = new Sestavina("s1", 100.0, 4, 1, 0);
        sestavine[2] = new Sestavina("s2", 1000.0, 29, 4, 7);
        sestavine[3] = new Sestavina("s3", 300.0, 23, 2, 44);
        sestavine[4] = new Sestavina("s4", 200.0, 3, 15, 22);
        sestavine[5] = new Sestavina("s5", 700.0, 1, 9, 20);
        sestavine[6] = new Sestavina("s6", 500.0, 5, 2, 9);
        sestavine[7] = new Sestavina("s7", 400.0, 1, 14, 39);
        Jed[] jedi = new Jed[17];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[5]}, new double[]{100.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[7]}, new double[]{1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[3], sestavine[5], sestavine[7]}, new double[]{700.0, 200.0, 400.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{500.0, 400.0, 400.0, 400.0, 900.0, 200.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[5], sestavine[7]}, new double[]{200.0, 700.0, 600.0, 600.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7]}, new double[]{100.0, 1000.0, 1000.0, 200.0, 500.0, 700.0, 600.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[2], sestavine[5], sestavine[7]}, new double[]{400.0, 200.0, 1000.0, 600.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[2], sestavine[4], sestavine[7]}, new double[]{100.0, 300.0, 200.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[4], sestavine[6], sestavine[7]}, new double[]{100.0, 900.0, 600.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[1], sestavine[6]}, new double[]{300.0, 800.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[7]}, new double[]{900.0, 700.0, 800.0, 400.0, 600.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[2], sestavine[3], sestavine[6], sestavine[7]}, new double[]{1000.0, 200.0, 500.0, 1000.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[6]}, new double[]{900.0, 900.0, 1000.0, 700.0, 700.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{100.0, 1000.0, 800.0, 200.0, 200.0, 800.0, 900.0, 800.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[1], sestavine[3], sestavine[7]}, new double[]{100.0, 200.0, 1000.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[7]}, new double[]{100.0, 500.0, 800.0, 800.0, 700.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[6], sestavine[7]}, new double[]{1000.0, 600.0, 300.0, 100.0, 300.0, 900.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
        System.out.println(jedi[4].jeBeljakovinska());
        System.out.println(jedi[6].jeBeljakovinska());
        System.out.println(jedi[8].jeBeljakovinska());
        System.out.println(jedi[12].jeBeljakovinska());
        System.out.println(jedi[15].jeBeljakovinska());
        System.out.println(jedi[16].jeBeljakovinska());
    }
}

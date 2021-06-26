public class Test03 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[8];
        sestavine[0] = new Sestavina("s0", 300.0, 17, 15, 11);
        sestavine[1] = new Sestavina("s1", 1000.0, 38, 13, 41);
        sestavine[2] = new Sestavina("s2", 1000.0, 23, 8, 32);
        sestavine[3] = new Sestavina("s3", 100.0, 23, 8, 5);
        sestavine[4] = new Sestavina("s4", 1000.0, 36, 7, 18);
        sestavine[5] = new Sestavina("s5", 700.0, 38, 13, 13);
        sestavine[6] = new Sestavina("s6", 400.0, 2, 9, 2);
        sestavine[7] = new Sestavina("s7", 300.0, 37, 0, 30);
        Jed[] jedi = new Jed[14];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[6]}, new double[]{300.0, 100.0, 200.0, 1000.0, 400.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[2], sestavine[4], sestavine[5], sestavine[7]}, new double[]{1000.0, 600.0, 100.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[6], sestavine[7]}, new double[]{600.0, 800.0, 700.0, 500.0, 700.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[5], sestavine[6]}, new double[]{900.0, 500.0, 700.0, 200.0, 700.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{400.0, 300.0, 800.0, 200.0, 100.0, 800.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{400.0, 500.0, 100.0, 300.0, 700.0, 100.0, 700.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[2]}, new double[]{900.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[5], sestavine[7]}, new double[]{600.0, 500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{400.0, 700.0, 600.0, 500.0, 600.0, 500.0, 900.0, 600.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{100.0, 600.0, 200.0, 800.0, 200.0, 1000.0, 300.0, 800.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5], sestavine[6]}, new double[]{1000.0, 700.0, 800.0, 200.0, 600.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{100.0, 600.0, 800.0, 900.0, 500.0, 900.0, 600.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[6], sestavine[7]}, new double[]{100.0, 700.0, 1000.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[1]}, new double[]{200.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
        System.out.println(jedi[1].jeBeljakovinska());
        System.out.println(jedi[2].jeBeljakovinska());
        System.out.println(jedi[3].jeBeljakovinska());
        System.out.println(jedi[4].jeBeljakovinska());
        System.out.println(jedi[5].jeBeljakovinska());
        System.out.println(jedi[6].jeBeljakovinska());
        System.out.println(jedi[7].jeBeljakovinska());
        System.out.println(jedi[8].jeBeljakovinska());
        System.out.println(jedi[9].jeBeljakovinska());
        System.out.println(jedi[10].jeBeljakovinska());
        System.out.println(jedi[11].jeBeljakovinska());
        System.out.println(jedi[12].jeBeljakovinska());
        System.out.println(jedi[13].jeBeljakovinska());
    }
}

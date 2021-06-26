public class Test06 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[3];
        sestavine[0] = new Sestavina("s0", 900.0, 18, 11, 2);
        sestavine[1] = new Sestavina("s1", 700.0, 9, 3, 14);
        sestavine[2] = new Sestavina("s2", 200.0, 13, 1, 3);
        Jed[] jedi = new Jed[20];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{500.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[1]}, new double[]{400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{900.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{800.0, 300.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{100.0, 700.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{200.0, 800.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{900.0, 1000.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{100.0, 300.0, 800.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0]}, new double[]{500.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{500.0, 300.0, 700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{700.0, 700.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0]}, new double[]{100.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[2]}, new double[]{400.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[1]}, new double[]{900.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{400.0, 1000.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[2]}, new double[]{400.0}, "vrsta");
        jedi[16] = new Jed("j16", new Sestavina[]{sestavine[0]}, new double[]{600.0}, "vrsta");
        jedi[17] = new Jed("j17", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{700.0, 400.0}, "vrsta");
        jedi[18] = new Jed("j18", new Sestavina[]{sestavine[2]}, new double[]{800.0}, "vrsta");
        jedi[19] = new Jed("j19", new Sestavina[]{sestavine[0]}, new double[]{100.0}, "vrsta");
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
        System.out.println(jedi[14].jeBeljakovinska());
        System.out.println(jedi[15].jeBeljakovinska());
        System.out.println(jedi[16].jeBeljakovinska());
        System.out.println(jedi[17].jeBeljakovinska());
        System.out.println(jedi[19].jeBeljakovinska());
    }
}

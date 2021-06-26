public class Test09 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[3];
        sestavine[0] = new Sestavina("s0", 300.0, 43, 11, 33);
        sestavine[1] = new Sestavina("s1", 400.0, 17, 7, 18);
        sestavine[2] = new Sestavina("s2", 800.0, 27, 7, 24);
        Jed[] jedi = new Jed[10];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{1000.0, 700.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0]}, new double[]{900.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{200.0, 300.0, 600.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{400.0, 300.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[2]}, new double[]{300.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1]}, new double[]{700.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{600.0, 900.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{800.0, 500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[1]}, new double[]{500.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[2]}, new double[]{800.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
        System.out.println(jedi[1].jeBeljakovinska());
        System.out.println(jedi[3].jeBeljakovinska());
        System.out.println(jedi[4].jeBeljakovinska());
        System.out.println(jedi[5].jeBeljakovinska());
        System.out.println(jedi[8].jeBeljakovinska());
        System.out.println(jedi[9].jeBeljakovinska());
    }
}

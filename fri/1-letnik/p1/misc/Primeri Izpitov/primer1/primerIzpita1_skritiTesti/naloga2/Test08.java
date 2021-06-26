public class Test08 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[7];
        sestavine[0] = new Sestavina("s0", 600.0, 41, 15, 1);
        sestavine[1] = new Sestavina("s1", 1000.0, 3, 7, 38);
        sestavine[2] = new Sestavina("s2", 500.0, 26, 7, 0);
        sestavine[3] = new Sestavina("s3", 500.0, 17, 15, 45);
        sestavine[4] = new Sestavina("s4", 1000.0, 6, 12, 48);
        sestavine[5] = new Sestavina("s5", 300.0, 18, 2, 9);
        sestavine[6] = new Sestavina("s6", 100.0, 50, 4, 25);
        Jed[] jedi = new Jed[5];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[3]}, new double[]{800.0, 600.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[3]}, new double[]{500.0, 400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[6]}, new double[]{300.0, 900.0, 400.0, 400.0, 700.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[3], sestavine[5]}, new double[]{800.0, 400.0, 200.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[6]}, new double[]{1000.0, 700.0, 200.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
        System.out.println(jedi[2].jeBeljakovinska());
    }
}

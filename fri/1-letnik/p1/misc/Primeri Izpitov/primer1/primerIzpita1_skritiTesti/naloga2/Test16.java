public class Test16 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[6];
        sestavine[0] = new Sestavina("s0", 1000.0, 31, 39, 37);
        sestavine[1] = new Sestavina("s1", 200.0, 26, 18, 40);
        sestavine[2] = new Sestavina("s2", 200.0, 12, 9, 36);
        sestavine[3] = new Sestavina("s3", 600.0, 32, 50, 46);
        sestavine[4] = new Sestavina("s4", 300.0, 27, 44, 9);
        sestavine[5] = new Sestavina("s5", 600.0, 27, 4, 34);
        Jed[] jedi = new Jed[3];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[2]}, new double[]{100.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{100.0, 400.0, 700.0, 400.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[4]}, new double[]{1000.0}, "vrsta");
        System.out.println(Math.round(jedi[2].kalorije()));
    }
}

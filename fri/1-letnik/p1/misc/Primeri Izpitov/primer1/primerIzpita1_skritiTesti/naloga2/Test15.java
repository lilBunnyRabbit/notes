public class Test15 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[6];
        sestavine[0] = new Sestavina("s0", 300.0, 50, 44, 25);
        sestavine[1] = new Sestavina("s1", 200.0, 34, 8, 47);
        sestavine[2] = new Sestavina("s2", 700.0, 28, 15, 28);
        sestavine[3] = new Sestavina("s3", 700.0, 44, 16, 45);
        sestavine[4] = new Sestavina("s4", 500.0, 30, 25, 5);
        sestavine[5] = new Sestavina("s5", 300.0, 48, 6, 35);
        Jed[] jedi = new Jed[4];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[5]}, new double[]{700.0, 300.0, 600.0, 800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0]}, new double[]{400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[4], sestavine[5]}, new double[]{700.0, 700.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[2], sestavine[3], sestavine[5]}, new double[]{700.0, 500.0, 800.0}, "vrsta");
        System.out.println(Math.round(jedi[3].kalorije()));
    }
}

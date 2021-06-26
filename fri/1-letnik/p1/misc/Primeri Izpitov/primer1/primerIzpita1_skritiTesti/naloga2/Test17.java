public class Test17 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[5];
        sestavine[0] = new Sestavina("s0", 300.0, 36, 44, 14);
        sestavine[1] = new Sestavina("s1", 300.0, 39, 48, 41);
        sestavine[2] = new Sestavina("s2", 600.0, 3, 18, 40);
        sestavine[3] = new Sestavina("s3", 600.0, 13, 10, 36);
        sestavine[4] = new Sestavina("s4", 1000.0, 15, 2, 43);
        Jed[] jedi = new Jed[3];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{500.0, 400.0, 200.0, 900.0, 100.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{800.0, 800.0, 800.0, 800.0, 200.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4]}, new double[]{300.0, 700.0, 1000.0, 500.0}, "vrsta");
        System.out.println(Math.round(jedi[1].kalorije()));
    }
}

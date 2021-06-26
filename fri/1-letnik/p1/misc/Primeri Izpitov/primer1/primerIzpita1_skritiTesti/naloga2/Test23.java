public class Test23 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[4];
        sestavine[0] = new Sestavina("s0", 500.0, 0, 36, 4);
        sestavine[1] = new Sestavina("s1", 300.0, 18, 20, 44);
        sestavine[2] = new Sestavina("s2", 500.0, 35, 35, 17);
        sestavine[3] = new Sestavina("s3", 500.0, 17, 26, 45);
        Jed[] jedi = new Jed[4];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{200.0, 600.0, 700.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{700.0, 300.0, 600.0, 400.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{500.0, 100.0, 700.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3]}, new double[]{400.0, 500.0, 600.0, 500.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

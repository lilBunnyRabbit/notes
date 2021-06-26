public class Test24 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[3];
        sestavine[0] = new Sestavina("s0", 300.0, 17, 49, 27);
        sestavine[1] = new Sestavina("s1", 400.0, 8, 36, 41);
        sestavine[2] = new Sestavina("s2", 600.0, 46, 41, 44);
        Jed[] jedi = new Jed[14];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0]}, new double[]{700.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{400.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{700.0, 1000.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{600.0, 700.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{400.0, 400.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{800.0, 600.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[2]}, new double[]{700.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{800.0, 900.0, 500.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[1]}, new double[]{300.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[2]}, new double[]{700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{200.0, 900.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[1], sestavine[2]}, new double[]{600.0, 500.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2]}, new double[]{900.0, 700.0, 200.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{900.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

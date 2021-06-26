public class Test25 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[10];
        sestavine[0] = new Sestavina("s0", 700.0, 16, 41, 36);
        sestavine[1] = new Sestavina("s1", 700.0, 44, 30, 23);
        sestavine[2] = new Sestavina("s2", 1000.0, 18, 36, 34);
        sestavine[3] = new Sestavina("s3", 500.0, 30, 20, 1);
        sestavine[4] = new Sestavina("s4", 200.0, 4, 38, 8);
        sestavine[5] = new Sestavina("s5", 300.0, 0, 21, 18);
        sestavine[6] = new Sestavina("s6", 600.0, 30, 37, 34);
        sestavine[7] = new Sestavina("s7", 800.0, 16, 21, 34);
        sestavine[8] = new Sestavina("s8", 900.0, 40, 25, 3);
        sestavine[9] = new Sestavina("s9", 1000.0, 39, 45, 34);
        Jed[] jedi = new Jed[9];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9]}, new double[]{900.0, 300.0, 100.0, 700.0, 1000.0, 300.0, 800.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[7]}, new double[]{200.0, 500.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[8], sestavine[9]}, new double[]{800.0, 200.0, 1000.0, 100.0, 300.0, 900.0, 600.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[9]}, new double[]{400.0, 1000.0, 900.0, 300.0, 400.0, 600.0, 700.0, 1000.0, 1000.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[8], sestavine[9]}, new double[]{500.0, 1000.0, 900.0, 500.0, 600.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[4]}, new double[]{900.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[9]}, new double[]{200.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[6], sestavine[7]}, new double[]{700.0, 100.0, 500.0, 100.0, 800.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8]}, new double[]{600.0, 200.0, 200.0, 800.0, 600.0, 700.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

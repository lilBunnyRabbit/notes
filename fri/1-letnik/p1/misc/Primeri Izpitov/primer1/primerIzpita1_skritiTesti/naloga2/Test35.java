public class Test35 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[12];
        sestavine[0] = new Sestavina("s0", 200.0, 29, 32, 36);
        sestavine[1] = new Sestavina("s1", 800.0, 24, 16, 45);
        sestavine[2] = new Sestavina("s2", 900.0, 12, 11, 4);
        sestavine[3] = new Sestavina("s3", 900.0, 19, 36, 32);
        sestavine[4] = new Sestavina("s4", 100.0, 44, 14, 30);
        sestavine[5] = new Sestavina("s5", 100.0, 0, 27, 38);
        sestavine[6] = new Sestavina("s6", 900.0, 18, 5, 49);
        sestavine[7] = new Sestavina("s7", 500.0, 27, 35, 28);
        sestavine[8] = new Sestavina("s8", 700.0, 17, 48, 37);
        sestavine[9] = new Sestavina("s9", 200.0, 43, 11, 21);
        sestavine[10] = new Sestavina("s10", 100.0, 5, 44, 45);
        sestavine[11] = new Sestavina("s11", 300.0, 21, 32, 8);
        Jed[] jedi = new Jed[5];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[8]}, new double[]{1000.0, 400.0, 200.0, 1000.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10]}, new double[]{500.0, 200.0, 400.0, 900.0, 900.0, 600.0, 500.0, 600.0, 200.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[8], sestavine[9], sestavine[11]}, new double[]{400.0, 700.0, 300.0, 1000.0, 200.0, 600.0, 300.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[5], sestavine[7], sestavine[9], sestavine[10], sestavine[11]}, new double[]{1000.0, 600.0, 700.0, 300.0, 400.0, 200.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[9], sestavine[11]}, new double[]{600.0, 100.0, 900.0, 300.0, 100.0, 500.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s5")));
    }
}

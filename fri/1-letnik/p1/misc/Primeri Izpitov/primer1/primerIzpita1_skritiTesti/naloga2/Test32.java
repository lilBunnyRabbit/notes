public class Test32 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[11];
        sestavine[0] = new Sestavina("s0", 100.0, 33, 36, 26);
        sestavine[1] = new Sestavina("s1", 900.0, 19, 43, 11);
        sestavine[2] = new Sestavina("s2", 500.0, 33, 47, 23);
        sestavine[3] = new Sestavina("s3", 400.0, 26, 30, 43);
        sestavine[4] = new Sestavina("s4", 600.0, 31, 24, 8);
        sestavine[5] = new Sestavina("s5", 900.0, 6, 24, 31);
        sestavine[6] = new Sestavina("s6", 400.0, 3, 12, 38);
        sestavine[7] = new Sestavina("s7", 1000.0, 46, 4, 48);
        sestavine[8] = new Sestavina("s8", 800.0, 23, 17, 44);
        sestavine[9] = new Sestavina("s9", 600.0, 2, 50, 45);
        sestavine[10] = new Sestavina("s10", 200.0, 27, 10, 23);
        Jed[] jedi = new Jed[6];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2], sestavine[8]}, new double[]{200.0, 600.0, 700.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[2], sestavine[7]}, new double[]{500.0, 700.0, 100.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[5], sestavine[8], sestavine[10]}, new double[]{300.0, 500.0, 100.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[4], sestavine[10]}, new double[]{700.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[3], sestavine[4], sestavine[6], sestavine[8], sestavine[9]}, new double[]{400.0, 700.0, 900.0, 700.0, 400.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1], sestavine[2], sestavine[4], sestavine[6], sestavine[7], sestavine[9], sestavine[10]}, new double[]{300.0, 700.0, 1000.0, 1000.0, 300.0, 800.0, 700.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s3")));
    }
}

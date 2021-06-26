public class Test34 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[13];
        sestavine[0] = new Sestavina("s0", 700.0, 2, 19, 2);
        sestavine[1] = new Sestavina("s1", 400.0, 29, 9, 17);
        sestavine[2] = new Sestavina("s2", 100.0, 25, 14, 0);
        sestavine[3] = new Sestavina("s3", 400.0, 20, 41, 32);
        sestavine[4] = new Sestavina("s4", 400.0, 8, 35, 7);
        sestavine[5] = new Sestavina("s5", 1000.0, 9, 2, 0);
        sestavine[6] = new Sestavina("s6", 1000.0, 17, 1, 20);
        sestavine[7] = new Sestavina("s7", 300.0, 29, 48, 8);
        sestavine[8] = new Sestavina("s8", 900.0, 30, 12, 1);
        sestavine[9] = new Sestavina("s9", 300.0, 38, 0, 12);
        sestavine[10] = new Sestavina("s10", 500.0, 8, 47, 32);
        sestavine[11] = new Sestavina("s11", 900.0, 40, 7, 20);
        sestavine[12] = new Sestavina("s12", 400.0, 17, 45, 31);
        Jed[] jedi = new Jed[6];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{900.0, 400.0, 200.0, 400.0, 1000.0, 700.0, 1000.0, 600.0, 800.0, 100.0, 600.0, 900.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{1000.0, 600.0, 800.0, 400.0, 900.0, 600.0, 400.0, 1000.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{400.0, 600.0, 800.0, 400.0, 700.0, 800.0, 200.0, 100.0, 600.0, 500.0, 800.0, 600.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[4], sestavine[6], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{400.0, 200.0, 700.0, 500.0, 500.0, 1000.0, 1000.0, 100.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[3]}, new double[]{800.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[6], sestavine[7], sestavine[9], sestavine[11], sestavine[12]}, new double[]{500.0, 600.0, 1000.0, 400.0, 400.0, 200.0, 100.0, 1000.0, 1000.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s0")));
    }
}

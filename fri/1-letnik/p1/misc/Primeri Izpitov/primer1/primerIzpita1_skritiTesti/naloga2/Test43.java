public class Test43 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[16];
        sestavine[0] = new Sestavina("s0", 1000.0, 42, 13, 29);
        sestavine[1] = new Sestavina("s1", 1000.0, 4, 11, 16);
        sestavine[2] = new Sestavina("s2", 900.0, 37, 24, 46);
        sestavine[3] = new Sestavina("s3", 800.0, 28, 1, 33);
        sestavine[4] = new Sestavina("s4", 300.0, 22, 48, 44);
        sestavine[5] = new Sestavina("s5", 800.0, 23, 22, 6);
        sestavine[6] = new Sestavina("s6", 100.0, 17, 11, 47);
        sestavine[7] = new Sestavina("s7", 1000.0, 3, 32, 4);
        sestavine[8] = new Sestavina("s8", 100.0, 3, 7, 39);
        sestavine[9] = new Sestavina("s9", 500.0, 40, 12, 41);
        sestavine[10] = new Sestavina("s10", 500.0, 23, 29, 1);
        sestavine[11] = new Sestavina("s11", 600.0, 10, 27, 12);
        sestavine[12] = new Sestavina("s12", 200.0, 0, 11, 40);
        sestavine[13] = new Sestavina("s13", 700.0, 34, 43, 14);
        sestavine[14] = new Sestavina("s14", 600.0, 7, 21, 7);
        sestavine[15] = new Sestavina("s15", 400.0, 22, 18, 14);
        Jed[] jedi = new Jed[14];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[9], sestavine[13]}, new double[]{800.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[13], sestavine[14], sestavine[15]}, new double[]{700.0, 100.0, 500.0, 700.0, 300.0, 200.0, 900.0, 800.0, 600.0, 200.0, 1000.0, 900.0, 1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{300.0, 1000.0, 700.0, 700.0, 1000.0, 200.0, 900.0, 600.0, 100.0, 400.0, 200.0, 400.0, 600.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[15]}, new double[]{300.0, 800.0, 100.0, 900.0, 700.0, 900.0, 900.0, 300.0, 600.0, 500.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[12], sestavine[14], sestavine[15]}, new double[]{200.0, 600.0, 1000.0, 500.0, 1000.0, 900.0, 100.0, 500.0, 100.0, 700.0, 200.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{800.0, 900.0, 600.0, 500.0, 600.0, 1000.0, 600.0, 600.0, 1000.0, 300.0, 600.0, 600.0, 800.0, 800.0, 700.0, 700.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[12], sestavine[14]}, new double[]{1000.0, 400.0, 800.0, 700.0, 500.0, 400.0, 500.0, 900.0, 900.0, 100.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{500.0, 1000.0, 1000.0, 400.0, 600.0, 200.0, 400.0, 100.0, 200.0, 500.0, 300.0, 300.0, 300.0, 500.0, 700.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[6], sestavine[10], sestavine[13]}, new double[]{400.0, 500.0, 500.0, 900.0, 300.0, 900.0, 1000.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{500.0, 900.0, 900.0, 700.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[5], sestavine[13]}, new double[]{900.0, 400.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{600.0, 900.0, 100.0, 800.0, 700.0, 400.0, 900.0, 300.0, 300.0, 500.0, 800.0, 300.0, 700.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15]}, new double[]{1000.0, 1000.0, 300.0, 100.0, 200.0, 300.0, 900.0, 300.0, 100.0, 500.0, 800.0, 1000.0, 800.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15]}, new double[]{600.0, 700.0, 400.0, 100.0, 400.0, 1000.0, 100.0, 700.0, 500.0, 200.0, 400.0, 100.0, 100.0, 600.0, 100.0, 400.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

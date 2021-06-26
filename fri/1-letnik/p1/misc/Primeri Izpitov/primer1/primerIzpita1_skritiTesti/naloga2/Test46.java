public class Test46 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 100.0, 11, 7, 30);
        sestavine[1] = new Sestavina("s1", 600.0, 11, 47, 26);
        sestavine[2] = new Sestavina("s2", 300.0, 23, 24, 3);
        sestavine[3] = new Sestavina("s3", 100.0, 44, 15, 0);
        sestavine[4] = new Sestavina("s4", 900.0, 30, 42, 9);
        sestavine[5] = new Sestavina("s5", 1000.0, 27, 30, 9);
        sestavine[6] = new Sestavina("s6", 300.0, 41, 30, 6);
        sestavine[7] = new Sestavina("s7", 400.0, 13, 16, 18);
        sestavine[8] = new Sestavina("s8", 700.0, 32, 0, 2);
        sestavine[9] = new Sestavina("s9", 600.0, 31, 40, 34);
        sestavine[10] = new Sestavina("s10", 900.0, 21, 3, 0);
        sestavine[11] = new Sestavina("s11", 200.0, 42, 29, 24);
        sestavine[12] = new Sestavina("s12", 900.0, 12, 12, 50);
        sestavine[13] = new Sestavina("s13", 100.0, 1, 37, 20);
        sestavine[14] = new Sestavina("s14", 800.0, 19, 27, 4);
        Jed[] jedi = new Jed[15];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{800.0, 700.0, 800.0, 100.0, 700.0, 700.0, 800.0, 400.0, 500.0, 700.0, 500.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[3], sestavine[5], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{800.0, 900.0, 200.0, 200.0, 700.0, 900.0, 100.0, 100.0, 200.0, 500.0, 900.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[2], sestavine[7], sestavine[8]}, new double[]{400.0, 1000.0, 800.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{400.0, 1000.0, 200.0, 800.0, 600.0, 600.0, 500.0, 100.0, 500.0, 600.0, 200.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[8], sestavine[10], sestavine[13]}, new double[]{500.0, 300.0, 700.0, 400.0, 700.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[13], sestavine[14]}, new double[]{800.0, 500.0, 900.0, 100.0, 400.0, 600.0, 600.0, 600.0, 300.0, 700.0, 200.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{600.0, 400.0, 1000.0, 600.0, 200.0, 800.0, 900.0, 100.0, 300.0, 500.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9]}, new double[]{400.0, 300.0, 500.0, 400.0, 900.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{1000.0, 300.0, 300.0, 700.0, 100.0, 700.0, 700.0, 900.0, 600.0, 600.0, 600.0, 800.0, 1000.0, 700.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{600.0, 100.0, 500.0, 800.0, 400.0, 800.0, 300.0, 300.0, 1000.0, 600.0, 600.0, 400.0, 700.0, 800.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{300.0, 900.0, 300.0, 300.0, 900.0, 700.0, 500.0, 300.0, 900.0, 200.0, 700.0, 100.0, 200.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[12], sestavine[13], sestavine[14]}, new double[]{900.0, 900.0, 300.0, 1000.0, 500.0, 300.0, 700.0, 1000.0, 500.0, 300.0, 900.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[9], sestavine[10], sestavine[12], sestavine[13]}, new double[]{800.0, 100.0, 100.0, 600.0, 200.0, 800.0, 1000.0, 700.0, 800.0, 600.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[14]}, new double[]{500.0, 900.0, 400.0, 800.0, 1000.0, 800.0, 400.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13]}, new double[]{200.0, 800.0, 300.0, 600.0, 900.0, 300.0, 600.0, 400.0, 600.0, 500.0, 500.0, 500.0, 300.0, 100.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

public class Test45 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[12];
        sestavine[0] = new Sestavina("s0", 200.0, 42, 42, 38);
        sestavine[1] = new Sestavina("s1", 700.0, 31, 14, 39);
        sestavine[2] = new Sestavina("s2", 400.0, 16, 23, 43);
        sestavine[3] = new Sestavina("s3", 900.0, 36, 42, 15);
        sestavine[4] = new Sestavina("s4", 600.0, 15, 12, 29);
        sestavine[5] = new Sestavina("s5", 800.0, 25, 19, 3);
        sestavine[6] = new Sestavina("s6", 900.0, 43, 36, 33);
        sestavine[7] = new Sestavina("s7", 600.0, 17, 0, 28);
        sestavine[8] = new Sestavina("s8", 400.0, 43, 0, 36);
        sestavine[9] = new Sestavina("s9", 1000.0, 16, 37, 7);
        sestavine[10] = new Sestavina("s10", 600.0, 6, 17, 12);
        sestavine[11] = new Sestavina("s11", 200.0, 39, 19, 24);
        Jed[] jedi = new Jed[9];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[7], sestavine[10]}, new double[]{600.0, 300.0, 800.0, 800.0, 100.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11]}, new double[]{500.0, 700.0, 300.0, 300.0, 500.0, 900.0, 200.0, 300.0, 400.0, 700.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[5], sestavine[6], sestavine[10]}, new double[]{600.0, 100.0, 400.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[3], sestavine[5], sestavine[7], sestavine[8]}, new double[]{400.0, 700.0, 800.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[3]}, new double[]{100.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[4], sestavine[5], sestavine[7], sestavine[11]}, new double[]{900.0, 200.0, 300.0, 200.0, 600.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[11]}, new double[]{300.0, 600.0, 700.0, 1000.0, 500.0, 400.0, 200.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11]}, new double[]{400.0, 100.0, 100.0, 100.0, 100.0, 500.0, 600.0, 900.0, 700.0, 600.0, 1000.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11]}, new double[]{1000.0, 700.0, 100.0, 700.0, 700.0, 400.0, 100.0, 100.0, 900.0, 900.0, 700.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

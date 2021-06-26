public class Test41 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[15];
        sestavine[0] = new Sestavina("s0", 400.0, 43, 23, 42);
        sestavine[1] = new Sestavina("s1", 200.0, 40, 15, 7);
        sestavine[2] = new Sestavina("s2", 100.0, 24, 19, 39);
        sestavine[3] = new Sestavina("s3", 800.0, 33, 33, 5);
        sestavine[4] = new Sestavina("s4", 900.0, 17, 26, 43);
        sestavine[5] = new Sestavina("s5", 1000.0, 0, 5, 24);
        sestavine[6] = new Sestavina("s6", 400.0, 26, 39, 3);
        sestavine[7] = new Sestavina("s7", 900.0, 3, 18, 10);
        sestavine[8] = new Sestavina("s8", 400.0, 25, 27, 36);
        sestavine[9] = new Sestavina("s9", 600.0, 0, 23, 1);
        sestavine[10] = new Sestavina("s10", 1000.0, 48, 16, 11);
        sestavine[11] = new Sestavina("s11", 1000.0, 0, 21, 43);
        sestavine[12] = new Sestavina("s12", 700.0, 29, 0, 35);
        sestavine[13] = new Sestavina("s13", 600.0, 35, 45, 27);
        sestavine[14] = new Sestavina("s14", 900.0, 31, 22, 9);
        Jed[] jedi = new Jed[8];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[2], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[14]}, new double[]{300.0, 500.0, 400.0, 400.0, 600.0, 800.0, 500.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[6], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14]}, new double[]{900.0, 200.0, 600.0, 500.0, 600.0, 300.0, 500.0, 300.0, 400.0, 700.0, 300.0, 600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[5], sestavine[9], sestavine[11], sestavine[12], sestavine[13]}, new double[]{600.0, 900.0, 800.0, 300.0, 200.0, 500.0, 600.0, 800.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[5], sestavine[10], sestavine[13]}, new double[]{700.0, 600.0, 100.0, 600.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[4], sestavine[6], sestavine[7], sestavine[8], sestavine[11], sestavine[12], sestavine[13]}, new double[]{1000.0, 900.0, 300.0, 400.0, 1000.0, 700.0, 300.0, 900.0, 100.0, 200.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[3], sestavine[5], sestavine[6], sestavine[12]}, new double[]{300.0, 500.0, 600.0, 400.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[3]}, new double[]{900.0, 800.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[6], sestavine[7], sestavine[10], sestavine[11], sestavine[13]}, new double[]{900.0, 100.0, 500.0, 800.0, 300.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

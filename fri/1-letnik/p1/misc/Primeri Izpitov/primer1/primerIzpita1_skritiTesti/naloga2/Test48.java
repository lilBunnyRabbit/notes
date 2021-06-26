public class Test48 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[2];
        sestavine[0] = new Sestavina("s0", 900.0, 30, 28, 25);
        sestavine[1] = new Sestavina("s1", 900.0, 22, 2, 5);
        Jed[] jedi = new Jed[16];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[1]}, new double[]{600.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0]}, new double[]{1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{500.0, 200.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{400.0, 800.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{100.0, 400.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1]}, new double[]{100.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{800.0, 1000.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{900.0, 900.0}, "vrsta");
        jedi[8] = new Jed("j8", new Sestavina[]{sestavine[1]}, new double[]{500.0}, "vrsta");
        jedi[9] = new Jed("j9", new Sestavina[]{sestavine[0]}, new double[]{900.0}, "vrsta");
        jedi[10] = new Jed("j10", new Sestavina[]{sestavine[1]}, new double[]{700.0}, "vrsta");
        jedi[11] = new Jed("j11", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{900.0, 600.0}, "vrsta");
        jedi[12] = new Jed("j12", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{400.0, 300.0}, "vrsta");
        jedi[13] = new Jed("j13", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{500.0, 800.0}, "vrsta");
        jedi[14] = new Jed("j14", new Sestavina[]{sestavine[0]}, new double[]{100.0}, "vrsta");
        jedi[15] = new Jed("j15", new Sestavina[]{sestavine[0]}, new double[]{900.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

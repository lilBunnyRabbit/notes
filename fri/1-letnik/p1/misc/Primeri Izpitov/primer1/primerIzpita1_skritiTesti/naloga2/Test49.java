public class Test49 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[2];
        sestavine[0] = new Sestavina("s0", 400.0, 24, 36, 29);
        sestavine[1] = new Sestavina("s1", 700.0, 13, 3, 46);
        Jed[] jedi = new Jed[8];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0]}, new double[]{600.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{500.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1]}, new double[]{500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1]}, new double[]{200.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{200.0, 800.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{500.0, 100.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{100.0, 1000.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0], sestavine[1]}, new double[]{400.0, 500.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

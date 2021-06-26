public class Test50 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[6];
        sestavine[0] = new Sestavina("s0", 300.0, 19, 3, 46);
        sestavine[1] = new Sestavina("s1", 400.0, 25, 15, 36);
        sestavine[2] = new Sestavina("s2", 1000.0, 38, 44, 40);
        sestavine[3] = new Sestavina("s3", 600.0, 40, 17, 23);
        sestavine[4] = new Sestavina("s4", 500.0, 10, 16, 22);
        sestavine[5] = new Sestavina("s5", 100.0, 43, 29, 17);
        Jed[] jedi = new Jed[6];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5]}, new double[]{500.0, 1000.0, 500.0, 300.0, 300.0, 600.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[2]}, new double[]{600.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5]}, new double[]{200.0, 500.0, 1000.0, 200.0, 900.0, 500.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[5]}, new double[]{400.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0]}, new double[]{300.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[1]}, new double[]{100.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

public class Test42 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[9];
        sestavine[0] = new Sestavina("s0", 200.0, 33, 13, 31);
        sestavine[1] = new Sestavina("s1", 300.0, 29, 37, 44);
        sestavine[2] = new Sestavina("s2", 500.0, 8, 35, 14);
        sestavine[3] = new Sestavina("s3", 800.0, 7, 39, 17);
        sestavine[4] = new Sestavina("s4", 400.0, 40, 30, 2);
        sestavine[5] = new Sestavina("s5", 300.0, 29, 14, 6);
        sestavine[6] = new Sestavina("s6", 800.0, 22, 2, 39);
        sestavine[7] = new Sestavina("s7", 800.0, 43, 14, 10);
        sestavine[8] = new Sestavina("s8", 600.0, 23, 26, 41);
        Jed[] jedi = new Jed[1];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[7], sestavine[8]}, new double[]{600.0, 400.0, 400.0, 200.0, 500.0, 800.0, 200.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

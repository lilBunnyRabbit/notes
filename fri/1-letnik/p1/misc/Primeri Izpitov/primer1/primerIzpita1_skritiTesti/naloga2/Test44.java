public class Test44 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[16];
        sestavine[0] = new Sestavina("s0", 600.0, 46, 17, 22);
        sestavine[1] = new Sestavina("s1", 900.0, 0, 49, 33);
        sestavine[2] = new Sestavina("s2", 800.0, 47, 18, 40);
        sestavine[3] = new Sestavina("s3", 700.0, 29, 37, 43);
        sestavine[4] = new Sestavina("s4", 400.0, 4, 10, 17);
        sestavine[5] = new Sestavina("s5", 900.0, 7, 8, 39);
        sestavine[6] = new Sestavina("s6", 600.0, 37, 40, 25);
        sestavine[7] = new Sestavina("s7", 400.0, 2, 24, 31);
        sestavine[8] = new Sestavina("s8", 500.0, 34, 8, 50);
        sestavine[9] = new Sestavina("s9", 500.0, 23, 24, 7);
        sestavine[10] = new Sestavina("s10", 900.0, 34, 34, 7);
        sestavine[11] = new Sestavina("s11", 1000.0, 24, 41, 46);
        sestavine[12] = new Sestavina("s12", 800.0, 21, 10, 35);
        sestavine[13] = new Sestavina("s13", 100.0, 31, 33, 37);
        sestavine[14] = new Sestavina("s14", 800.0, 2, 45, 22);
        sestavine[15] = new Sestavina("s15", 600.0, 13, 3, 28);
        Jed[] jedi = new Jed[1];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[4], sestavine[9]}, new double[]{900.0, 1000.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        Primerjalnik primerjalnik = new PrimerjalnikBK();
        obrok.urediJedi(primerjalnik);
        for (Jed jed: obrok.vrniJedi()) {
            System.out.println(jed.vrniNaziv());
        }
    }
}

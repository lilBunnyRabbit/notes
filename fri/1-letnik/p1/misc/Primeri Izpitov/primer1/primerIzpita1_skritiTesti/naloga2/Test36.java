public class Test36 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[11];
        sestavine[0] = new Sestavina("s0", 600.0, 44, 46, 43);
        sestavine[1] = new Sestavina("s1", 200.0, 17, 3, 20);
        sestavine[2] = new Sestavina("s2", 400.0, 41, 0, 11);
        sestavine[3] = new Sestavina("s3", 600.0, 44, 26, 10);
        sestavine[4] = new Sestavina("s4", 600.0, 24, 14, 46);
        sestavine[5] = new Sestavina("s5", 400.0, 37, 50, 17);
        sestavine[6] = new Sestavina("s6", 600.0, 15, 22, 4);
        sestavine[7] = new Sestavina("s7", 200.0, 41, 48, 28);
        sestavine[8] = new Sestavina("s8", 900.0, 30, 19, 50);
        sestavine[9] = new Sestavina("s9", 500.0, 44, 21, 12);
        sestavine[10] = new Sestavina("s10", 100.0, 26, 20, 14);
        Jed[] jedi = new Jed[4];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[3], sestavine[5], sestavine[7]}, new double[]{900.0, 1000.0, 100.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8]}, new double[]{600.0, 700.0, 500.0, 400.0, 600.0, 1000.0, 500.0, 800.0, 300.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10]}, new double[]{200.0, 600.0, 100.0, 200.0, 900.0, 700.0, 800.0, 500.0, 1000.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[2]}, new double[]{1000.0, 900.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s10")));
    }
}

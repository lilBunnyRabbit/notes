public class Test37 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[8];
        sestavine[0] = new Sestavina("s0", 800.0, 35, 11, 25);
        sestavine[1] = new Sestavina("s1", 100.0, 5, 17, 13);
        sestavine[2] = new Sestavina("s2", 200.0, 20, 6, 17);
        sestavine[3] = new Sestavina("s3", 100.0, 10, 17, 32);
        sestavine[4] = new Sestavina("s4", 700.0, 26, 16, 14);
        sestavine[5] = new Sestavina("s5", 800.0, 14, 4, 9);
        sestavine[6] = new Sestavina("s6", 300.0, 27, 10, 6);
        sestavine[7] = new Sestavina("s7", 700.0, 6, 16, 49);
        Jed[] jedi = new Jed[1];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[4], sestavine[5], sestavine[6], sestavine[7]}, new double[]{700.0, 700.0, 900.0, 500.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s2")));
    }
}

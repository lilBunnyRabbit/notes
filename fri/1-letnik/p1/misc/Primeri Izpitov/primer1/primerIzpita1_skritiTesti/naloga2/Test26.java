public class Test26 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[11];
        sestavine[0] = new Sestavina("s0", 600.0, 21, 39, 0);
        sestavine[1] = new Sestavina("s1", 300.0, 42, 47, 21);
        sestavine[2] = new Sestavina("s2", 1000.0, 35, 24, 24);
        sestavine[3] = new Sestavina("s3", 200.0, 41, 31, 23);
        sestavine[4] = new Sestavina("s4", 200.0, 11, 35, 8);
        sestavine[5] = new Sestavina("s5", 100.0, 31, 45, 2);
        sestavine[6] = new Sestavina("s6", 800.0, 13, 39, 19);
        sestavine[7] = new Sestavina("s7", 1000.0, 42, 22, 0);
        sestavine[8] = new Sestavina("s8", 1000.0, 5, 49, 43);
        sestavine[9] = new Sestavina("s9", 100.0, 47, 24, 32);
        sestavine[10] = new Sestavina("s10", 1000.0, 42, 47, 20);
        Jed[] jedi = new Jed[1];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[7], sestavine[8], sestavine[9], sestavine[10]}, new double[]{600.0, 100.0, 900.0, 500.0, 1000.0, 700.0, 100.0, 1000.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

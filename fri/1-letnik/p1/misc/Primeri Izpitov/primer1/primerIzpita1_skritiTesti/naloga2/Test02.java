public class Test02 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[13];
        sestavine[0] = new Sestavina("s0", 900.0, 41, 15, 13);
        sestavine[1] = new Sestavina("s1", 500.0, 4, 1, 50);
        sestavine[2] = new Sestavina("s2", 800.0, 25, 8, 40);
        sestavine[3] = new Sestavina("s3", 1000.0, 20, 13, 34);
        sestavine[4] = new Sestavina("s4", 100.0, 26, 8, 48);
        sestavine[5] = new Sestavina("s5", 300.0, 28, 6, 15);
        sestavine[6] = new Sestavina("s6", 700.0, 6, 5, 1);
        sestavine[7] = new Sestavina("s7", 200.0, 27, 14, 13);
        sestavine[8] = new Sestavina("s8", 400.0, 3, 13, 45);
        sestavine[9] = new Sestavina("s9", 100.0, 39, 5, 23);
        sestavine[10] = new Sestavina("s10", 500.0, 17, 1, 47);
        sestavine[11] = new Sestavina("s11", 700.0, 14, 4, 28);
        sestavine[12] = new Sestavina("s12", 700.0, 20, 9, 48);
        Jed[] jedi = new Jed[6];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{200.0, 100.0, 700.0, 200.0, 1000.0, 1000.0, 700.0, 400.0, 200.0, 900.0, 600.0, 700.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[12]}, new double[]{1000.0, 300.0, 100.0, 1000.0, 400.0, 900.0, 100.0, 900.0, 1000.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[1], sestavine[5], sestavine[8], sestavine[12]}, new double[]{400.0, 500.0, 500.0, 900.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12]}, new double[]{700.0, 300.0, 1000.0, 600.0, 600.0, 600.0, 200.0, 600.0, 800.0, 400.0, 700.0, 200.0, 300.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[9], sestavine[10]}, new double[]{200.0, 1000.0, 700.0, 900.0, 400.0, 600.0, 100.0, 200.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[2], sestavine[6], sestavine[7], sestavine[9], sestavine[11]}, new double[]{100.0, 100.0, 800.0, 1000.0, 600.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
        System.out.println(jedi[1].jeBeljakovinska());
        System.out.println(jedi[3].jeBeljakovinska());
        System.out.println(jedi[4].jeBeljakovinska());
    }
}

public class Test40 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[19];
        sestavine[0] = new Sestavina("s0", 100.0, 3, 46, 30);
        sestavine[1] = new Sestavina("s1", 900.0, 24, 50, 44);
        sestavine[2] = new Sestavina("s2", 300.0, 19, 7, 7);
        sestavine[3] = new Sestavina("s3", 400.0, 0, 20, 26);
        sestavine[4] = new Sestavina("s4", 900.0, 14, 29, 9);
        sestavine[5] = new Sestavina("s5", 700.0, 32, 20, 37);
        sestavine[6] = new Sestavina("s6", 200.0, 29, 0, 5);
        sestavine[7] = new Sestavina("s7", 800.0, 14, 31, 35);
        sestavine[8] = new Sestavina("s8", 300.0, 36, 10, 16);
        sestavine[9] = new Sestavina("s9", 200.0, 16, 19, 6);
        sestavine[10] = new Sestavina("s10", 500.0, 4, 20, 4);
        sestavine[11] = new Sestavina("s11", 100.0, 6, 7, 18);
        sestavine[12] = new Sestavina("s12", 900.0, 13, 20, 23);
        sestavine[13] = new Sestavina("s13", 200.0, 33, 43, 15);
        sestavine[14] = new Sestavina("s14", 300.0, 38, 16, 25);
        sestavine[15] = new Sestavina("s15", 100.0, 10, 25, 49);
        sestavine[16] = new Sestavina("s16", 100.0, 50, 23, 14);
        sestavine[17] = new Sestavina("s17", 200.0, 18, 32, 1);
        sestavine[18] = new Sestavina("s18", 300.0, 20, 46, 10);
        Jed[] jedi = new Jed[7];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[2], sestavine[6], sestavine[12], sestavine[16]}, new double[]{100.0, 200.0, 700.0, 200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[17], sestavine[18]}, new double[]{1000.0, 800.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[15], sestavine[16], sestavine[17], sestavine[18]}, new double[]{500.0, 500.0, 400.0, 900.0, 500.0, 200.0, 900.0, 200.0, 500.0, 1000.0, 100.0, 700.0, 700.0, 600.0, 1000.0, 900.0, 400.0, 100.0, 100.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[1], sestavine[2], sestavine[3], sestavine[5], sestavine[6], sestavine[9], sestavine[10], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{500.0, 500.0, 500.0, 500.0, 400.0, 400.0, 900.0, 700.0, 600.0, 800.0, 300.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[1], sestavine[3], sestavine[4], sestavine[5], sestavine[6], sestavine[7], sestavine[8], sestavine[9], sestavine[10], sestavine[11], sestavine[12], sestavine[13], sestavine[14], sestavine[16], sestavine[18]}, new double[]{900.0, 400.0, 600.0, 400.0, 700.0, 1000.0, 300.0, 500.0, 400.0, 400.0, 200.0, 700.0, 700.0, 500.0, 600.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0], sestavine[1], sestavine[4], sestavine[8], sestavine[12], sestavine[13], sestavine[16]}, new double[]{100.0, 300.0, 900.0, 200.0, 200.0, 700.0, 300.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0], sestavine[1], sestavine[2], sestavine[3], sestavine[6], sestavine[8], sestavine[10], sestavine[11], sestavine[12], sestavine[14], sestavine[15], sestavine[16], sestavine[17]}, new double[]{200.0, 200.0, 700.0, 800.0, 1000.0, 100.0, 200.0, 800.0, 800.0, 400.0, 700.0, 900.0, 1000.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(Math.round(obrok.masaSestavine("s4")));
    }
}

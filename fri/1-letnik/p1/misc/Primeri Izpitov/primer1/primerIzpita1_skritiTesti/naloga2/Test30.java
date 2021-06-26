public class Test30 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[1];
        sestavine[0] = new Sestavina("s0", 100.0, 7, 5, 0);
        Jed[] jedi = new Jed[8];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0]}, new double[]{600.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0]}, new double[]{500.0}, "vrsta");
        jedi[2] = new Jed("j2", new Sestavina[]{sestavine[0]}, new double[]{900.0}, "vrsta");
        jedi[3] = new Jed("j3", new Sestavina[]{sestavine[0]}, new double[]{100.0}, "vrsta");
        jedi[4] = new Jed("j4", new Sestavina[]{sestavine[0]}, new double[]{100.0}, "vrsta");
        jedi[5] = new Jed("j5", new Sestavina[]{sestavine[0]}, new double[]{300.0}, "vrsta");
        jedi[6] = new Jed("j6", new Sestavina[]{sestavine[0]}, new double[]{700.0}, "vrsta");
        jedi[7] = new Jed("j7", new Sestavina[]{sestavine[0]}, new double[]{1000.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

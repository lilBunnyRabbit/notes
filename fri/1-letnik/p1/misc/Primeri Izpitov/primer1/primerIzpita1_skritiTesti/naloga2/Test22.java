public class Test22 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[1];
        sestavine[0] = new Sestavina("s0", 900.0, 34, 30, 28);
        Jed[] jedi = new Jed[2];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0]}, new double[]{200.0}, "vrsta");
        jedi[1] = new Jed("j1", new Sestavina[]{sestavine[0]}, new double[]{600.0}, "vrsta");
        Obrok obrok = new Obrok(jedi);
        System.out.println(obrok.indeksNajboljKaloricneBeljakovinske());
    }
}

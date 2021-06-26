public class Test10 {
    public static void main(String[] args) {
        Sestavina[] sestavine = new Sestavina[1];
        sestavine[0] = new Sestavina("s0", 100.0, 27, 6, 31);
        Jed[] jedi = new Jed[1];
        jedi[0] = new Jed("j0", new Sestavina[]{sestavine[0]}, new double[]{900.0}, "vrsta");
        System.out.println(jedi[0].jeBeljakovinska());
    }
}

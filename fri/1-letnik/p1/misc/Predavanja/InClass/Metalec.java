import java.util.Scanner;

class Metalec extends Atlet {
    private double[] dolzineMetov;
    public Metalec (int startnaSt, String priimek, String ime, String klub) {
        super(startnaSt priimek, ime, klub);
        dolzine metov = new double[6];
    }

    @Override
    public void beriRezultat(Scanner sc) {
        for (int i = 0; i < dolzineMetov.length; i++) {
            dolzineMetov[i] = sc.nextDouble();
        }
    }

    @Override
    public boolean jeBoljsi(Atlet a) {
        if(a == this) {
            return false;
        }

        if (a==null || this.getClass() != a.getClass()) {
            return false;
        }

        Metalec m = (Metalec)a;
        return this.najdalsiMet() > m.najdalsiMet();
    }

    public double najdlajsiMet() {
        double max = dolzineMetov[0];
        for (int i = 0; i < dolzineMetov.length; i++) {
            if (dolzineMetov[i] > max) {
                max = dolzineMetov[i];
            }
        }
        return max;
    }

    @Override
    public String 
}
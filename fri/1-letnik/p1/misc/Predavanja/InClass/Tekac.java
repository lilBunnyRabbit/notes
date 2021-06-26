import java.util.Scanner;

class tekac extends Atlet{
    private int ure, minute, sekunde, stotinke;

    public Tekac(int startnaSt, String priimek, String ime, String klub){
        super(startnaSt, priimek, ime, klub)
    }

    @Override
    public void beriRezultat (Scanner sc) {
        ure = sc.nextInt();
        minute = sc.nextInt();
        sekunde = sc.nextInt();
        stotinke = sc.nextInt();
    }

    @Override
    public boolean jeBoljsi(Atlet a) {
        if (a == this) {
            return false;
        }

        if(a == null || !(a instanceof Tekac)) {
            return false;
        }

        Tekac t = (Tekac)a;
        return this.CasSek() < t.casSek();
    }
}
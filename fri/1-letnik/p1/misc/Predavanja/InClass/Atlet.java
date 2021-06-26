import java.util.Scanner;

public abstract class Atlet{
  private int startnaSt;
  private String priimek, ime;
  private String klub;

  public Atlet(int startnaSt, String priimek, String ime, String klub){
    this.startnaSt = startnaSt;
    this.priimek = priimek;
    this.ime = ime;
    this.klub = klub;
  }

  public abstract void beriRezultat(Scanner sc);

  public abstract boolean jeBoljsi(Atlet a);

  @Override
  public String toString(){
    return String.format("%d %s %s %s", this.startnaSt, this.priimek, this.ime, this.klub);
  }
}

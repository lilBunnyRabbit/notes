import java.util.*;

class LEON{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> dokument = new ArrayList<String>();
    ArrayList<Ukaz> zgodovina = new ArrayList<Ukaz>();
    ArrayList<Ukaz> prihodnost = new ArrayList<Ukaz>();
    int cena = 0;
    Boolean exit = false;
    int undo_i = 0;
    int redo_i = 0;

    while(sc.hasNext()){
      String inp = sc.next();
      try{
      switch(inp){
        case "#":
          String niz1 = sc.next();
          Plus temp1 = new Plus(dokument.size(), niz1);
          cena += temp1.cena(dokument.size());
          temp1.start(dokument);
          zgodovina.add(temp1);
          redo_i = prihodnost.size();
          undo_i = zgodovina.size();
          break;
        case "+":
          int indeks2 = sc.nextInt();
          String niz2 = sc.next();
          Plus temp2 = new Plus(indeks2, niz2);
          cena += temp2.cena(dokument.size());
          temp2.start(dokument);
          zgodovina.add(temp2);
          redo_i = prihodnost.size();
          undo_i = zgodovina.size();
          break;
        case "-":
          int indeks3 = sc.nextInt();
          String niz3 = dokument.get(indeks3);
          Minus temp3 = new Minus(indeks3, niz3);
          cena += temp3.cena(dokument.size());
          temp3.start(dokument);
          zgodovina.add(temp3);
          redo_i = prihodnost.size();
          undo_i = zgodovina.size();
          break;
        case "<":
          undo_i--;
          cena+=zgodovina.get(undo_i).undo(dokument);
          prihodnost.add(zgodovina.get(undo_i));
          zgodovina.remove(undo_i);
          redo_i = prihodnost.size();
          break;
        case ">":
          redo_i--;
          cena += prihodnost.get(redo_i).cena(dokument.size());
          prihodnost.get(redo_i).start(dokument);
          zgodovina.add(prihodnost.get(redo_i));
          undo_i = zgodovina.size();
          break;
        case "x":
          exit = true;
          break;
      }
    }catch (Exception e){}
      if(exit){
        break;
      }
      System.out.printf("%d | ", cena);
      for(int i = 0; i < dokument.size()-1; i++){
        System.out.print(dokument.get(i) + "/");
      }
      if(dokument.size() > 0){
        System.out.println(dokument.get(dokument.size()-1));
      }else{
        System.out.println();
      }
    }

  }
}

abstract class Ukaz{
  protected int indeks;
  protected String niz;
  public Ukaz(int indeks, String niz){
    this.indeks = indeks;
    this.niz = niz;
  }
  public abstract int cena(int dolzina);

  public abstract void start(ArrayList<String> dokument);

  public abstract int undo(ArrayList<String> dokument);
}

class Plus extends Ukaz{
  public Plus(int indeks, String niz){
    super(indeks, niz);
  }

  @Override
  public int cena(int dolzina){
    return 2*(dolzina-this.indeks)+ this.niz.length();
  }

  @Override
  public void start(ArrayList<String> dokument){
    dokument.add(this.indeks, this.niz);
  }

  @Override
  public int undo(ArrayList<String> dokument){
    int cena = 3*(dokument.size()-1-this.indeks)+ 2*this.niz.length();
    dokument.remove(this.indeks);
    return cena;
  }
}


class Minus extends Ukaz{
  public Minus(int indeks, String niz){
    super(indeks, niz);
  }

  @Override
  public int cena(int dolzina){
    return 3*(dolzina-1-this.indeks)+ 2*this.niz.length();
  }

  @Override
  public void start(ArrayList<String> dokument){
    dokument.remove(indeks);
  }

  @Override
  public int undo(ArrayList<String> dokument){
    int cena = 2*(dokument.size()-this.indeks)+ this.niz.length();
    dokument.add(this.indeks, this.niz);
    return cena;
  }
}

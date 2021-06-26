import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class DN01{
	public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);

        // Pridobitev podatkov

        int stPeriod = sc.nextInt();
        int valovnaDolzina = sc.nextInt();
        int amplituda = sc.nextInt();
        int fazniZamik = sc.nextInt();

        // Definiranje ustreznih Listov

        List<Integer> baza = new ArrayList<Integer>();
        List<Character> zgornja = new ArrayList<Character>();
        List<Character> srednja = new ArrayList<Character>();
        List<Character> spodnja = new ArrayList<Character>();

        // Izracun sirine celotnega izpisa in potrebno stevilo '-'

        int stMinusov = (valovnaDolzina / 2) - 1;

        // Definiranje characterjev

        char presledek = ' ';
        char plus = '+';
        char minus = '-';
        char crtica = '|';

        /*
            Dodajanje vrednosti v bazni list
            0 za '-' v prvi vrstici
            1 za '+' v prvi in zadnji vrstici in '|' za vrstice med njima
            2 za '-' v zadnji vrstici
        */

        for(int per = 0; per < stPeriod; per++){
            for(int i = 0; i < stMinusov; i++){
                baza.add(0);
            }

            baza.add(1);

            for(int j = 0; j < stMinusov; j++){
                baza.add(2);
            }

            baza.add(1);
        }

        // Prilagoditev baznega lista glede na fazni zamik

        for(int z  = 0; z < fazniZamik; z++){
            baza.add(baza.get(0));
            baza.remove(0);
        }

        // Dodajanje elementov v liste

        for(int el = 0; el < baza.size(); el++){
            switch(baza.get(el)){
                case 0:
                    zgornja.add(minus);
                    srednja.add(presledek);
                    spodnja.add(presledek);
                    break;

                case 1:
                    zgornja.add(plus);
                    srednja.add(crtica);
                    spodnja.add(plus);
                    break;

                case 2:
                    zgornja.add(presledek);
                    srednja.add(presledek);
                    spodnja.add(minus);
                    break;
            }
        }
        
        // Izpis prve vrstice

        zgornja.forEach(System.out::print);
        System.out.println();

        // Izpis vmesnih vrstic

        for(int v = 0; v < amplituda - 1; v++){
            srednja.forEach(System.out::print);
            System.out.println();
        }

        // Izpis zadnje vrstice
        spodnja.forEach(System.out::print);
    }
}
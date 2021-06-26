package excercises.e2;

public class Sudoku {

	// Rekurzivna funkcija, ki poisce resitev uganke na naslednji nacin:
	// - ce smo prisli do konca tabele, vrni pozitiven rezultat
	// - ce je vsebina celice polje[i][j] ze podana, 
	//      rekurzivno poisci resitev za naslednjo celico 
	// - sicer
	//      za vse mozne vrednosti celice polje[i][j] preveri, ali je situacija dovoljena
	//         ce je, rekurzivno poisci resitev za naslednjo celico
	//
	//      ce nobena vrednost ni dovoljena, razveljavi vsebino celice polje[i][j] in vrni negativen rezultat
	//
	
    static boolean resi(int i, int j, int[][] polje) 
    {	
        if(j >= polje.length) return true;
        if(i >= polje[j].length) return resi(0, j + 1, polje);
        if(polje[j][i] != 0) return resi(i + 1, j, polje);

        for (int val = 1; val < 10; val++) {
            if(veljavno(i, j, val, polje)) {
                polje[j][i] = val;
                if(resi(i + 1, j, polje)) return true;
            }
        }
        
        polje[j][i] = 0;
        return false;
    }

    // Funkcija preveri, ali je dovoljeno postaviti vrednost "val" v polje[i][j]
    static boolean veljavno(int i, int j, int val, int[][] polje) 
    {
        for (int k = 0; k < polje.length; k++) {
            if (polje[k][i] == val) return false;
        }
       
    	// preveri i-to vrstico
        //   ce se vrednost "val" ze nahaja v i-ti vrstici, potem je situacija neveljavna
        for (int k = 0; k < polje[j].length; k++) {
            if (polje[j][k] == val) return false;
        }

    	// preveri ustrezni kvadrat
        //   ce se vrednost "val" ze nahaja v kvadratu, potem je situacija neveljavna
        int x_kvadrata = (i / 3) * 3;
        int y_kvadrata = (j / 3) * 3;

        // System.out.println("x_kvadrata " + x_kvadrata);
        // System.out.println("y_kvadrata " + y_kvadrata);

        for (int y = y_kvadrata; y < y_kvadrata + 3; y++) {
            for (int x = x_kvadrata; x < x_kvadrata + 3; x++) {
                // System.out.println("y " + y);
                // System.out.println("x " + x);
                if(polje[y][x] == val) return false;
            }
        }
        
        // vse pogoje smo preverili, situacija je veljavna
        return true;
    }

    static void izpisiPolje(int[][] polje) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0)
                System.out.println(" -----------------------");
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) System.out.print("| ");
                if (polje[i][j] == 0)
                	System.out.print(" ");
                else
                    System.out.print(polje[i][j]);

                System.out.print(' ');
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }

    public static void main(String[] args) {
        int[][] polje = {
        		{0,8,0,4,0,2,0,6,0},
        		{0,3,4,0,0,0,9,1,0},
        		{9,6,0,0,0,0,0,8,4},
        		{0,0,0,2,1,6,0,0,0},
        		{0,0,0,0,0,0,0,0,0},
        		{0,0,0,3,5,7,0,0,0},
        		{8,4,0,0,0,0,0,7,5},
        		{0,2,6,0,0,0,1,3,0},
        		{0,9,0,7,0,1,0,4,0}
        };
        
        izpisiPolje(polje);
        if (resi(0,0,polje))
            izpisiPolje(polje);
        else
            System.out.println("Ni resitve");
    }
}

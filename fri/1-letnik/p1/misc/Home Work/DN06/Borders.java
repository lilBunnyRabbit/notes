import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Borders {

    private static int m;
    private static int n;
    private static int option;
    private static int[][] map;
    private static int seeSize = 0;
    private static int numOfCountryes = 0;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        worldEditor(sc);

        option = sc.nextInt();
        switch (option) {
            
            case 1:
               System.out.println(numOfCountryes);  // [WORKS]
               break;

            case 2:
                System.out.println(seeSize);    /// [WORKS]
                break;
        
            case 3:
                option3(); //[WORKS]
                break;
            
            case 4:
                option4(); // [WORKS]
                break;

            default:
                break;
        }
    }

    /////// Splosno

    public static void worldEditor(Scanner sc){

        map = new int[m][n]; // Draws the map

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                map[i][j] = sc.nextInt();   // Fills the map with the borders

                if (map[i][j] == 0) {
                    seeSize++;  // just for the secound option
                }
                if (map[i][j] > numOfCountryes) {
                    numOfCountryes = map[i][j];
                }

            }
        }

    }

    public static void option3(){

        for (int i = 1; i <= numOfCountryes; i++) {
            
            System.out.println(coastSize(i));

        }
    }

    public static void option4(){

        int maxNumOfSosedi = 0;
        int maxNumOFSosediID = 0;

        for (int i = 1; i <= numOfCountryes; i++) {

           if (maxNumOfSosedi < sosedi(i)) {
               maxNumOfSosedi = sosedi(i);
               maxNumOFSosediID = i;
           }
        
        }
        System.out.println(maxNumOFSosediID);
        System.out.println(maxNumOfSosedi);

    }

    public static int coastSize(int countryNum){

        int coast = 0; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (map[i][j] == countryNum ) {

                    if ( i == 0 || i == (m - 1) || j == 0 || j == (n - 1) ) {
                        coast++;
                    }else if(map[i][j+1] == 0  || map[i][j-1] == 0 || map[i-1][j] == 0 || map[i+1][j] == 0){
                        coast++;
                    }
                }
            }
        }
        return coast;
    }
   
    public static int sosedi(int countryNum){

        List<Integer> sosedi = new ArrayList<Integer>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                if (map[i][j] == countryNum ) {

                    try {
                        checkForNeighbour(map[i][j+1], countryNum, sosedi);
                    } catch (Exception e) {}
                    try {
                        checkForNeighbour(map[i+1][j], countryNum, sosedi);
                    } catch (Exception e) {}
                    try {
                        checkForNeighbour(map[i][j-1], countryNum, sosedi);
                    } catch (Exception e) {}
                    try {
                        checkForNeighbour(map[i-1][j], countryNum, sosedi);
                    } catch (Exception e) {}

                    // thank you try catch block <3
                    
                }

            }
        }
        
        return sosedi.size();
    }

    public static void checkForNeighbour(int tile ,int countryNum, List sosedi){

        if (tile != countryNum && tile != 0) { // if not itself, and not sea

            if (!(sosedi.contains(tile))) { // if not a sosedi already
                sosedi.add(tile); // add to the list of sosedi
            }
            
        }

    }

}
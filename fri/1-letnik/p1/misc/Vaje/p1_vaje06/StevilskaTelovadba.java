import java.util.Scanner;

public class StevilskaTelovadba{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ukaz = sc.nextInt();
        int n = sc.nextInt();
        int rezultat = 0;
        int d = 0;
        int dolzina = 0;

        switch(ukaz){
            case 1:
                d = sc.nextInt();
                rezultat = n * 10 + d;
                System.out.println(rezultat);
                break;

            case -1:
                rezultat = n / 10;
                System.out.println(rezultat);
                break;

            case 2:
                d = sc.nextInt();
                int povecanD = d;
                for(int i = n; i > 1; i++){
                    i = (int)(i / 10);
                    dolzina++; 
                }

                for(int j = 0; j < dolzina; j++){
                    povecanD = povecanD * 10;
                }

                rezultat = n + povecanD;
                System.out.println(rezultat);
                break;

            case -2:
                for(int i = n; i > 1; i++){
                    i = (int)(i / 10);
                    dolzina++; 
                }
                for(int j = 0; j < dolzina; j++){
                    prvaStevka = n / 10;
                }
                rezultat = nsss
                for(int j = 0; j < dolzina; j++){
                    rezultat = 
                }
                rezultat = n - (prvaStevka * (int)(Math.pow(10, dolzina)));
                System.out.println(rezultat);
                break;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class DN02_1{
	public static void main(String[] args){
    
        Scanner sc = new Scanner(System.in);

        int ukaz = sc.nextInt();
        int zadnjiElement = 0;
        int predzadnjiElement = 0;
        int trenutniElement = 0;
        int dolzinaCete = 0;
        int razlicniElementi = 1;
        int predhodnjiElement = 0;
        int najvecjRazlicnihElementov = 1;

        while(sc.hasNextInt()){
            switch(ukaz){
                case 1:
                    int prviElement = sc.nextInt();
                    System.out.println(prviElement);
                    System.exit(0);
                    break;

                case 2:
                    zadnjiElement = sc.nextInt();

                    if(sc.hasNextInt() == false){
                        System.out.println(zadnjiElement);
                        System.exit(0);
                    }
                    break;

                case 3:
                    predzadnjiElement = zadnjiElement;
                    zadnjiElement = sc.nextInt();

                    if(sc.hasNextInt() == false){
                        int vsotaZadnjihDvehElementov = zadnjiElement + predzadnjiElement;
                        System.out.println(vsotaZadnjihDvehElementov);
                        System.exit(0);
                    }                   
                    break;

                case 4:
                    predhodnjiElement = trenutniElement;
                    trenutniElement = sc.nextInt();

                    if(trenutniElement >= predhodnjiElement){
                        dolzinaCete++;

                    }else{
                        System.out.println(dolzinaCete);
                        System.exit(0);
                    }
                    break;

                case 5:
                    predhodnjiElement = trenutniElement;
                    trenutniElement = sc.nextInt();

                    if(trenutniElement >= predhodnjiElement){
                        if(trenutniElement != predhodnjiElement){
                            razlicniElementi++;
                        }
                        
                    }else{
                        if(razlicniElementi > najvecjRazlicnihElementov){
                            najvecjRazlicnihElementov = razlicniElementi;
                            razlicniElementi = 1;

                        }else{
                            razlicniElementi = 1;
                        }
                    }
                    
                    if(sc.hasNextInt() == false){
                        System.out.println(najvecjRazlicnihElementov);
                        System.exit(0);
                    } 
                    break;
            }
        }
        /*
        //ce preverjam has nex pri 5 da bi prekinil ucasih timeouta pri 11
        if(ukaz == 5){
            System.out.println(najvecjRazlicnihElementov);
        }
        */
    }
}
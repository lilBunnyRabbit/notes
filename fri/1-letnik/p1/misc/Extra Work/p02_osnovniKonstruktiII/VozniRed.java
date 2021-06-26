import java.util.Scanner;

public class VozniRed{
	public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int prvaUra = sc.nextInt();
        int prvaMinuta = sc.nextInt();
        int drugaUra = sc.nextInt();
        int drugaMinuta = sc.nextInt();
        int interval = sc.nextInt();
<<<<<<< HEAD
        int velikostIntervala = 0;
=======
>>>>>>> 9be3b8306b56fae3b553d27a4134025b618ab6e1

        int ura = prvaUra;
        int minuta = prvaMinuta;

        while(true){
<<<<<<< HEAD
            if(ura < 10){
                System.out.printf("0%d:%d\n", ura, minuta);
            }else if(minuta < 10){
                System.out.printf("%d:0%d\n", ura, minuta);
            }else if(ura < 10 && minuta <10){
=======
            if(minuta < 10){
                System.out.printf("%d:0%d\n", ura, minuta);
            }else if(ura < 10){
                System.out.printf("0%d:%d\n", ura, minuta);
            }else if(ura < 10 && minuta < 10){
>>>>>>> 9be3b8306b56fae3b553d27a4134025b618ab6e1
                System.out.printf("0%d:0%d\n", ura, minuta);
            }else{
                System.out.printf("%d:%d\n", ura, minuta);
            }
<<<<<<< HEAD

            if(minuta == drugaMinuta && ura == drugaUra){
                break;
            }else if(ura == drugaUra && minuta < drugaMinuta && minuta + interval > drugaMinuta){
                break;
            }else if(ura < drugaUra && minuta + interval > drugaMinuta && minuta < drugaMinuta){
                break;
            }else if(ura > drugaUra){
                break;
            }


            if(interval == 60){
                ura++;
            }else if(interval < 60){
                minuta += interval;
                if(minuta > 60){
                    minuta -= 60;
                    ura++;
                }else if(minuta == 60){
                    minuta = 0;
                    ura++;
                }
            }else if(interval > 60){
                velikostIntervala = interval / 60;
                ura += velikostIntervala;
                minuta += interval - velikostIntervala;
                if(minuta > 60){
                    minuta -= 60;
                    ura++;
                }else if(minuta == 60){
                    minuta = 0;
                    ura++;
                }
            }
        }

	
	}
=======
            
            

            if(ura == drugaUra){
                if(minuta == drugaMinuta){
                    break;
                }else if(minuta < drugaMinuta){
                    if(minuta + interval > drugaMinuta){
                        break;
                    }

                }

            }else if(ura + 1 == drugaUra){
                if(minuta + interval >= 60){
                    if(minuta < drugaMinuta){
                        if(minuta + interval - 60 > drugaMinuta){
                            break;
                        }

                    }                    
                }
            }
            minuta += interval;

            if(minuta > 60){
                minuta -= 60;
                ura++;
            }else if(minuta == 60){
                minuta = 0;
                ura++;
            }



        } 	
	}

>>>>>>> 9be3b8306b56fae3b553d27a4134025b618ab6e1
}
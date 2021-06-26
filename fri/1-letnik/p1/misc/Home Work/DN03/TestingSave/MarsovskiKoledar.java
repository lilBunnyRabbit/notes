import java.util.Scanner;

class MarsovskiKoledar{
  public static int stevilo_dni_koledar = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int zamik = 0;
    int stevilo_mesecev = sc.nextInt();

    int stevilo_dni_mesec = sc.nextInt();
    int stevilo_dni_teden = sc.nextInt();

    int prost_dan_teden = sc.nextInt();
    int praznik_dan_koledar = sc.nextInt();

    int m_zacetni = sc.nextInt();
    int m_zacetni_temp = m_zacetni;

    int l_zacetni = sc.nextInt();
    int l_zacetni_temp = l_zacetni;

    int m_koncni = sc.nextInt();
    int l_koncni = sc.nextInt();

    int stevilo_ponavljanj = 1;
    int leto = l_zacetni;
    int mesec = m_zacetni-1;
    int temp;

    while(m_zacetni_temp != m_koncni || l_zacetni_temp != l_koncni){
      m_zacetni_temp++;
      if(m_zacetni_temp>stevilo_mesecev){
        m_zacetni_temp=1;
        l_zacetni_temp++;
      }
      stevilo_ponavljanj++;
    }
    if(stevilo_ponavljanj > 1){
      if(l_zacetni == 1){
        temp = m_zacetni;
      }else if(m_zacetni == 1){
        temp = stevilo_mesecev*l_zacetni;
      }else{
        temp = stevilo_mesecev*(l_zacetni-1) + m_zacetni;
      }
      for(int po = 1; po < temp; po++){
        zamik = mesec1(stevilo_dni_mesec, stevilo_dni_teden, zamik, prost_dan_teden, praznik_dan_koledar, false, true);
      }
    }

    for (int m = 0; m<stevilo_ponavljanj; m++) {
      mesec++;
      if (mesec > stevilo_mesecev) {
          mesec = 1;
          leto++;
      }
      System.out.printf("%d/%d%n", mesec, leto);
      mesec1(stevilo_dni_mesec, stevilo_dni_teden, zamik, prost_dan_teden, praznik_dan_koledar, true, true);
      zamik = mesec1(stevilo_dni_mesec, stevilo_dni_teden, zamik, prost_dan_teden, praznik_dan_koledar, false, false);
    }
  }

  public static int mesec1(int stevilo_dni_mesec, int stevilo_dni_teden, int zamik, int prost_dan_teden, int praznik_dan_koledar, boolean print, boolean dodaj){
    int st_vrstic = (stevilo_dni_mesec+zamik)/stevilo_dni_teden;
    int zaporedno_st_dneva = (-1)*zamik;
    int zamik_dni = 0;

    if(stevilo_dni_mesec > (st_vrstic * stevilo_dni_teden - zamik)){
      st_vrstic++;
    }

    int[][] mesec1 = new int[st_vrstic][stevilo_dni_teden];

    for (int i = 0; i < st_vrstic; i++) {
      for (int j = 0; j < stevilo_dni_teden; j++) {

        zaporedno_st_dneva++;

        if(zaporedno_st_dneva <= stevilo_dni_mesec && zaporedno_st_dneva > 0){
          mesec1[i][j]=zaporedno_st_dneva;
          if(dodaj){
            stevilo_dni_koledar++;
          }
        }else if(zaporedno_st_dneva == stevilo_dni_mesec +1){
          zamik_dni = j;
          mesec1[i][j]=0;
        }else{
          mesec1[i][j]=0;
        }

        if(print){

          if (mesec1[i][j] != 0) {
            if ((j+1)%prost_dan_teden == 0 && stevilo_dni_koledar % praznik_dan_koledar == 0) {
              System.out.printf("%4d%s",mesec1[i][j], "*");
            }else if ((j+1)%prost_dan_teden == 0) {
              System.out.printf("%4d%s",mesec1[i][j], "x");
            }else if (stevilo_dni_koledar % praznik_dan_koledar == 0) {
              System.out.printf("%4d%s",mesec1[i][j], "+");
            }else{
              System.out.printf("%4d%s",mesec1[i][j], "_");
            }
          }else if(zaporedno_st_dneva<=stevilo_dni_mesec){
            System.out.printf("%5s", "");
          }
        }
      }

      if(print){
        System.out.println();
      }
    }
    return zamik_dni;
  }
}

/* 
	DOMACA NALOGA 7, Enotirna proga
	21.12.2018 - 23.12.2018
*/

import java.util.*;

class Enotirna_proga{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int stPostaj = sc.nextInt();

		// tabela s casovi med postajami
		int[] casoviPostaj = new int[stPostaj-1];			// 20 40 30 50 10

		for (int i = 0; i < stPostaj -1 ; i++) {
			casoviPostaj[i] = sc.nextInt();
		}

		// primeri z zacetnimi casovi ta in tb
		int stPrimerov = sc.nextInt();						// 3

		int[][] tabelaPrimerov = new int[stPrimerov][2];
		// 35 25	
		// 0 85
		// 100 300	

		for (int i = 0; i < stPrimerov; i++) {
			for (int j = 0; j < 2; j++) {
				tabelaPrimerov[i][j] = sc.nextInt();	
			}		
		}
//***********************************************************************************************************
		int razlikaPrihodnihCasov;

		int razdalja = stPostaj-1; 

		int indexDesno;
		int indexLevo;
		int indexSredine;

		int casZLeve;
		int casZDesne;

		int preveri = 0;
		int najCas;

		long postaja = 0;
		long enaLevo = 0;
		long enaDesno = 0;

		int delPoti = 0;

		int vsota = 0;

//******************************************************************************************************************
		// indexi postaj, ko smo cisto nazacetku
		int zacIndexLevo = 0;
		int zacIndexDesno = stPostaj-1;

		int dProge = casPotovanja(zacIndexLevo, zacIndexDesno, casoviPostaj);

		// gremo po primerih
		for (int p = 0; p < stPrimerov; p++) {

			razdalja = dProge;
			preveri = 0;
			najCas = 0;

			int tA = tabelaPrimerov[p][0];	// 100
			int tB = tabelaPrimerov[p][1];	// 300

			// optimiziramo zacetek, tako, da bo eden vlak imel vrednost 0.
			// to pomeni, da eden spelje.
			int zamudaA = odstejZacetke(tA, tB);
			int zamudaB = odstejZacetke(tB, tA);

			// preveri, ce imamo slucajno kje v krajiscu ze 0
			// srecala se bosta v krajiscu, noben ne caka nobenega
			if (zamudaA >= dProge || zamudaB >= dProge) {
				najCas = 0;
			}

			else {

				indexLevo = 0;
				indexDesno = stPostaj-1;
				indexSredine = (indexLevo + indexDesno) /2;

				casZLeve = zamudaA + casPotovanja(0, indexSredine, casoviPostaj);
				casZDesne = zamudaB + casPotovanja(indexSredine, stPostaj-1, casoviPostaj);				

				while (razdalja >= 2 && preveri == 0) {

					razlikaPrihodnihCasov = (casZLeve - casZDesne);

					
					// ce bo pozitivna, zamuja A, ce je negativna, zamuja B
					
					najCas = java.lang.Math.abs(razlikaPrihodnihCasov);

					// ce nihce ne caka nobenega
					if (razlikaPrihodnihCasov == 0) {
						najCas = 0;
						preveri++;
					}

					else if (razlikaPrihodnihCasov > 0) {		// zamuja A

						// ali bomo lahko odsteli cas A-ja

						if (java.lang.Math.abs(razlikaPrihodnihCasov - (casoviPostaj[indexSredine-1] * 2)) < java.lang.Math.abs(razlikaPrihodnihCasov)) {
							// gremo levo

							// ce spremeni predznak, smo zmagali
							
							enaLevo = ((long) razlikaPrihodnihCasov - (casoviPostaj[indexSredine-1] * 2));
							postaja = ((long) razlikaPrihodnihCasov);


							if (enaLevo * postaja < 0){
							
								// ce nam uspe dobiti tudi manjsi cas
								if (((razlikaPrihodnihCasov - (casoviPostaj[indexSredine-1] * 2))) < najCas) {
									najCas = java.lang.Math.abs(razlikaPrihodnihCasov - (casoviPostaj[indexSredine-1] * 2));
									preveri++;
								}

								else {

									najCas = java.lang.Math.abs(razlikaPrihodnihCasov);
									preveri++;							
								}

							}
							else {
								// gremo levo
								indexLevo = indexLevo;
								indexDesno = indexSredine;
								indexSredine = (indexLevo + indexDesno) / 2;
								
								delPoti = casPotovanja(indexSredine, indexDesno, casoviPostaj);
								casZLeve = casZLeve - delPoti;
								casZDesne = casZDesne + delPoti;
							}


						}
						else {
							najCas = java.lang.Math.abs(razlikaPrihodnihCasov);
							preveri++;
						}
					}


					else if (razlikaPrihodnihCasov < 0) {		// caka A, zamuja B
						// ali bomo lahko odsteli cas B-ja
						
						if (java.lang.Math.abs(razlikaPrihodnihCasov + (casoviPostaj[indexSredine] * 2)) < java.lang.Math.abs(razlikaPrihodnihCasov)) {
							
							// gremo desno
						
							// ce kar naenkrat postane cakalni cas pozitiven, smo zmagali

							postaja = ((long) razlikaPrihodnihCasov);
							enaDesno = ((long) razlikaPrihodnihCasov + (casoviPostaj[indexSredine] * 2));
							

							if (postaja * enaDesno < 0) {

								if (java.lang.Math.abs((razlikaPrihodnihCasov + (casoviPostaj[indexSredine] * 2))) < java.lang.Math.abs(najCas)) {
									najCas = java.lang.Math.abs((razlikaPrihodnihCasov + (casoviPostaj[indexSredine] * 2)));
									
									preveri++;
								}
								else {
									najCas = java.lang.Math.abs(razlikaPrihodnihCasov);
									preveri++;
								}

							}
							else {

								indexDesno = indexDesno;
								indexLevo = indexSredine;
								indexSredine = (indexLevo + indexDesno) / 2;

								delPoti = casPotovanja(indexLevo, indexSredine, casoviPostaj);
								casZLeve = casZLeve + delPoti;
								casZDesne = casZDesne - delPoti;

							}

						}
						else {
							najCas = java.lang.Math.abs(razlikaPrihodnihCasov);
							preveri++;
						}
					}
					razdalja = indexDesno - indexLevo;
				}
			}
			vsota += najCas;
		}
	
		System.out.println(vsota);


	}

	// izracunamo dolzino proge na dolocenem intervalu
	public static int casPotovanja(int levaPostaja, int desnaPostaja, int[] casoviPostaj){
		int casPotovanja = 0;

		for (int i = levaPostaja; i < desnaPostaja; i++) {
			casPotovanja += casoviPostaj[i];
		}
		return casPotovanja;
	}


	public static int odstejZacetke(int prvi, int drugi){
		int razlika = prvi - drugi;
		// 25 - 35 = -15
		if (razlika < 0) {		// ce je tB vecji
			drugi =  java.lang.Math.abs(razlika);
			prvi = 0;
			return prvi;
		}
		else if (razlika > 0) {
			prvi = razlika;
			drugi = 0;
			return prvi;
		}
		else{
			return 0;
		}
	}

}
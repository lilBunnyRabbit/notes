package excercises.e4.vrsta;

class Konj
{
	int x;
	int y;
	String poteze;
	
	Konj(int x, int y, String poteze)
	{
		// hranimo trenutno pozicijo ('x', 'y') ter pot do nje ('poteze')
		this.x = x;
		this.y = y;
		this.poteze = poteze + " -> [" + x + "," + y + "]";
	}
}

	
public class NajkrajsaPot {
	
	public static void main(String[] args) {
		
		// podana je mapa v obliki dvodimenzionalnega polja 'mapa'
		// 'C' oznacuje ciljno polje
		// 'B' oznacuje polje z bombo
		// ' ' oznacuje varno polje, na katerega lahko stopimo
		
		char[][] mapa = {
				{'B',' ',' ',' ','B',' ',' ','B'},
				{' ','B',' ',' ',' ','B','B',' '},
				{' ','B','B',' ',' ',' ',' ',' '},
				{' ','B',' ',' ','B','B','B',' '},
				{'B','B','B','B','B',' ','B','B'},
				{'B',' ',' ','B',' ','C',' ',' '},
				{' ','B','B','B',' ','B','B','B'},
				{' ','B',' ',' ','B','B',' ',' '}};
		
		// zacetni polozaj konja
		int zacetni_x = 3;
		int zacetni_y = 1;
		
		//
		// Zelimo poiskati najkrajso varno pot sahovskega konja iz zacetne pozicije do ciljnega polja.
		// Pri tem si pomagamo z abstraktnim podatkovnim tipom vrsta.
		//
		
		Queue queue = new Queue();
		
		System.out.println("Zacetna pozicija konja je [" + zacetni_x + "," + zacetni_y + "]");
		
		Konj k = new Konj(zacetni_x, zacetni_y, "");
		queue.enqueue(k);
		
		boolean obstajaPot = false;

		main_loop:
		while (!queue.empty() && !obstajaPot)
		{
			// - preberemo zacetni element in ga odstranimo iz vrste
			Konj front = (Konj) queue.front();
			queue.dequeue();
			// - preverimo ali prebrani element oznacuje veljavno pozicijo na mapi (ali so koordinate znotraj dovoljenih vrednosti)
			//   ce pozicija ni veljavna, izvedemo naslednjo iteracijo zanke
			if (
				front.y >= mapa.length || 
				front.y < 0 || 
				front.x >= mapa[front.y].length ||
				front.x < 0
			) continue;
			// - ce je pozicija veljavna, preverimo ali smo na cilju 'C' -  v tem primeru izpisemo resitev in izstopimo iz zanke
			// - ce je pozicija veljavna, preverimo ali smo na bombi 'B' - v tem primeru izvedemo naslednjo iteracijo zanke 
			// - ce je pozicija veljavna in nismo ne na cilju ne na bombi, generiramo naslednje pozicije konja in jih dodamo v vrsto
			switch (mapa[front.y][front.x]) {
				case 'C':
					obstajaPot = true;
					System.out.println(front.poteze + " -> " + mapa[front.y][front.x]);
					break main_loop;
				case 'B': continue;
				default:
					mapa[front.y][front.x] = 'X';
					dodajNovePozicije(front, queue, mapa);
					break;
			}
		}

		if (!obstajaPot)
			System.out.println("Varne poti do ciljnega polja ni!");
	}

	public static void dodajNovePozicije(Konj konj, Queue queue, char[][] mapa) {
		int[][] pozicije = {
			{ 2, 1 },
			{ 2, -1 },
			{ -2, 1 },
			{ -2, -1 },
			{ 1, 2 },
			{ -1, 2 },
			{ 1, -2 },
			{ -1, -2 }
		};

		for(int[] pozicija : pozicije) {
			Konj new_konj = new Konj(konj.x + pozicija[0], konj.y + pozicija[1], konj.poteze);
			if (
				new_konj.y >= mapa.length || 
				new_konj.y < 0 || 
				new_konj.x >= mapa[new_konj.y].length ||
				new_konj.x < 0
			) continue;
			if(mapa[new_konj.y][new_konj.x] == 'X') continue;
			queue.enqueue(new_konj);
		}
	}
}

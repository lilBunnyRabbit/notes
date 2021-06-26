package excercises.e2;

public class Znesek {

	// funkcija preveri, ce obstaja podmnozica elementov v tabeli 'vrednosti',
	// ki se sesteje v 'znesek'.
	
	public static boolean sestavi(int[] vrednosti, int index, int znesek)
	{
		// robni pogoj: 
		// - znesek je sestavljen
		// - porabili smo vse elemente, zneska nismo sestavili
	
		if(znesek == 0) return true;
		if(znesek < 0) return false;
		if(vrednosti.length == 0) return false;
		if(index >= vrednosti.length) return false;
		
		if(sestavi(vrednosti, index + 1, znesek - vrednosti[index])) {
			System.out.print(vrednosti[index] + " ");
			return true;
		};

		// problem poskusimo resiti tako, da uporabimo trenutni element 
		// (mozno le, ce zahtevani znesek ni manjsi od vrednosti trenutnega elementa)
		// 
		// ce nam ne uspe, preskocimo trenutni element in nadaljujemo iskanje
				
		
		return sestavi(vrednosti, index + 1, znesek);
		
	}
	
	public static void main(String[] args) {
		int[] vrednosti = {7,8,5,1,3,9,2,5,2,3,5};
		int znesek = 27;
		
		System.out.print("Znesek " + znesek + " dobimo tako, da sestejemo elemente: ");
		
		if (!sestavi(vrednosti, 0, znesek))
			System.out.println("Zneska ni mogoce sestaviti s podanimi elementi");
	}

}
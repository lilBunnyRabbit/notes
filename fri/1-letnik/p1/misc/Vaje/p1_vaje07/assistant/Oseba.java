
public class Oseba {

	// atributi

	private String ime;
	private String priimek;
	private char spol;
	private int letoRojstva;
	
	private Oseba oce;
	private Oseba mati;
	
	// število doslej ustvarjenih oseb
	private static int stUstvarjenih = 0;

	// konstruktorja
	
	public Oseba(String im, String pr, char sp, int lr) {
		/*
		// this: kazalec na objekt, ki ga je new pravkar ustvaril
		this.ime = im;
		this.priimek = pr;
		this.spol = sp;
		this.letoRojstva = lr;
		this.oce = null;
		this.mati = null;
		*/
		
		// klic drugega konstruktorja
		this(im, pr, sp, lr, null, null);
	}
	
	public Oseba(String im, String pr, char sp, int lr, Oseba oc, Oseba ma) {
		this.ime = im;
		this.priimek = pr;
		this.spol = sp;
		this.letoRojstva = lr;
		this.oce = oc;
		this.mati = ma;
		stUstvarjenih++;   // brez this-a!
	}
	
	// metode
	
	public String vrniIme() {
		return this.ime;    // return ime;
	}
	
	public void nastaviIme(String novoIme) {
		this.ime = novoIme;
	}
	
	public String toString() {
		return String.format("%s %s (%c), %d", this.ime, this.priimek,
		                     this.spol, this.letoRojstva);
	}
	
	public int starost(int leto) {		
		int x = this.letoRojstva;
		int star = leto - x;
		return star;
		// return leto - this.letoRojstva;
	}
	
	public boolean jeStarejsaOd(Oseba os) {
		/*
		if (this.letoRojstva < os.letoRojstva) {
			return true;
		} else {
			return false;
		}
		*/  // OK, ampak nekoliko dolgovezno
		
		return (this.letoRojstva < os.letoRojstva);
		// return (this.starost(0) > os.starost(0));
	}
	
	public String imeOceta() {
		if (this.oce == null) {
			return null;
		}
		return this.oce.ime;
	}
	
	public boolean jeBratAliSestraOd(Oseba os) {
		// preverimo, ali je oseba this brat ali sestra osebe os
		return this != os &&
		       this.oce != null && this.mati != null &&
		       this.oce == os.oce && this.mati == os.mati;
	}
	
	public boolean jeSestraOd(Oseba os) {
		return this.jeBratAliSestraOd(os) && this.spol == 'Z';
	}
	
	public boolean jeTetaOd(Oseba os) {
		return (os.oce != null && this.jeSestraOd(os.oce)) ||
		       (os.mati != null && this.jeSestraOd(os.mati));
	}
	
	public boolean jeOcetovskiPrednikOd(Oseba os) {
		Oseba p = os.oce;
		while (p != this && p != null) {
			p = p.oce;
		}
		return (p == this);
	}
	
	public static int steviloUstvarjenih() {
		return stUstvarjenih;
	}
}

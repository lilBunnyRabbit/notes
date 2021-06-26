
public abstract class Lik {
	
	public abstract int ploscina();
	
	public abstract int obseg();
	
	// 1. možnost (preprostejša, a manj estetska):
	/*
	public abstract String toString();
	*/
	
	// 2. možnost:
	@Override
	public String toString() {
		return String.format("%s [%s] | p = %d, o = %d",
				this.vrsta(), this.podatki(), this.ploscina(), this.obseg());
	}
	
	public abstract String vrsta();
	
	public abstract String podatki();
}

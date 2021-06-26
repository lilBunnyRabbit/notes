
public class Pravokotnik extends Lik {
	
	protected int a;
	private int b;
	
	public Pravokotnik(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int ploscina() {
		return this.a * this.b;
	}
	
	@Override
	public int obseg() {
		return 2 * (this.a + this.b);
	}
	
	@Override
	public String vrsta() {
		return "pravokotnik";
	}
	
	@Override
	public String podatki() {
		return String.format("a = %d, b = %d", this.a, this.b);
	}
}

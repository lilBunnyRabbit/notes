
public class Krog extends Lik {
	
	private int r;     // polmer

	public Krog(int r) {
		this.r = r;
	}
	
	@Override
	public int ploscina() {
		return (int) Math.round(Math.PI * this.r * this.r);
	}
	
	@Override
	public int obseg() {
		return (int) Math.round(2.0 * Math.PI * this.r);
	}
	
	@Override
	public String vrsta() {
		return "krog";
	}
	
	@Override
	public String podatki() {
		return String.format("r = %d", this.r);
	}	
}

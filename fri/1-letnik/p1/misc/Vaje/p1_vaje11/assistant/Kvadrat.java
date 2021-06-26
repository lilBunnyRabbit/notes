
public class Kvadrat extends Pravokotnik {

	public Kvadrat(int stranica) {
		super(stranica, stranica);
		
		/* ne gre ...
		this.a = stranica;
		this.b = stranica;
		*/
	}
	
	@Override
	public String vrsta() {
		return "kvadrat";
	}
	
	@Override
	public String podatki() {
		return String.format("a = %d", this.a);
	}
}

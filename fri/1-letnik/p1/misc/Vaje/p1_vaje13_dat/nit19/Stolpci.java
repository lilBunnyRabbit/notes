
import java.awt.*;

/**
 * Stolpci s povezovalno "crto in napisi.
 */
public class Stolpci extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        int[] podatki = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        //int[] podatki = {5};
        //int[] podatki = {1, 1, 1};
        Stolpci stolpci = new Stolpci(podatki);
        stolpci.sproziRisanje(args);
    }

    // podatki, ki dolo"cajo vi"sine stolpcev
    private int[] podatki;

    public Stolpci(int[] podatki) {
        this.podatki = podatki;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {
		FontMetrics fm = g.getFontMetrics();
		
		// višina vrstice besedila v trenutno izbrani pisavi
		double hPisava = fm.getAscent();
		
		double wStolpec = this.sirinaStolpca(wp, hp);
		double xStolpec = 0.0;
		
		for (int i = 0;  i < this.podatki.length;  i++) {
			// nariši stolpec
			double hStolpec = this.visinaStolpca(i, wp, hp);
			double yStolpec = hp - hStolpec;
			g.setColor(Color.ORANGE);
			g.fillRect(ri(xStolpec), ri(yStolpec), ri(wStolpec), ri(hStolpec));
			g.setColor(Color.RED);
			g.drawRect(ri(xStolpec), ri(yStolpec), ri(wStolpec), ri(hStolpec));
			
			if (i > 0) {
				// nariši daljico od sredine vrha prejšnjega stolpca
				// do sredine vrha trenutnega stolpca
				double[] xyPrejsnji = this.sredinaVrha(i - 1, wp, hp);
				double[] xyTrenutni = this.sredinaVrha(i, wp, hp);
				g.setColor(Color.BLUE);
				g.drawLine(ri(xyPrejsnji[0]), ri(xyPrejsnji[1]),
				           ri(xyTrenutni[0]), ri(xyTrenutni[1]));
			}
			
			// nariši napis na stolpcu
			String napis = Integer.toString(i + 1);
			double wNapis = fm.stringWidth(napis);
			double xNapis = xStolpec + (wStolpec - wNapis) / 2.0;
			double yNapis = hp - hPisava;
			g.setColor(Color.BLACK);
			g.drawString(napis, ri(xNapis), ri(yNapis));

			xStolpec += wStolpec;
		}
    }

    /**
     * Vrne "sirino (v pikslih) posameznega stolpca.
     */
    public double sirinaStolpca(double wp, double hp) {
		return wp / this.podatki.length;
    }

    /**
     * Vrne vi"sino (v pikslih) stolpca s podanim indeksom.
     */
    public double visinaStolpca(int ixStolpec, double wp, double hp) {
		return this.podatki[ixStolpec] * hp / maksimum(this.podatki);
    }

    /**
     * Vrne koordinati (v pikslih) sredine zgornjega roba stolpca s podanim indeksom.
     * @return tabela z dvema elementoma ({x, y}).
     */
    public double[] sredinaVrha(int ixStolpec, double wp, double hp) {
        double wStolpec = this.sirinaStolpca(wp, hp);
		double x = (ixStolpec + 0.5) * wStolpec;
		double y = hp - this.visinaStolpca(ixStolpec, wp, hp);
		double[] rezultat = {x, y};
		return rezultat;
    }
	
	private static int maksimum(int[] t) {
		int m = t[0];
		for (int i = 1;  i < t.length;  i++) {
			m = Math.max(m, t[i]);
		}
		return m;
	}
}


public class Funkcije {

    public static double koren(double x, double epsilon) {
		double vsota = 0.0;   // vsota doslej izračunanih členov
		int n = 0;
		double clen = 1.0;   // člen pri n == 0
		
		while (Math.abs(clen) > epsilon) {
			vsota += clen;
			clen = (1.0 - 2.0 * n) * (x - 1.0) * clen / (2.0 * (n + 1.0));
			n++;
		}

		return vsota;
    }
}

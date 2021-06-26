
import java.util.Scanner;

public class Mravlja {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int visina = sc.nextInt();
		int sirina = sc.nextInt();
		
		// osnovna različica (pravilna, a neučinkovita)
		// System.out.println(stPoti(visina, sirina));
		
		// različica z memoizacijo (ne memo-r-izacijo)
		int m = Math.max(visina, sirina) + 1;
		long[][] memo = new long[m][m];
		System.out.println(stPotiMemo(visina, sirina, memo));
	}
	
	private static long stPoti(int visina, int sirina) {
		if (visina == 1 || sirina == 1) {
			return 1;
		}
		return stPoti(visina, sirina - 1) + stPoti(visina - 1, sirina);
	}
	
	private static long stPotiMemo(int visina, int sirina, long[][] memo) {
		if (visina == 1 || sirina == 1) {
			return 1;
		}
		// Smo število poti za steno visina x sirina že izračunali?
		// Če smo, ga kar vrnemo.
		if (memo[visina][sirina] > 0) {
			return memo[visina][sirina];
		}
		if (memo[sirina][visina] > 0) {
			return memo[sirina][visina];
		}
		
		// Števila poti za steno visina x sirina še nismo izračunali,
		// zato ga izračunamo in shranimo, saj ga bomo morda še kdaj
		// potrebovali.
		memo[visina][sirina] = stPotiMemo(visina, sirina - 1, memo) +
		                       stPotiMemo(visina - 1, sirina, memo);
		return memo[visina][sirina];
	}
}

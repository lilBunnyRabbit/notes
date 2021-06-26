
import java.util.Arrays;
import java.util.Scanner;

public class Dolgovi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stOseb = sc.nextInt();
		int stIzposoj = sc.nextInt();
		
		int[][] nepobotani = new int[stOseb][stOseb];
		for (int i = 1;  i <= stIzposoj;  i++) {
			int dobi = sc.nextInt() - 1;
			int da = sc.nextInt() - 1;
			int znesek = sc.nextInt();
			nepobotani[dobi][da] += znesek;
		}
		System.out.println(Arrays.deepToString(nepobotani));
		
		int[][] pobotani = new int[stOseb][stOseb];
		for (int a = 0;  a < stOseb;  a++) {
			for (int b = 0;  b < stOseb;  b++) {
				if (nepobotani[a][b] > nepobotani[b][a]) {
					pobotani[a][b] = nepobotani[a][b] - nepobotani[b][a];
				}
			}
		}
		System.out.println(Arrays.deepToString(pobotani));
	}
}

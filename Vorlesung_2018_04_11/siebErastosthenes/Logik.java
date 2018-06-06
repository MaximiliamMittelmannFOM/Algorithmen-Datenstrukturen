package siebErastosthenes;

import java.lang.Math;

public class Logik {
	static int zahl1 = 102;
	static int zahl2 = 150;
	public static void main(String[] args) {
		System.out.println("Euklid von "+zahl1+" und "+zahl2+": "+ggT(zahl1,zahl2));
	}
	
	public static boolean istPrimzahl(int zahl, int[] primzahlen) {
		for (int i = 0; i < primzahlen.length && primzahlen[i] != 0; i++) {
			if (zahl%primzahlen[i]==0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] generiereSieb(int maxZahl) {
		int berechneBis = (int) Math.round(Math.sqrt(maxZahl));
		int[] sieb = new int[berechneBis];
		
		sieb[0] = 2;
		for (int i = 1; i < sieb.length; i++) {
			for (int y = sieb[i-1]+1; i <= berechneBis; y++) {
				if (istPrimzahl(y, sieb)) {
					sieb[i] = y;
					break;
				}
			}
		}
		return sieb;
	}
	
	public static int ggT(int a, int b) {
		if (a <= 0 && b <= 0) return 0;
		int ret = 1;
		int[] sieb = generiereSieb((a > b ? a : b));
		
		for (int i = 0; i < sieb.length; i++) {
			while ( a%sieb[i] == 0 && b%sieb[i] == 0) {
				ret *= sieb[i];
				a /= sieb[i];
				b /= sieb[i];
			}
		}
		return ret;
	}
}

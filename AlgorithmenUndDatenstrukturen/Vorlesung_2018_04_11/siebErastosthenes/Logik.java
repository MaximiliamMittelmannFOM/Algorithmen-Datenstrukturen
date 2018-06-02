package siebErastosthenes;

import java.lang.Math;

public class Logik {
	public static void main(String[] args) {
		int[] primzahlen = generiereSieb(10);
		for (int i = 0; i < primzahlen.length; i++) System.out.println(primzahlen[i]);
	}
	
	public static boolean istPrimzahl(int zahl, int[] primzahlen) {
		for (int i = 0; i < primzahlen.length && primzahlen[i] != 0; i++) {
			if (glattTeilbar(zahl,primzahlen[i])) {
				return false;
			}
		}
		return true;
	}
	public static boolean glattTeilbar(int nenner, int teiler) {
		return (nenner%teiler==0);
	}
	
	public static int[] generiereSieb(int maxZahl) {
		int berechneBis = (int) Math.sqrt(maxZahl);
		int[] sieb = new int[(int) Math.round(Math.sqrt(maxZahl))];
		sieb[0] = 2;
		for (int i = 1; i < sieb.length; i++) {
			for (int y = sieb[i-1]+1; i <= berechneBis; i++) {
				if (istPrimzahl(y, sieb)) {
					sieb[i] = y;
					break;
				}
			}
		}
		return sieb;
	}
	
	public static int ggT() {
		return 0;
	}
}

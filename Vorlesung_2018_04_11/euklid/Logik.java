package euklid;

public class Logik {
	static int zahl1 = 102;
	static int zahl2 = 150;
	public static void main(String[] args) {
		System.out.println("Euklid von "+zahl1+" und "+zahl2+": "+euklid_berechnen(zahl1,zahl2));
	}
	
	public static int euklid_berechnen(int z1, int z2) {
		while (z1 > 0 && z2 > 0) {
			if (z1 < z2) {
				int x = z1;
				z1 = z2;
				z2 = x;
			}
			z1 = z1 - z2;
		}
		
		if (z1 == 0 && z2 != 1) {
			return z2;
		}
		return 0;
	}
}

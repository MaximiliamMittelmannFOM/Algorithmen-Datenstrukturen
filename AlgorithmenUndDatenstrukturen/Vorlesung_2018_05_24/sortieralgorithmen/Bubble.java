package sortieralgorithmen;

public class Bubble {
	
	public static int[] sortiere(int[] a) {
		boolean sortiert = false;
		
		while (!sortiert) {
			sortiert = true;
			for (int i = 1; i < a.length; i++) {
				// wenn nicht sortiert
				if (a[i-1] > a[i]) {
					// vertauschen
					a[0] = a[i];
					a[i] = a[i-1];
					a[i-1] = a[0];
					
					// Sentinelposition zurücksetzen
					a[0] = -1;
					sortiert = false;
				}
			}
		}
		return a;
	}

}

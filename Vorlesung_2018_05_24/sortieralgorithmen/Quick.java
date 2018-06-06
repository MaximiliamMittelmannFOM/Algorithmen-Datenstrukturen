package sortieralgorithmen;

public class Quick {
	
	public static void sortiere(int[] a) {
		sortiere(a, 0, a.length - 1);
	}
	
	private static void sortiere(int[] a, int l, int r) {
		//Abbruchbedingung
		if (l < r) {
			//wähle zufällige Zahl (am besten die Letzte)
			int m = r;
			
			//Setze der Startvariablen für die Prüfungsiteratoren
			int li = l - 1;
			int ri = r; // kein +1, da letzte Zahl Mitte sein soll
			
			while (li < ri) {
				while (li < r && a[++li] < a[m]);
				while (ri > l && a[--ri] > a[m]);
				
				if (li >= ri) break;
				swap(a, li, ri);
			}
			//gewählte Zahl durch erste Zahl des rechten Bereichs tauschen
			swap(a, m, (a[m] < a[ri] ? ri : ri+1));
			
			sortiere(a, l, li-1);
			sortiere(a, ri+1, r);
		}
	}
	
	private static void swap(int[] a, int pos1, int pos2) {
		a[0] = a[pos1];
		a[pos1] = a[pos2];
		a[pos2] = a[0];
		a[0] = -1;
	}
}

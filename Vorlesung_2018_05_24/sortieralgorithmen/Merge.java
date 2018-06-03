package sortieralgorithmen;

public class Merge {
	
	public static void sortiere(int[] a) {
		sortiere(a, new int[a.length], 0, a.length-1, "");
	}
	
	private static void sortiere(int[] a, int[] b, int l, int r, String itTiefe) {
		if (l < r) {
			int m = (l+r)/2;
			sortiere(a, b, l, m, itTiefe+"  ");
			sortiere(a, b, m+1, r, itTiefe+"  ");
			merge(a, b, l, m, r, itTiefe);
		}
	}
	
	private static void merge(int[] a, int[] b, int l, int m, int r, String itTiefe) {
		for (int i = l; i <= m+1; i++) {
			b[i] = a[i];
		}
		
		int li = l, ri = m+1;
		for (int i = l; i <= r; i++) {
			a[i] = (ri > r || b[li] < a[ri] ? b[li++] : a[ri++]);
		}
	}
	
}

package sortieralgorithmen;

public class Merge {
	
	public static int[] sortiere(int[] a, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sortiere(a, l, m);
			sortiere(a, m+1, r);
		}
		return a;
	}
	
}

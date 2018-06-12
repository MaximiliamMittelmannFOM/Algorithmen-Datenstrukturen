package sortieralgorithmen;

import structures.List;
import structures.SimpleHeap;

public class Heap {
	
	public static List sortiereSimpel(List l) {
		SimpleHeap h = new SimpleHeap();
		while (!l.isEmpty()) {
			h.insert(l.delete_next().key);
		}
		
		List ret = new List();
		while (!h.isEmpty()) {
			ret.insert(h.removeRoot());
		}
		return l = ret;
	}
	
	
	public static void sortiereSimpel(int[] a) {
		SimpleHeap h = new SimpleHeap();
		for(int i = 0; i < a.length; i++) {
			h.insert(a[i]);
		}
		
		for (int i = 0; !h.isEmpty(); i++) {
			a[i] = h.removeRoot();
		}
	}
}

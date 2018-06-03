package bruteForceSearch;

public class Search {
	public static void main(String[] args) {
		System.out.println(search("HausBauDesTodes","Todes"));
	}
	
	public static int search(CharSequence word, CharSequence searched) {
		for (int i = 0; i < word.length() - (searched.length() - 1); i++) {
			for (int j = 0; j < searched.length() && word.charAt(i + j) == searched.charAt(j); j++) {
				if (j + 1 == searched.length()) return i;
			}
		}
		return -1;
	}
}

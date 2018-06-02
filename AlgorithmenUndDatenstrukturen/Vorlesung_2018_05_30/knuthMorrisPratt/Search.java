package knuthMorrisPratt;

public class Search {

	public static void main(String[] args) {
		CharSequence a = "Dies ist ein Test";
		CharSequence b = "ein";
		System.out.println(kmpSearch(a, b));
		
	}
	
	public static int[] kmpJumplist (CharSequence word) {
		// Variablen definieren
		int[] jl = new int[word.length() + 1];
		jl[0] = -1;
		
		// Jumpliste erstellen
		int i = 0, j = -1;
		while (i < word.length()) {
			while ((j > -1) && (word.charAt(i) != word.charAt(j))) {
				j = jl[j];
			}
			i++; j++;
			jl[i] = j;
		}
		
		return jl;
	}
	
	public static int kmpSearch (CharSequence sentence, CharSequence word) {
		// Variablen definieren
		int i = 0, j = 0;
		int[] jl = kmpJumplist(word);
		
		// Sentinel anhängen
		sentence = sentence + "" + word;
		
		//
		while ( j < word.length()) {
			while ((j > -1) && (sentence.charAt(i) != word.charAt(j))) {
				j = jl[j];
			}
			i++;
			j++;
		}
		//ermitteln ob der gefundenene Wert der Sentinel ist
		return (i < sentence.length() ? i - word.length() : -1 );
	}
}
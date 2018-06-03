package test;

public class Logik {

	public static void main(String[] args) {
		CharSequence satz = "Dies ist ein Test für die Suchmethoden.";
		CharSequence wort;
		
		
		System.out.println("Brute-Force-Testing");
		wort = "";
		System.out.println("Erwartetes Ergebnis -1: "+bruteForceSearch.Search.search(""+satz, wort));
		
		wort = "Dies";
		System.out.println("Erwartetes Ergebnis 0: "+bruteForceSearch.Search.search(""+satz, wort));
		
		wort = "Test";
		System.out.println("Erwartetes Ergebnis 13: "+bruteForceSearch.Search.search(""+satz, wort));
		
		wort = "Suchmethoden";
		System.out.println("Erwartetes Ergebnis 26: "+bruteForceSearch.Search.search(""+satz, wort));
		
		wort = ".";
		System.out.println("Erwartetes Ergebnis "+(satz.length()-1)+": "+bruteForceSearch.Search.search(""+satz, wort));
		
		wort = "nicht";
		System.out.println("Erwartetes Ergebnis -1: "+bruteForceSearch.Search.search(""+satz, wort));
		
		
		System.out.println("KMP-Search-Testing");
		wort = "";
		System.out.println("Erwartetes Ergebnis -1: "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
		
		wort = "Dies";
		System.out.println("Erwartetes Ergebnis 0: "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
		
		wort = "Test";
		System.out.println("Erwartetes Ergebnis 13: "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
		
		wort = "Suchmethoden";
		System.out.println("Erwartetes Ergebnis 26: "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
		
		wort = ".";
		System.out.println("Erwartetes Ergebnis "+(satz.length()-1)+": "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
		
		wort = "nicht";
		System.out.println("Erwartetes Ergebnis -1: "+knuthMorrisPratt.Search.kmpSearch(""+satz, wort));
	}
}

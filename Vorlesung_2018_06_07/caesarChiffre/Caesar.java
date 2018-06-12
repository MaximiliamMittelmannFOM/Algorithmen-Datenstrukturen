package caesarChiffre;

public class Caesar {
	
	public static String encrypt (String message, int shift, int base) {
		String crypt = "";
		for (int i = 0; i < message.length(); i++) {
			crypt += analyse(message.charAt(i), shift, base);
		}
		return crypt;
	}
	
	public static String decrypt (String message, int shift, int base) {
		return encrypt (message, -shift, base);
	}
	
	public static char analyse(char c, int shift, int base) {
		if (base < ('Z'+shift)) base = 'Z'+shift;
		return (char) toChar(((c-'a'+shift))%base+'a');
	}
	private static char toChar(int i) {
		return (char) i;
	}
}

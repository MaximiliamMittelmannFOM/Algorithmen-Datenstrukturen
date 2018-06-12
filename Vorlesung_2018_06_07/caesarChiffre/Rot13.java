package caesarChiffre;

public class Rot13 {
	
	public static String encrypt (String message) {
		String crypt = "";
		for (int i = 0; i < message.length(); i++) {
			crypt += analyse(message.charAt(i));
		}
		return crypt;
	}
	
	public static String decrypt (String message) {
		return encrypt (message);
	}
	
	public static char analyse(char c) {
		int shift = 13;
		int base = 26;
		char ret = c;
		if ('A' <= ret && ret <= 'Z') {
			ret = (char) toChar(((ret-'A'+shift))%base+'A');
		} else if ('a' <= ret && ret <= 'z') {
			ret = (char) toChar(((ret-'a'+shift))%base+'a');
		}
		return ret;
	}
	private static char toChar(int i) {
		return (char) i;
	}
}

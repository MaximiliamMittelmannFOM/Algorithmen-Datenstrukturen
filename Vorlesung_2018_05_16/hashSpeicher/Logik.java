package hashSpeicher;

public class Logik {
	public static void main(String[] args) {
		System.out.println("ALGORITHMUS als Hash mit Basis 30 und Modulo 97: "+generate_hash("ALGORITHMUS".toCharArray(), 30, 97));
	}
	
	public static int generate_hash(char[] key, int base, int modulo) {
		int ret = 0;
		for (int i = 0; i < key.length-1; i++) {
			ret = ((ret + getValue(key[i]))*base)%modulo;
		}
		ret = (ret + getValue(key[key.length-1]))%modulo;
		return ret;
	}
	private static int getValue(char c) {
		return -64 + c;
	}
}

package caesarChiffre;

public class Test {
	public static void main(String[] args) {
		String message = "Hallo Welt. Das ist ein Test.";
		int shift = 20;
		int base = 0;
		System.out.println("Caesar");
		System.out.println(message);
		System.out.println(Caesar.encrypt(message, shift, base));
		System.out.println(Caesar.decrypt(Caesar.encrypt(message, shift, base),shift ,base));
		
		System.out.println("\nRot13");
		System.out.println(message);
		System.out.println(Rot13.encrypt(message));
		System.out.println(Rot13.decrypt(Rot13.encrypt(message)));
	}
}

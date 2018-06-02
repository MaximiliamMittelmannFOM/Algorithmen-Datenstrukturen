package iterativ;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println("Fibonacci von 10 rekursiv: " + fibonacci_rekursiv(10));
		System.out.println("Fibonacci von 10 iterativ: " + fibonacci_iterativ(10));
		
		System.out.println("Fibonacci von 8 rekursiv: " + fibonacci_rekursiv(8));
		System.out.println("Fibonacci von 8 iterativ: " + fibonacci_iterativ(8));
		
	}
	
	public static int fibonacci_rekursiv(int i) {
		if (i < 2) return 1;
		return fibonacci_rekursiv(i-2) + fibonacci_rekursiv(i-1);
	}
	
	public static int fibonacci_iterativ(int in) {
		int f = 1;
		int fv = 1;
		int t;
		
		for (int i = 1; i < in; i++) {
			t = f;
			f = fv + t;
			fv = t;
		}
		
		return f;
	}
}
package stackAlsArray;

public class Logik {
	public static void main(String[] args) {
		StackArray stack = new StackArray();
		
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Zahl an Stack eingefügt: "+i);
			stack.push(i);
		}
		
		while (!(stack.isEmpty())) System.out.println("Zahl aus Stack genommen: "+stack.pull());
	}
}

package queueFunktionen;

public class Logik {
	public static void main(String[] args) {
		Queue schlange = new Queue();
		
		for (int i = 0; i < 10; i++) {
			System.out.println("Zahl an Schlange angefügt: "+i);
			schlange.push(i);
		}
		
		while (!(schlange.isEmpty())) System.out.println("Zahl aus Schlange genommen: "+schlange.pull());
	}
}

package iterativ;

import structures.Stack;

public class TuermeVonHanoi {
	
	public static void main(String[] args) {
		System.out.println("Jetzt rekursiv");
		rekursiv(2, "A", "B", "C");
		
		System.out.println("Jetzt iterativ");
		iterativ(2, "A", "B", "C");
	}

	
	public static void rekursiv(int count, String t1, String t2, String t3) {
		if (count == 1) {
			System.out.println("Von "+t1+" nach "+t2+" verschieben.");
		} else {
			rekursiv(count-1, t1, t3, t2);
			rekursiv(1,t1,t2,t3);
			rekursiv(count-1,t3,t2,t1);
		}
		
	}
	
	public static void iterativ(int count, String t1, String t2, String t3) {
		Stack buffer = new Stack();
		pushToStack(buffer,t1,t2,t3,count);
		
		while (true) {
			while (count > 1) {
				pushToStack(buffer,t1,t2,t3,count);
				swap(t2, t3);
				count--;
			}
			show(t1,t2);
			count = buffer.pop().key;
			t3 = buffer.pop().value;
			t2 = buffer.pop().value;
			t1 = buffer.pop().value;
			
			if (buffer.isEmpty()) break;
			show(t1, t2);
			count--;
			swap(t1,t3);
		}	
	}
	
	private static void pushToStack(Stack b, String t1, String t2, String t3, int n) {
		b.push(t1);
		b.push(t2);
		b.push(t3);
		b.push(n);
	}
	private static void swap(String a, String b) {
		String t = a;
		a = b;
		b = t;
	}
	private static void show(String a, String b) {
		System.out.println("Von "+a+" nach "+b+" verschieben.");
	}
}

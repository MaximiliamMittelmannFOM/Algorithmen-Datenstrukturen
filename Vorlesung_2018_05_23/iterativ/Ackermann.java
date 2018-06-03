package iterativ;

import structures.Stack;

public class Ackermann {
	
	int[][] memory;
	
	public static void main(String[] args) {
		System.out.println("Ackermann_rekursiv von 0,0 soll 1 : "+rekursiv(0,0));
		System.out.println("Ackermann_rekursiv von 3,1 soll 13: "+rekursiv(3,1));
		System.out.println("Ackermann_iterativ von 0,0 soll 1: "+iterativ(0,0));
		System.out.println("Ackermann_iterativ von 3,1 soll 13: "+iterativ(3,1));
		System.out.println("Ackermann_iterativ von 0,1 soll 2: "+iterativ(0,1));
		System.out.println("Ackermann_iterativ von 2,2 soll 7: "+iterativ(2,2));
		//System.out.println("Ackermann_iterativ von 4,1 soll 65533: "+iterativ(4,1));
		System.out.println("Ackermann_iterativ von 5,1 soll ?????: "+iterativ(5,1));
	}
	
	public static int rekursiv(int m, int n) {
		if (m == 0) return n+1;
		if (n == 0) return rekursiv(m-1,1);
		return rekursiv(m-1, rekursiv(m, n-1));
	}
	
	public static int iterativ(int m, int n) {
		Stack buffer = new Stack();
		
		buffer.push(m);
		buffer.push(n);
		
		while (true) {
			n = buffer.pop().key;
			m = buffer.pop().key;
			
			if (m == -1) return n;
			if (m == 0) {
				buffer.push(n+1);
			} else if (n == 0) {
				buffer.push(m-1);
				buffer.push(1);
			} else {
				buffer.push(m-1);
				buffer.push(m);
				buffer.push(n-1);
			}
		}
	}
}

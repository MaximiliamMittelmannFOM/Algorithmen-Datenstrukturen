package stackAlsArray;

public class StackArray{
	static int[] stack;
	public StackArray() {
		stack = new int[0];
	}
	
	public boolean isEmpty() {
		return stack.length == 0;
	}
	
	public int pull() {
		if (stack.length == 0) {return 0;}
		
		int ret = stack[0];
		int[] tempStack = new int[stack.length-1];
		for (int i = 0; i < tempStack.length; i++) {
			tempStack[i] = stack[i+1];
		}
		stack = tempStack;
		return ret;
	}
	
	public void push(int neueZahl) {
		int[] tempStack = new int[stack.length+1];
		
		tempStack[0] = neueZahl;
		for (int i = 0; i < stack.length; i++) {
			tempStack[1+i] = stack[i];
		}
		stack = tempStack;
	}
}

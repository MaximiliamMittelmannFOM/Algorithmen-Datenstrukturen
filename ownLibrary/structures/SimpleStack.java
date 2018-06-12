package structures;

public class SimpleStack {
	
	int size;
	int[] storage;
	
	public SimpleStack(int size) {
		storage = new int[size];
		storage[0] = -1;
		this.size = 0;
	}
	public SimpleStack() {
		this(1);
	}
	
	public void push(int value) {
		if ((size + 1) >= storage.length) extend(storage.length*2);
		storage[++size] = value;
	}
	
	public int pop() {
		int ret = storage[size];
		storage[size--] = 0;
		return ret;
	}
	
	public void extend(int newSize) {
		if (newSize > storage.length) {
			int[] replace = new int[newSize];
			for (int i = 0; i < storage.length; i++) {
				replace[i] = storage[i];
			}
			
			storage = replace;
		}
	}

}

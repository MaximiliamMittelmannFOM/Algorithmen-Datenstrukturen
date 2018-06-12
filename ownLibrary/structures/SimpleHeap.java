package structures;

public class SimpleHeap {
	
	int size;
	int[] storage;
	
	public SimpleHeap (int newSize) {
		storage = new int[newSize];
		storage[0] = -1;
		this.size = 0;
	}
	
	public SimpleHeap () {
		this(1);
	}
	
	public void insert(int newValue) {
		if (size + 1 >= storage.length) extend(storage.length*2);
		storage[++size] = newValue;
		upheap(size);
	}
	
	public int removeRoot() {
		int ret = storage[1];
		if (size > 0) {
			storage[1] = storage[size--];
			downheap(1);
			return ret;
		}
		return 0;
	}
	
	public void upheap (int pos) {
		while (storage[pos] < storage[pos/2]) {
			swap(pos, pos/2);
			pos /= 2;
		}
	}
	
	public void downheap (int pos) { /* ascending */
		while(pos <= size/2) {
			if (storage[pos*2] >= storage[pos] && storage[pos*2+1] >= storage[pos]) break;
			if (storage[pos*2] < storage[pos*2+1]) {
				swap(pos, pos*2);
				pos *= 2;
			} else {
				swap(pos, pos*2+1);
				pos = pos*2 + 1;
			}
		}
	}
	
	public boolean isEmpty() {
		return (size == 0);
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
	
	private void swap(int pos1, int pos2) {
		int temp = storage[pos1];
		storage[pos1] = storage[pos2];
		storage[pos2] = temp;
	}
		
	public SimpleStack toStack() {
		return toStack(1);
	}
	private SimpleStack toStack(int pos) {
		SimpleStack s = new SimpleStack();
		while (!isEmpty()) {
			s.push(removeRoot());
		}
		return s;
	}
	
	public void toHeap(int[] a) {
		this.storage = a;
		this.size = a.length;
		for (int i = 0; i < a.length; i++) {
			downheap(1);
		}
	}
	
	public void print() {
		print("lineorder");
	}
	private void printLineOrder(int pos) {
		if (pos <= size) {
			System.out.println(storage[pos]);
			printLineOrder(pos*2);
			printLineOrder(pos*2+1);
		}
	}
	public void print(String type) {
		if (type.equals("inorder")) printInOrder(1);
		if (type.equals("lineorder")) printLineOrder(1);
	}
	private void printInOrder(int pos) {
		if (pos <= size) {
			printInOrder(pos*2);
			System.out.println(storage[pos]);
			printInOrder(pos*2+1);
		}
	}
}

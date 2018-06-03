package structures;

public class Queue extends List {
	
	
	public Queue() {
		super();
	}
	public Queue(int key) {
		this();
		append(key);
	}
	
	public Node append(int key) {
		return append(new Node(key));
	}
	
	public Queue append(Queue other) {
		Node last = head;
		Node saveTheTail = tail;
		while (last.next != tail) last = last.next;
		
		while(!other.isEmpty()) {
			last.next = other.dequeue();
			last = last.next;
		}
		tail = last.next = saveTheTail;
		return this;
	}
	public Node append(Node newNode) {
		Node last = head;
		while (last.next != tail) last = last.next;
		Node temp = last.next;
		last.next = newNode;
		newNode.next = temp;
		return newNode;
	}
	
	public Node dequeue() {
		return super.delete_next(head);
	}
}

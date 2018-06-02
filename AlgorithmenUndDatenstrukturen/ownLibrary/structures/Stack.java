package structures;

public class Stack extends List {
	
	public Stack() {
	}
	
	public Stack(int first) {
		this();
		push(first);
	}
	
	public Node pop() {
		return super.delete_next(head);
	}
	
	public Node push(Node newNode) {
		return super.insert_after(newNode, head);
	}
	public Node push(int key, String content) {
		return push(new Node(key, content));
	}
	public Node push(int key) {
		return push(new Node(key));
	}
	public Node push(String content) {
		return push(new Node(0,content));
	}
}

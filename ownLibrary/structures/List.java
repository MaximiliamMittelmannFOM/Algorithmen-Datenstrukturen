package structures;

public class List {
	public Node head;
	public Node tail;
	
	public List() {
		head = new Node().reset();
		
		tail = new Node().reset();
		tail.next = tail;
		head.next = tail; 
	}
	
	public List(int first) {
		this();
		insert_after(first, head);
	}
	
	public Node insert_after(Node newNode, Node prevNode) {
		newNode.next = prevNode.next;
		return prevNode.next = newNode;
	}
	public Node insert_after(int key, Node prevNode) {
		return insert_after(new Node(key), prevNode);
	}
	public void insert(int val) {
		insert_after(val, head);
	}
	
	public Node delete_next(Node n) {
		Node temp = n.next;
		n.next = n.next.next;
		if(temp != tail) temp.next = null;
		return temp;
	}
	
	public Node search_refNode(Node s, String usingVariables) {
		tail.copyValuesFrom(s,usingVariables);
		Node refNode = head;
		while (!refNode.next.equals(s,usingVariables)) refNode = refNode.next;
		tail.reset();
		return refNode;
	}
	
	public Node search_refNode (int key) {
		return search_refNode(new Node(key),"key");
	}
	public Node search (int key) {
		return search_refNode(key).next;
	}
	
	public boolean hasValue(int key) {
		return (search(key) != tail);
	}
	
	public boolean isEmpty() {
		return (head.next == tail);
	}
}

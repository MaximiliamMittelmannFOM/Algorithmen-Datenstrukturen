package structures;

public class Ring extends List {
	public Ring() {
		super();
		tail.next = head.next;
	}
	
	public int count_element(Node n, String usingVariables) {
		Node searchNode = head.next;
		int count = 0;
		while (searchNode != tail) {
			if (searchNode.equals(n,usingVariables)) count++;
			searchNode = searchNode.next;
		}
		return count;
	}
	public int count_element(int key) {
		return count_element(new Node(key), "key");
	}
}

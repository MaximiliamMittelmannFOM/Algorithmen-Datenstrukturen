package structures;

public class Node {
	
	public int key;
	public String value;

	public Node next;
	
	public Node (int k, String c, Node n) {
		key = k;
		value = c;
		next = n;
	}
	
	public Node (int k, String c) {
		this(k, c, null);
	}
	
	public Node (int k, Node n) {
		this(k, "", n);
	}
	
	public Node (int k) {
		this(k, "", null);
	}
	
	public Node () {
		this(-1);
	}
	
	public boolean equals(Node n) {
		return this.equals(n,"all");
	}
	
	public boolean equals(Node n, String usingVariables) {
		return (usingVariables.contains("all") || usingVariables.contains("key")     ? this.key == n.key              : true)
			&& (usingVariables.contains("all") || usingVariables.contains("content") ? this.value.equals(n.value) : true);
	}
	
	public Node copyValuesFrom(Node n, String usingVariables) {
		if (usingVariables.contains("all") || usingVariables.contains("key")) {this.key = n.key;}
		if (usingVariables.contains("all") || usingVariables.contains("content")) {this.value = n.value;}
		return this;
	}
	
	public Node reset() {
		key = -1;
		value = "";
		
		return this;
	}
	
	public String toString() {
		return "Node:(key:"+key+";value"+value+")";
	}
}

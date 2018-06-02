package structures;

public class TreeNode extends Node {
	
	TreeNode nextL;
	TreeNode nextR;
	
	
	public TreeNode(Node n) {
		super(n.key, n.content, n.next);
		
		nextL = null;
		nextR = null;
	}
	public TreeNode() {
		super();
		
		nextL = null;
		nextR = null;
	}
	
	public TreeNode(int key) {
		this(new Node(key));
	}
	
}

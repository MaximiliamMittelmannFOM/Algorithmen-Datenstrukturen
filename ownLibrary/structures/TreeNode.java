package structures;

public class TreeNode {
	
	Node content;
	
	TreeNode nextL;
	TreeNode nextR;
	
	public TreeNode(Node n) {
		content = n;
		nextL = null;
		nextR = null;
	}
	public TreeNode(int key) {
		this(new Node(key));
	}
	public TreeNode() {
		this(new Node());
	}

	
	public TreeNode copyValuesFrom(TreeNode tn, String usingVariables) {
		content.copyValuesFrom(tn.content, usingVariables);
		if (usingVariables.contains("all") || usingVariables.contains("nextR")) {this.nextR = tn.nextR;}
		if (usingVariables.contains("all") || usingVariables.contains("nextL")) {this.nextL = tn.nextL;}
		return this;
	}
	
	
	public String toString() {
		return "TreeNode("+content.toString()+")";
	}
}

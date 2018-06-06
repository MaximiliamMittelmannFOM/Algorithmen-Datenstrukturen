package structures;

public class BinaryTree {
	TreeNode root;
	TreeNode leaf;
	
	public BinaryTree() {
		root = new TreeNode(-1);
		leaf = new TreeNode();
		leaf.nextL = leaf.nextR = leaf;
		
		root.nextL = root.nextR = leaf;
	}
	
	public TreeNode insert(TreeNode t) {
		t.nextL = t.nextR = leaf;
		TreeNode point = root;
		while (point.nextL != leaf && point.nextR != leaf) {
			if (t.key < point.key) point = point.nextL;
			if (t.key >= point.key) point = point.nextR;
		}
		point = t;
		return point;
	}
	
	public TreeNode insert(Node t) {
		return insert((TreeNode) t);
	}
	
	//Nicht vollständig. Löschen implementieren?
}

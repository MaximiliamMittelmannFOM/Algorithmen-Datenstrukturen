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
		TreeNode ref, point;
		ref = root;
		point = root.nextR;
		
		//entsprechenden Leaf-Pointer suchen
		while (point != leaf) {
			ref = point;
			point = (t.content.key < point.content.key) ? point.nextL : point.nextR;
		}
		
		t.nextR = t.nextL = leaf;
		point = t;
		
		//neue Node einfügen
		if (t.content.key < ref.content.key) ref.nextL = point;
		else ref.nextR = point;
		
		return point;
	}
	
	/*public TreeNode insert(TreeNode t) {
		t.nextL = t.nextR = leaf;
		TreeNode point = root.nextR;
		//Suche passende Position welche noch ein Leaf ist
		while (point.nextL != leaf && point.nextR != leaf) {
			if (t.key < point.key) point = point.nextL;
			if (t.key >= point.key) point = point.nextR;
		}
		point.copyValuesFrom(t,"all");
		return point;
	}*/
	
	public TreeNode insert(Node n) {
		return insert(new TreeNode(n));
	}
	public TreeNode insert(int key) {
		return insert(new Node(key));
	}
	
	//Nicht vollständig. Löschen implementieren?
	
	public void delete(int key) {
		//Pointer erzeugen (Fixing, Referrenz, Aktuell und temporär)
		TreeNode fix, ref, point, temp;
		leaf.content.key = key;
		ref = root; //Referrenzpointer
		point = root.nextR; //Pointer auf die bearbeitete TreeNode
		
		//Den Wert der Node suchen
		while (key != point.content.key) {
			ref = point;
			point = (key < point.content.key) ? point.nextL : point.nextR;
		}
		
		temp = point;
		//Wenn der rechte Child ein Leaf ist, wird der zu löschende durvh sein linkes Child ersetzt
		if (temp.nextR == leaf) point = point.nextL;
		else if (temp.nextR.nextL == leaf) {
			point = point.nextR;
			point.nextL = temp.nextL;
		} else {
			//Es benötigt ein komplizierteres Fixing des Baumes
			fix = point.nextR;
			while (fix.nextL.nextL != leaf) fix = fix.nextL;
			point = fix.nextL;
			fix.nextR = point.nextR;
			point.nextL = temp.nextL;
			point.nextR = temp.nextR;
		}
		if (key < ref.content.key) ref.nextL = point;
		else ref.nextR = point;
		
		leaf.content.reset();
	}
	
	public void switchContent (TreeNode  a, TreeNode b) {
		Node temp = a.content;
		a.content = b.content;
		b.content = temp;
	}
	
	public boolean isEmpty() {
		return root.nextR == leaf;
	}
	
	public Stack toStack() {
		Stack s = new Stack();
		toStack(root.nextR, s);
		return s;
	}
	private void toStack(TreeNode point, Stack s) {
		if (point != leaf) {
			toStack(point.nextR, s);
			s.push(point.content.key);
			toStack(point.nextL, s);
		}
	}
}

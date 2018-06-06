package structures;

public class Ring {
	
	private Node ringStart;
	private Node ringEnd;
	
	public Ring() {
		ringStart = null;
		ringEnd = null;
	}
	
	/**
	 * Checks wether the ring is empty by checking the ringStart variable to be null
	 * @return True when the ring is empty
	 */
	public boolean isEmpty() {
		return (ringStart == null);
	}
	
	public Node insert_afterValue(int key, int newKey) {
		return insert_after(newKey, search_referingNode(key));
	}
	
	/**
	 * Method for inserting new Nodes
	 * @param key Value of the new Node
	 * @param node Node after which the new Node shall be inserted
	 * @return Node which has the inserted Node as following Node
	 */
	private Node insert_after (int key, Node node) {
		Node nodeNew = new Node(key);
		
		nodeNew.next = node.next;
		node.next = nodeNew;
		
		if (node == ringEnd) ringEnd = nodeNew;
		
		return node;
	}
	
	/**
	 * Method for inserting new Nodes
	 * When the ring is empty this method insert the first Node
	 * else this methods appends a new Node to the end of the ring
	 * @param key Value of the new Node
	 * @return Node which has the inserted Node as following Node
	 */
	public Node insert (int key) {
		Node returnNode =  new Node(key);
		if (isEmpty()) {
			returnNode =  new Node(key);
			returnNode.next = returnNode;
			ringStart = returnNode;
			ringEnd = returnNode;
		} else {
			returnNode = insert_after(key, ringEnd); 
		}
		return returnNode;
	}
	
	/**
	 *  Deletes the following Node
	 * @param referingNode Reference of the Node which shall be deleted
	 */
	private void delete_next(Node referingNode) {
		if (referingNode == referingNode.next) {
			referingNode.next = null;
			ringStart = null;
			ringEnd = null;
		} else {
			if (referingNode.next == ringEnd) ringEnd = referingNode;
			if (referingNode.next == ringStart) ringStart = referingNode.next.next;
			
			Node nextnext = referingNode.next.next;
			referingNode.next.next = null;
			referingNode.next = nextnext;
		}
	}
	
	/**
	 * Deletes the first occurrence if the given value
	 * @param key Value which shall be deleted
	 * @return Wether the value was deleted or not
	 */
	public boolean delete_first(int key) {
		if (has_value(key)) {
			delete_next(search_referingNode(key));
			return true;
		}
		return false;
	}
	
	/**
	 * Searches the given value in the ring using sentinel
	 * @param key Value which is searched
	 * @return Wether the value was found or not
	 */
	public boolean has_value(int key) {
		boolean vorhanden;
		Node sentinelReferingNode = insert(key);
		vorhanden = !(search_referingNode(key) == sentinelReferingNode);
		delete_next(sentinelReferingNode);
		return vorhanden;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public int count(int key) {
		int count = 0;

		Node searchNode = ringStart;
		do {
			if (searchNode.key == key) count++;
			searchNode = searchNode.next;
		} while	(searchNode != ringStart);
		
		return count;
	}
	
	/**
	 * Uses search_referingNode to search the value
	 * This method NEEDS the searched value to be in the ring
	 * @param key Searched value
	 * @return Node which has the searched Value
	 */
	@SuppressWarnings("unused")
	private Node search_node(int key) {
		return search_referingNode(key).next;
	}
	
	/**
	 * Searches a value in the ring
	 * This method NEEDS the searched value to be in the ring
	 * @param key Value which is searched
	 * @return Node which has the reference to the Node with the searched value
	 */
	private Node search_referingNode(int key) {
		Node referingNode = ringStart;
		if (referingNode.key == key) return ringEnd;
		while (referingNode.next.key != key) referingNode = referingNode.next;
		return referingNode;
	}
}

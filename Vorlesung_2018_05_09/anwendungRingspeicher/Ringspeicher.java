package anwendungRingspeicher;

public class Ringspeicher {

	private class Node {
		int value;
		Node next;
		
		private Node(int nodeValue) {
			value = nodeValue;
			next = null;
		}
	}
	
	private Node ringStart;
	private Node ringEnd;
	
	public Ringspeicher() {
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
	
	/**
	 * Method for inserting new Nodes
	 * @param nodeValue Value of the new Node
	 * @param node Node after which the new Node shall be inserted
	 * @return Node which has the inserted Node as following Node
	 */
	public Node insert_after (int nodeValue, Node node) {
		Node nodeNew = new Node(nodeValue);
		
		nodeNew.next = node.next;
		node.next = nodeNew;
		
		if (node == ringEnd) ringEnd = nodeNew;
		
		return node;
	}
	
	/**
	 * Method for inserting new Nodes
	 * When the ring is empty this method insert the first Node
	 * else this methods appends a new Node to the end of the ring
	 * @param nodeValue Value of the new Node
	 * @return Node which has the inserted Node as following Node
	 */
	public Node insert (int nodeValue) {
		Node returnNode =  new Node(nodeValue);
		if (isEmpty()) {
			returnNode =  new Node(nodeValue);
			returnNode.next = returnNode;
			ringStart = returnNode;
			ringEnd = returnNode;
		} else {
			returnNode = insert_after(nodeValue, ringEnd); 
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
	 * @param nodeValue Value which shall be deleted
	 * @return Wether the value was deleted or not
	 */
	public boolean delete_first(int nodeValue) {
		if (has_value(nodeValue)) {
			delete_next(search_referingNode(nodeValue));
			return true;
		}
		return false;
	}
	
	/**
	 * Searches the given value in the ring using sentinel
	 * @param nodeValue Value which is searched
	 * @return Wether the value was found or not
	 */
	public boolean has_value(int nodeValue) {
		boolean vorhanden;
		Node sentinelReferingNode = insert(nodeValue);
		vorhanden = !(search_referingNode(nodeValue) == sentinelReferingNode);
		delete_next(sentinelReferingNode);
		return vorhanden;
	}
	
	/**
	 * 
	 * @param nodeValue
	 * @return
	 */
	public int count(int nodeValue) {
		int count = 0;

		Node searchNode = ringStart;
		do {
			if (searchNode.value == nodeValue) count++;
			searchNode = searchNode.next;
		} while	(searchNode != ringStart);
		
		return count;
	}
	
	/**
	 * Uses search_referingNode to search the value
	 * This method NEEDS the searched value to be in the ring
	 * @param nodeValue Searched value
	 * @return Node which has the searched Value
	 */
	/*private Node search_node(int nodeValue) {
		return search_referingNode(nodeValue).next;
	}*/
	
	/**
	 * Searches a value in the ring
	 * This method NEEDS the searched value to be in the ring
	 * @param nodeValue Value which is searched
	 * @return Node which has the reference to the Node with the searched value
	 */
	private Node search_referingNode(int nodeValue) {
		Node referingNode = ringStart;
		if (referingNode.value == nodeValue) return ringEnd;
		while (referingNode.next.value != nodeValue) referingNode = referingNode.next;
		return referingNode;
	}
}

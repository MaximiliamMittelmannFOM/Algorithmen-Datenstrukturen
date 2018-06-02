package hashSpeicher;

public class HashSpeicher {
	private class List {
		private class Node {
			String key;
			String value;
			Node next;
			
			private Node() {
			}
			
			private Node(String val) {
				key = val;
			}
			
			private Node(String val, Node nex) {
				this(val);
				next = nex;
			}
		}
		
		Node head;
		Node tail;
		
		private List() {
			head = new Node();
			head.next = head;
			tail = head;
		}
		
		private List(String val) {
			this();
			tail.key = val;
		}
		
		@SuppressWarnings("unused")
		private void insert(String val) {
			head = new Node(val, head);
		}
		
		@SuppressWarnings("unused")
		private String searchValue (String key) {
			tail.key = key;
			Node searchNode = head;
			while (searchNode.key != key) searchNode = searchNode.next;
			if (searchNode != tail) return searchNode.value;
			return "";
		}
	}
	
	int modulo;
	int base;
	List[] ListHeads;
	
	
	public HashSpeicher(int mod, int bas) {
		modulo = mod;
		base = (bas >= 26) ? bas : 26;
		ListHeads = new List[mod];
	}
	
	public int generate_hash(char[] key) {
		int ret = 0;
		for (int i = 0; i < key.length-1; i++) {
			ret = ((ret + getValue(key[i]))*base)%modulo;
		}
		ret = (ret + getValue(key[key.length-1]))%modulo;
		return ret;
	}
	private int getValue(char c) {
		return -64 + c;
	}
	
	@SuppressWarnings("unused")
	private char[] invert(char[] c) {
		char[] ret = new char[c.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = c[c.length-1-i];
		}
		return ret;
	}
}

package queueFunktionen;


public class Queue {
	private class Node {
		int wert;
		Node next; 
		
		private Node() {
			wert = 0;
			next = null;
		}
		private Node(int NodeWert) {
			wert = NodeWert;
			next = null;
		}
	}
	
	private Node ende;
	private Node anfang;
	
	public Queue() {
		ende = null;
		anfang = null;
	}
	
	public Queue(int erster) {
		anfang = new Node(erster);
		ende = anfang;
	}
	
	public void push(int NodeWert) {
		Node neu = new Node(NodeWert);
		if (isEmpty()) {
			anfang = neu;
			ende = anfang;
		} else {
			ende.next = neu;
			ende = neu;
		}
	}
	public int pull() {
		if (isEmpty()) return 0;
		int ret = anfang.wert;
		if (anfang == ende) {
			ende = null;
			anfang = null;
		} else {
			anfang = anfang.next;
		}
		return ret;
	}
	
	public boolean isEmpty() {
		return (anfang == null);
	}
}

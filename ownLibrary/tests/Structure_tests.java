package tests;

import structures.*;

public class Structure_tests {
	
	public static void main(String[] args) {
		
		System.out.println("Test started!");
		test_node();
		test_list();
		test_stack();
		test_queue();
		test_ring();
		test_binaryTree();
		test_simpleHeap();
		System.out.println("Test done!");
	}
	
	public static boolean test_this(String message, int a, int b) {
		boolean ret = (a == b);
		if (!ret) System.err.println("Test '"+message+"' failed | Values: "+a+", "+b);
		return ret;
	}
	public static boolean test_this(String message, boolean b) {
		boolean ret = b;
		if (!ret) System.err.println("Test '"+message+"' failed");
		return ret;
	}
	
	public static void test_node() {
		Node a = new Node(1,"abcd");
		Node b = new Node(1,"abcd");
		test_this("Nodes are equal",a.equals(b,"key"));
		test_this("Nodes are equal",a.equals(b,"content"));
		test_this("Nodes are equal",a.equals(b,"key;content"));
		test_this("Nodes are equal",a.equals(b,"all"));
		
		Node c = new Node(2,"efgh");
		Node d = new Node().copyValuesFrom(c,"key;content");
		test_this("Nodes are equal",c.equals(d,"key"));
		test_this("Nodes are equal",c.equals(d,"content"));
		test_this("Nodes are equal",c.equals(d,"key;content"));
		test_this("Nodes are equal",c.equals(d,"all"));
		
		test_this("Nodes are not equal",!a.equals(c,"key"));
		test_this("Nodes are not equal",!a.equals(c,"content"));
		test_this("Nodes are not equal",!a.equals(c,"key;content"));
		test_this("Nodes are not equal",!a.equals(c,"all"));
		
		a.reset();
		test_this("Reset Node has estimated values",a.equals(new Node(-1,"")));
	}
	
	public static void test_list() {

		List l = new List();
		
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		
		test_this("1 in List",l.hasValue(1));
		test_this("2 in List",l.hasValue(2));
		test_this("3 in List",l.hasValue(3));
		test_this("4 in List",l.hasValue(4));
		test_this("5 not in List",!(l.hasValue(5)));
		
		l.insert(10);
		l.insert(11);
		l.insert_after(12, l.search(11));
		l.insert_after(13, l.search(12));
		l.delete_next(l.search_refNode(12));
		
		test_this("10 in List",l.hasValue(10));
		test_this("11 in List",l.hasValue(11));
		test_this("12 not in List",!(l.hasValue(12)));
		test_this("13 in List",l.hasValue(13));
		
		int[] estimated = new int[7];
		estimated[6] = 1;
		estimated[5] = 2;
		estimated[4] = 3;
		estimated[3] = 4;
		estimated[2] = 10;
		estimated[1] = 13;
		estimated[0] = 11;
		
		Node n = l.head.next;
		int i = 0;
		while (n != l.tail) {
			test_this("Value match",n.key,estimated[i]);
			n = n.next;
			i++;
		}
	}
	public static void test_stack() {
		Stack s = new Stack();
		
		test_this("empty Stack is empty",s.isEmpty());
		
		s.push(1);
		
		test_this("one item Stack is not empty",!(s.isEmpty()));
		
		s.push(2);
		s.push(3);
		s.push(4);
		
		s.pop();
		s.push(5);
		s.push(6);
		
		int[] estimated = new int[5];
		estimated[4] = 1;
		estimated[3] = 2;
		estimated[2] = 3;
		estimated[1] = 5;
		estimated[0] = 6;
		
		test_this("full Stack not is empty",!(s.isEmpty()));
		
		int i = 0;
		while (!(s.isEmpty())) {
			test_this("Value match",s.pop().key,estimated[i]);
			i++;
		}
		
		test_this("emptied Stack is empty",s.isEmpty());
	}

	public static void test_queue() {
		Queue q = new Queue();
		
		test_this("empty Queue is empty",q.isEmpty());
		
		q.append(1);
		
		test_this("one item Queue is not empty",!(q.isEmpty()));
		
		q.append(2);
		q.append(3);
		q.append(4);
		
		test_this("first dequeued is 1",q.dequeue().key,1);
		test_this("second dequeued is 2",q.dequeue().key,2);
		
		q.append(5);
		q.append(6);
		
		int[] estimated = new int[4];
		estimated[0] = 3;
		estimated[1] = 4;
		estimated[2] = 5;
		estimated[3] = 6;
		
		for (int i = 0; i < estimated.length; i++) {
			test_this("dequeued item is "+estimated[i],q.dequeue().key,estimated[i]);
		}
		
		test_this("emptied Queue is empty",q.isEmpty());
		
		Queue q1 = new Queue();
		q1.append(1);
		q1.append(2);
		q1.append(3);
		
		Queue q2 = new Queue();
		q2.append(4);
		q2.append(5);
		q2.append(6);
		
		q1.append(q2);
		
		estimated = new int[6];
		estimated[0] = 1;
		estimated[1] = 2;
		estimated[2] = 3;
		estimated[3] = 4;
		estimated[4] = 5;
		estimated[5] = 6;
		
		test_this("extended Queue is not empty",!q1.isEmpty());
		test_this("appended Queue is empty",q2.isEmpty());
		
		for (int i = 0; i < estimated.length; i++) {
			test_this("extended Queue-Item is "+estimated[i],q1.dequeue().key,estimated[i]);
		}
			
	}
	
	public static void test_ring() {
		Ring ring = new Ring();
		ring.insert(1);
		ring.insert(2);
		ring.insert(3);
		ring.insert(4);
		ring.insert(5);
		ring.insert(6);
		ring.insert(7);
		ring.insert(8);
		ring.insert(9);
		
		test_this("Ring has value 1",ring.has_value(1));
		test_this("Ring has value 2",ring.has_value(2));
		test_this("Ring has value 3",ring.has_value(3));
		test_this("Ring has value 4",ring.has_value(4));
		test_this("Ring has value 5",ring.has_value(5));
		test_this("Ring has value 6",ring.has_value(6));
		test_this("Ring has value 7",ring.has_value(7));
		test_this("Ring has value 8",ring.has_value(8));
		test_this("Ring has value 9",ring.has_value(9));
		
		ring.delete_first(1);
		ring.delete_first(4);
		ring.delete_first(5);
		ring.delete_first(9);
		
		test_this("Ring has not value 1",!ring.has_value(1));
		test_this("Ring has value 2",ring.has_value(2));
		test_this("Ring has value 3",ring.has_value(3));
		test_this("Ring has not value 4",!ring.has_value(4));
		test_this("Ring has not value 5",!ring.has_value(5));
		test_this("Ring has value 6",ring.has_value(6));
		test_this("Ring has value 7",ring.has_value(7));
		test_this("Ring has value 8",ring.has_value(8));
		test_this("Ring has not value 9",!ring.has_value(9));
		
		ring.insert(1);
		ring.insert(2);
		ring.insert(3);
		ring.insert(4);
		ring.insert(5);
		ring.insert(6);
		ring.insert(7);
		ring.insert(8);
		ring.insert(9);
		
		test_this("Ring has value 1 once", ring.count(1), 1);
		test_this("Ring has value 2 twice", ring.count(2), 2);
		test_this("Ring has value 3 twice", ring.count(3), 2);
		test_this("Ring has value 4 once", ring.count(4), 1);
		test_this("Ring has value 5 once", ring.count(5), 1);
		test_this("Ring has value 6 twice", ring.count(6), 2);
		test_this("Ring has value 7 twice", ring.count(7), 2);
		test_this("Ring has value 8 twice", ring.count(8), 2);
		test_this("Ring has value 9 once", ring.count(9), 1);
	}
	
	public static void test_binaryTree() {
		BinaryTree tree = new BinaryTree();
		int[] estimated = new int[6];
		
		test_this("Tree is empty",tree.isEmpty());
		tree.insert(8);
		test_this("Tree is not empty",!tree.isEmpty());
		tree.insert(3);
		tree.insert(2);
		tree.insert(6);
		tree.insert(9);
		tree.insert(1);
		tree.insert(4);
		tree.insert(5);
		tree.insert(7);
		
		tree.delete(4);
		tree.delete(2);
		tree.delete(7);
		
		//tree.print();
		
		estimated[0] = 1;
		estimated[1] = 3;
		estimated[2] = 5;
		estimated[3] = 6;
		estimated[4] = 8;
		estimated[5] = 9;
		
		Stack stack = tree.toStack();
		
		for (int i = 0; i < estimated.length; i++) {
			test_this("Tree is ordered ",stack.pop().key,estimated[i]);
		}
		
		
	}
	
	public static void test_simpleHeap() {
		SimpleHeap heap = new SimpleHeap(10);
		int[] estimated = new int[9];
		
		test_this("Heap is empty",heap.isEmpty());
		
		heap.insert(5);
		
		test_this("Heap is not empty",!heap.isEmpty());
		
		heap.insert(9);
		heap.insert(7);
		heap.insert(3);
		heap.insert(4);
		heap.insert(8);
		heap.insert(6);
		heap.insert(1);
		heap.insert(2);
		
		//heap.print();
		
		estimated[0] = 1;
		estimated[1] = 2;
		estimated[2] = 3;
		estimated[3] = 4;
		estimated[4] = 5;
		estimated[5] = 6;
		estimated[6] = 7;
		estimated[7] = 8;
		estimated[8] = 9;
		
		for (int i = 0; i < estimated.length; i++) {
			test_this("simple Heap is ordered ",heap.removeRoot(),estimated[i]);
		}
		
		test_this("Heap is now empty",heap.isEmpty());
		
		
		for (int j = 10; j > 0; j--) {
			for (int i = 0; i < 10; i++) {
				heap.insert(j*10 - i);
			}
		}
		
		for (int i = 1; !heap.isEmpty(); i++) {
			test_this("simple Heap is ordered ",heap.removeRoot(),i);
		}
		
		for (int j = 10; j > 0; j--) {
			for (int i = 0; i < 10; i++) {
				heap.insert(j*10 - i);
			}
		}
		
		SimpleStack stack = heap.toStack();
		
		for (int i = 1; !heap.isEmpty(); i++) {
			test_this("simple Heap is ordered ",stack.pop(),i);
		}
	}
}

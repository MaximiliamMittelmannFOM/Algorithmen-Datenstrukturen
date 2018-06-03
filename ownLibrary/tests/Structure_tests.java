package tests;

import structures.*;

public class Structure_tests {
	
	public static void main(String[] args) {
		System.out.println("Test started!");
		test_node();
		test_list();
		test_stack();
		test_queue();
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
}

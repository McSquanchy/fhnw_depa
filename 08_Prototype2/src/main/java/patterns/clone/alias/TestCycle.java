package patterns.clone.alias;

// This program demonstrates, that the Java-Cloning mechanism does not work
// for cyclic structures.
public class TestCycle {

	static class Node implements Cloneable {
		private Node next;
		private int val;

		public Node(int val, Node next) {
			this.val = val;
			this.next = next;
		}

		public Node(Node node) {
			this.val = node.val;
			if(node.next != null) {
				this.next = node.next.clone();
			}
		}

		@Override
		public Node clone() {
			return new Node(this);
		}

		public Node getNext() {  return next; }
		public int getVal() { return val; }
	}

	public static void main(String[] args) {
		Node n1 = new Node(1, null);
		Node n2 = new Node(2, n1);
		Node n3 = new Node(3, n2);
		n1.next = n3;
		// n3 -> n2 -> n1 -> n3 -> ....

		Node c = n1.clone();
		
		System.out.println(c);
		System.out.println(c.next);
		System.out.println(c.next.next);
		System.out.println(c.next.next.next);
		System.out.println(c == c.next.next.next);
	}
}

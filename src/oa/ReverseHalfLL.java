package oa;

public class ReverseHalfLL {
	public void reverse(Node head) {
		if (head == null || head.next == null) {
			return;
		}
		Node walk = head;
		Node run = head;
		while (run.next != null && run.next.next != null) {
			walk = walk.next;
			run = run.next.next;
		}
		Node pre = walk.next;
		Node curr = pre.next;
		pre.next = null;
		while (curr != null) {
			walk.next = curr;
			curr = curr.next;
			walk.next.next = pre;
			pre = walk.next;
		}
	}

	static class Node {
		private int val;
		private Node next;

		public Node(int val, Node node) {
			this.val = val;
			next = node;
		}
	}

	public String printLL(Node node) {
		StringBuilder res = new StringBuilder();
		Node curr = node;
		while(curr != null) {
			res.append(curr.val).append(",");
			curr = curr.next;
		}
		return res.toString();
	}

	public static void main(String[] args) {
		ReverseHalfLL test = new ReverseHalfLL();
		Node head = new Node(1, null);
		Node node = head;
		for (int i = 2; i < 9; i++) {
			node.next = new Node(i, null);
			node = node.next;
		}
		System.out.println(test.printLL(head));
		test.reverse(head);
		System.out.println(test.printLL(head));

	}
}



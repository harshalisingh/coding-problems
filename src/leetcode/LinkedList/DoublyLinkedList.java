package leetcode.LinkedList;

class DoubleListNode {
	public int val;
	public DoubleListNode next;
	public DoubleListNode prev;
	DoubleListNode(int x) { 
		val = x; 
		DoubleListNode next, prev = null;
	}
}
public class DoublyLinkedList {
	public static void printList(DoubleListNode L) {
		while (L != null) {
			System.out.print(L.val);
			System.out.print("<=>");
			L = L.next;
		}
		System.out.print("null");
		System.out.println();
	}

	public static DoubleListNode reverseDoublyLLIterative(DoubleListNode head) {
		/*check for the cases like empty list and list with only one node */
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			head.prev = null;
			return head;
		}
		
		DoubleListNode temp = null;
		DoubleListNode curr = head;

		/* swap next and prev for all nodes of 
         doubly linked list */
		while (curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;   //just swap cur's next and prev
			curr.next = temp;
			curr = curr.prev;        //move to next node
		}
		return temp.prev;
	}

	public static DoubleListNode reverseDoublyLLRecursive(DoubleListNode head) {
		if (head == null) {
			return head;
		}

		if (head.next == null) {
			head.prev = null;
			return head;
		}

		DoubleListNode newHead = reverseDoublyLLRecursive(head.next);
		head.next.next = head;
		head.prev = head.next;
		head.next = null;
		return newHead;
	}
	
	public static DoubleListNode swapNodePairs(DoubleListNode head) {
		DoubleListNode dummyHead = new DoubleListNode(0);
		dummyHead.next = head;
		DoubleListNode cur = head;
		DoubleListNode prev = dummyHead;
		while (cur != null && cur.next != null) {
			DoubleListNode first = cur.next;
			DoubleListNode second = cur.next.next;
			prev.next = first;
			first.prev = prev;
			
			first.next = cur;
			cur.prev = first;
			
			cur.next = second;
			second.prev = cur;
			
			prev = cur;
			cur = second;
		}
		return dummyHead.next;
	}

	public static void main(String[] args){
		DoubleListNode L1 = new DoubleListNode(1);
		DoubleListNode L2 = new DoubleListNode(2);
		DoubleListNode L3 = new DoubleListNode(3);
		DoubleListNode L4 = new DoubleListNode(4);
		DoubleListNode L5 = new DoubleListNode(5);

		L1.next = L2; L2.prev = L1;
		L2.next = L3; L3.prev = L2;
		L3.next = L4; L4.prev = L3;
		L4.next = L5; L5.prev = L4;

		System.out.println("Actual List");
		DoublyLinkedList.printList(L1);

		System.out.println("Reverse List Iteratively");
		DoubleListNode resItr = reverseDoublyLLIterative(L1);	
		DoublyLinkedList.printList(resItr);

		System.out.println("Reverse List Recursively");
		DoubleListNode resRec = reverseDoublyLLRecursive(resItr);
		DoublyLinkedList.printList(resRec);
		
		
		System.out.println("Swap Node Pairs Iteratively");
		DoubleListNode swapped = swapNodePairs(resRec);
		DoublyLinkedList.printList(swapped);
	}
}

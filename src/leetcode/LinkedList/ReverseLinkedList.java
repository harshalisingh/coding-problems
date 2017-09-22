package leetcode.LinkedList;

public class ReverseLinkedList {
	public static ListNode reverseIterative(ListNode head){
		ListNode prev = null, curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;  //prev becomes first node of reversed list and head is last node of reversed list
	}
	
	/*
	 * Divide the list in 2 parts - first node and rest of the list.
	 * Recursively call reverse for the rest (head.next) of the linked list.
	 * Link rest (head.next).next to first.
	 * Fix head pointer
	 */
	public static ListNode reverseRecursion(ListNode head){
		if (head == null || head.next == null) {
			return head;
		}

		ListNode newHead = reverseRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static void main(String[] args){
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);

		System.out.println("Actual List");
		ListNode.printList(L1);
		
		System.out.println("Reverse List Iteratively");
		ListNode resItr = reverseIterative(L1);	
		ListNode.printList(resItr);
		
		System.out.println("Reverse List Recursively");
		ListNode resRec = reverseRecursion(resItr);
		ListNode.printList(resRec);
	}
}

package leetcode.LinkedList;

/**
 * Check if a linked list is Circular Linked List
 */
public class IsCircularLinkedList {
	public static boolean isCircular(ListNode head){
		// An empty linked list is circular
		if(head == null) return true;
		
		// Next of head
		ListNode node = head.next;
		
		// This loop would stop in both cases (1) If Circular (2) Not circular
		while(node != null && node != head){
			node = node.next;
		}
		
		// If loop stopped because of circular condition
		return node == head;
	}
	
	public static void main(String[] args){
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);
		
		L1.next.next.next.next.next = L1;
		
		System.out.println(isCircular(L1));
	}
}

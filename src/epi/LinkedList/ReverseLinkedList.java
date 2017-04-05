package epi.LinkedList;

public class ReverseLinkedList {
	public static ListNode<Integer> reverseIterative(ListNode<Integer> head){
		ListNode<Integer> prev = null, curr = head;
		while (curr != null) {
			ListNode<Integer> temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	/*
	 * Divide the list in 2 parts - first node and rest of the list.
	 * Recursively call reverse for the rest of the linked list.
	 * Link rest to first.
	 * Fix head pointer
	 */
	public static ListNode<Integer> reverseRecursion(ListNode<Integer> head){
		if (head == null || head.next == null) {
			return head;
		}

		ListNode<Integer> newHead = reverseRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
	
	public static void main(String[] args){
		ListNode<Integer> L1 = new ListNode<>(9, null);
		ListNode<Integer> L2 = new ListNode<>(1, L1);
		ListNode<Integer> L3 = new ListNode<>(2, L2);
		ListNode<Integer> L4 = new ListNode<>(4, L3);
		ListNode<Integer> L5 = new ListNode<>(8, L4);
		ListNode<Integer> L6 = new ListNode<>(3, L5);
		L1.printList(L6);
		ListNode<Integer> res = reverseIterative(L6);
		L1.printList(res);
	}
}

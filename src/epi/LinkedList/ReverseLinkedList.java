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

	public static ListNode<Integer> reverseRecursion(ListNode<Integer> head){
		if (head == null || head.next == null) {
			return head;
		}

		ListNode<Integer> newHead = reverseRecursion(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}

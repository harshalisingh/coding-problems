package leetcode.LinkedList;

/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example: Given 1->2->3->4->5->NULL and k = 2,
 * 				return 4->5->1->2->3->NULL.
 */
public class RotateRightLinkedList {
	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || k == 0) {
			return head;
		}
		ListNode p = head;
		int len = 1;
		while(p.next != null) {
			p = p.next;
			len++;
		}
		p.next = head;
		k %= len;
		for(int i = 0; i < len - k; i++) {
			p = p.next;
		}
		head = p.next;
		p.next = null;
		return head;
	}
}

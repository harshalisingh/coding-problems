package leetcode.LinkedList;

import leetcode.LinkedList.ListNode;

/*
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroupLinkedList {
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 0) return null;
		if (k==1)                   return head;
		ListNode dummy = new ListNode(0), start = dummy, end = head;
		dummy.next = head;
		while (true) {
			try {end = move(end, k);}
			catch (Exception e) {break;}
			start = reverse(start, end);
		}
		return dummy.next;
	}

	private static ListNode move(ListNode end, int k) {
		for (int i = 0; i < k; i++) {
			if (end == null) throw new IllegalArgumentException();
			end = end.next;
		}
		return end;
	}
	private static ListNode reverse(ListNode start, ListNode end) {
		ListNode pre = end, cur = start.next, nextStart = cur;
		while (cur != end) {
			ListNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}
		start.next = pre;
		return nextStart;
	}
	
	public static void printList(ListNode L) {
		while (L != null) {
			System.out.print(L.val);
			System.out.print("--->");
			L = L.next;
		}
		System.out.print("null");
		System.out.println();
	}
}

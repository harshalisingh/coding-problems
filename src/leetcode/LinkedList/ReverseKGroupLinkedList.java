package leetcode.LinkedList;

import leetcode.LinkedList.ListNode;

/*
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroupLinkedList {
	/* LeetCode - Recursive */
	public ListNode reverseKGroup2(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			
			//imagine rest of the list has been reversed and cur is the head of rverse part of list
			curr = reverseKGroup2(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part, 
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group: 
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list 
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}
	
	/* EPI */
	public static ListNode reverseKGroup1(ListNode head, int k) {
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




	/* GeeksForGeeks - Reverses the left over as well */
	ListNode reverseKGroup3(ListNode head, int k) {
		ListNode curr = head;
		ListNode tmp = null;
		ListNode prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (count < k && curr != null) {
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
			count++;
		}

		/* tmp is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
		if (tmp != null) 
			head.next = reverseKGroup3(tmp, k);

		// prev is now head of input list
		return prev;
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

package leetcode.LinkedList;

public class DeleteAlternateNodes {
	public void deleteAlternate(ListNode head){
		if (head == null) 
			return;

		ListNode prev = head;
		ListNode cur = head.next;

		while (prev != null && cur != null) {           
			/* Change next link of previous node */
			prev.next = cur.next;

			/* Free node */
			cur = null;

			/*Update prev and now */
			prev = prev.next;
			if (prev != null) 
				cur = prev.next;
		}
	}
}

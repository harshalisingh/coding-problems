package leetcode.LinkedList;

public class DeleteAlternateNodes {
	public void deleteAlternate(ListNode head){
		if (head == null) 
			return;

		ListNode prev = head;
		ListNode now = head.next;

		while (prev != null && now != null) {           
			/* Change next link of previous node */
			prev.next = now.next;

			/* Free node */
			now = null;

			/*Update prev and now */
			prev = prev.next;
			if (prev != null) 
				now = prev.next;
		}
	}
}

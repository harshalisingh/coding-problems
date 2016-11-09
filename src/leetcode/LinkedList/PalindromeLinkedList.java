package leetcode.LinkedList;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head;
	    ListNode slow = head;

	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    
	    /* fast would become NULL when there are even elements 
        in the list and not NULL for odd elements. We need to skip  
        the middle node for odd case and store it somewhere so that
        we can restore the original list */
	    if(fast != null) slow = slow.next;

	    slow = reverse(slow);
	    while(slow != null && head.val == slow.val) {
	        head = head.next;
	        slow = slow.next;
	    }
	    return slow == null;
	}

	private ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    ListNode current = head;
	    while(current != null) {
	        ListNode temp = current.next;
	        current.next = prev;
	        prev = current;
	        current = temp;
	    }
	    return prev;
	}
}

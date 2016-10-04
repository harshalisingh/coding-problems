package leetcode.LinkedList;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
	    ListNode fast = head;
	    ListNode slow = head;

	    while(fast != null && fast.next != null) {
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    if(fast != null) slow = slow.next;

	    slow = reverse(slow);
	    while(slow != null && head.data == slow.data) {
	        head = head.next;
	        slow = slow.next;
	    }
	    return slow == null;
	}

	private ListNode reverse(ListNode head) {
	    ListNode prev = null;
	    while(head != null) {
	        ListNode next = head.next;
	        head.next = prev;
	        prev = head;
	        head = next;
	    }
	    return prev;
	}
}

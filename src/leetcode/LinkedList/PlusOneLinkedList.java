package leetcode.LinkedList;

public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastNotNine = dummy, cur = head;
        
        while (cur != null) {
            if (cur.val != 9) {
                lastNotNine = cur;
            }
            cur = cur.next;
        }
        lastNotNine.val++;
        cur = lastNotNine.next;
        while (cur != null) {
        	cur.val = 0;
        	cur = cur.next;
        }
        return dummy.val == 1 ? dummy : dummy.next;
    }
}

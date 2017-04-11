package leetcode.LinkedList;

/*
 * Even Linked List:
 * 2->1->3->4->5->6->7->8  reversed to 2->1->3->4->8->7->6->5 ； 
 * Odd Linked List:
 * 5->7->8->6->3->4->2 reverse to  5->7->8->2->4->3->6 
 */
public class ReverseSecondHalfLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = slow.next;
        while(fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode pre = null, cur = slow.next;
        while(cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        slow.next = pre;
        return head;
    }
}

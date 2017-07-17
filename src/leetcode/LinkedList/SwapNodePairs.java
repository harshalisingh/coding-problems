package leetcode.LinkedList;

/** Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodePairs {
	/*
	 * dH(prev)->head(p)->q->r->s
	 * dH -> q -> p(prev) -> r (p) -> s
	 */
	public ListNode swapPairsItr(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode cur = head;
		ListNode prev = dummyHead;
		while (cur != null && cur.next != null) {
			ListNode first = cur.next;
			ListNode second = cur.next.next;
			prev.next = first;
			first.next = cur;
			cur.next = second;
			prev = cur;
			cur = second;
		}
		return dummyHead.next;
	}
	
	public ListNode swapPairs(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}

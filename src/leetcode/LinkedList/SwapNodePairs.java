package leetcode.LinkedList;

/*
 * dH(prev)->head(p)->q->r->s
 * dH -> q -> p(prev) -> r (p) -> s
 */
public class SwapNodePairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = head;
		ListNode prev = dummyHead;
		while (p != null && p.next != null) {
			ListNode q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummyHead.next;
	}
}

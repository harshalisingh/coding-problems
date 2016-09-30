package leetcode.LinkedList;

import epi.LinkedList.ListNode;
/*
 * p->q->r->s
 * q->p->s->r
 */
public class SwapNodePairs {
	public ListNode<Integer> swapPairs(ListNode<Integer> head) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		dummyHead.next = head;
		ListNode<Integer> p = head;
		ListNode<Integer> prev = dummyHead;
		while (p != null && p.next != null) {
			ListNode<Integer> q = p.next, r = p.next.next;
			prev.next = q;
			q.next = p;
			p.next = r;
			prev = p;
			p = r;
		}
		return dummyHead.next;
	}
}

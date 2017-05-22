package leetcode.LinkedList;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/#/description
 */
public class CommonNodeLinkedList {
	
	//Without using length : O(1) memory O(n) time
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if( headA == null || headB == null )
			return null;
		
		ListNode curA = headA, curB = headB;
		while( curA != curB){
			curA = curA==null?headB:curA.next;
			curB = curB==null?headA:curB.next;
		}
		return curA;
    }
	
	//Using Length of Linked Lists : O(1) memory O(n) time
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    int lenA = length(headA), lenB = length(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private int length(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}
}

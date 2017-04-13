package oa;

/**
 * O(1) space
 */


public class CopyRandomListPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	}
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode ptr = dummy;
		dummy.next = head;
		while(ptr.next != null)
		{
			RandomListNode next = ptr.next.next;
			ptr.next.next = new RandomListNode(ptr.next.label);
			ptr = ptr.next.next;
			ptr.next = next;
		}
		ptr = dummy;
		while(ptr.next != null)
		{
			if(ptr.next.random != null) ptr.next.next.random = ptr.next.random.next;
			ptr = ptr.next.next;
		}
		RandomListNode newdummy = new RandomListNode(0);
		RandomListNode newptr = newdummy;
		ptr = dummy;
		while(ptr.next != null)
		{
			newptr.next = ptr.next.next;
			newptr = newptr.next;
			ptr.next.next = ptr.next.next.next;
			ptr = ptr.next;
		}
		return newdummy.next;
	}
}

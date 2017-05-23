package leetcode.LinkedList;

/*
 * Merge Sort Linked List
 * O(nlogn)
 */
public class MergeSortLinkedList {
	public ListNode sortList(ListNode head) {
	    if (head == null || head.next == null)
	      return head;
	        
	    // step 1. cut the list to two halves
	    ListNode prev = null, slow = head, fast = head;
	    
	    while (fast != null && fast.next != null) {
	      prev = slow;
	      slow = slow.next;
	      fast = fast.next.next;
	    }
	    
	    prev.next = null; //Splits the list into two equal-sized lists.
	    
	    // step 2. sort each half
	    ListNode l1 = sortList(head);
	    ListNode l2 = sortList(slow);
	    
	    // step 3. merge l1 and l2
	    return merge(l1, l2);
	  }
	  
	  ListNode merge(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0), p = dummyHead;
	    
	    while (l1 != null && l2 != null) {
	      if (l1.val < l2.val) {
	        p.next = l1;
	        l1 = l1.next;
	      } else {
	        p.next = l2;
	        l2 = l2.next;
	      }
	      p = p.next;
	    }
	    
	    p.next = (l1 != null)? l1 : l2;
	    return dummyHead.next;
	  }
}

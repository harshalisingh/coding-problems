package epi.LinkedList;

public class SortLinkedList {
	public static ListNode<Integer> stableSortList(ListNode<Integer> L){
		if(L == null || L.next == null){
			return L;
		}

		ListNode<Integer> preSlow = null, slow = L, fast = L;
		while(fast != null && fast.next != null){
			preSlow = slow;
			fast = fast.next.next;
			slow = slow.next;
		}

		preSlow.next = null;   //Splits the list into two equal-sized lists.

		return mergeSortedLists(stableSortList(L), stableSortList(slow));

	}

	public static ListNode<Integer> mergeSortedLists(ListNode<Integer> L1, ListNode<Integer> L2){

		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		ListNode<Integer> current = dummyHead;	
		ListNode<Integer> p1 = L1, p2 = L2;

		while(p1!= null && p2 != null){
			if(p1.data <= p2.data){
				current.next = p1;
				p1 = p1.next;
			} else {
				current.next = p2;
				p2 = p2.next;
			}			
			current = current.next;
		}

		current.next = (p1 != null)? p1 : p2;
		return dummyHead.next;

	}
}

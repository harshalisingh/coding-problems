package epi.LinkedList;

public class RemoveDuplicateLinkedList {
	//EPI Solution
	public static ListNode<Integer> removeDuplicates(ListNode<Integer> L){
		ListNode<Integer> iter = L;
		while(iter != null){
			ListNode<Integer> nextDistinct = iter.next;
			while(nextDistinct != null && iter.data == nextDistinct.data){
				nextDistinct = nextDistinct.next;
			}
			iter.next = nextDistinct;
			iter = nextDistinct;
		}
		return L;
	}

}

package leetcode;

import epi.ListNode;

public class RemoveDuplicateLinkedList {
	//LeetCode
	public static ListNode<Integer> removeDuplicates(ListNode<Integer> head){
		ListNode<Integer> current = head;
		while(current != null && current.next != null){
			if(current.data == current.next.data){
				current.next = current.next.next;
			} else {
				current = current.next;
			}
		}
		return head;
	}
}

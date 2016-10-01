package leetcode.LinkedList;

public class RemoveDuplicateLinkedList {
	//LeetCode
	public static ListNode removeDuplicates(ListNode head){
		ListNode current = head;
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

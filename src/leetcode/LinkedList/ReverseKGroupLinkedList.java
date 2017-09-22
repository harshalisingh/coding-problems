package leetcode.LinkedList;

import leetcode.LinkedList.ListNode;

/*
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGroupLinkedList {
	/* LeetCode - Recursive */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || head.next == null || k == 0){
			return head;
		}
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) { // find the k+1 node
			curr = curr.next;
			count++;
		}
		if (count == k) { // if k+1 node is found
			
			//imagine rest of the list has been reversed and cur is the head of rverse part of list
			curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
			// head - head-pointer to direct part, 
			// curr - head-pointer to reversed part;
			while (count-- > 0) { // reverse current k-group: 
				ListNode tmp = head.next; // tmp - next head in direct part
				head.next = curr; // preappending "direct" head to the reversed list 
				curr = head; // move head of reversed part to a new node
				head = tmp; // move "direct" head to the next node in direct part
			}
			head = curr;
		}
		return head;
	}

	/* GeeksForGeeks - Reverses the left over as well */
	ListNode reverseKGroup2(ListNode head, int k) {
		ListNode curr = head;
		ListNode tmp = null;
		ListNode prev = null;

		int count = 0;

		/* Reverse first k nodes of linked list */
		while (curr != null && count != k) { // find the k+1 node
			tmp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = tmp;
			count++;
		}

		/* tmp is now a pointer to (k+1)th node 
          Recursively call for the list starting from current.
          And make rest of the list as next of first node */
		if (tmp != null) 
			head.next = reverseKGroup2(tmp, k); //head becomes last node of reversed list

		// prev is now head of input list
		return prev;
	}               

	public static void printList(ListNode L) {
		while (L != null) {
			System.out.print(L.val);
			System.out.print("--->");
			L = L.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public static void main(String[] args){
		ListNode L1 = new ListNode(1);
		L1.next = new ListNode(2);
		L1.next.next = new ListNode(3);
		L1.next.next.next = new ListNode(4);
		L1.next.next.next.next = new ListNode(5);

		System.out.println("Actual List");
		ListNode.printList(L1);
		
		System.out.println("Reverse List Iteratively");
		ListNode resItr = reverseKGroup(L1, 3);	
		ListNode.printList(resItr);
	}
}

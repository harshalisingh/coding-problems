package leetcode.LinkedList;

/*
 * http://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 * kAltReverse(struct node *head, int k)
  1)  Reverse first k nodes.
  2)  In the modified list head points to the kth node.  So change next 
       of head to (k+1)th node
  3)  Move the current pointer to skip next k nodes.
  4)  Call the kAltReverse() recursively for rest of the n - 2k nodes.
  5)  Return new head of the list.
 */
public class ReverseAlternateKNodes {
	/* Reverses alternate k nodes and
    returns the pointer to the new head node */
	ListNode kAltReverse(ListNode head, int k) {
		ListNode current = head;
		ListNode temp = null, prev = null;
		int count = 0;

		/*1) reverse first k nodes of the linked list */
		while (current != null && count < k) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
			count++;
		}

		/* 2) Now head points to the kth node.  So change next 
        of head to (k+1)th node*/
		if (head != null) {
			head.next = current;
		}

		/* 3) We do not want to reverse next k nodes. So move the current 
        pointer to skip next k nodes */
		count = 0;
		while (count < k - 1 && current != null) {
			current = current.next;
			count++;
		}

		/* 4) Recursively call for the list starting from current->next.
        And make rest of the list as next of first node */
		if (current != null) {
			current.next = kAltReverse(current.next, k);
		}

		/* 5) prev is new head of the input list */
		return prev;
	}

}

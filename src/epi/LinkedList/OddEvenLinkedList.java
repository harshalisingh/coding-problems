package epi.LinkedList;

/*
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 */
public class OddEvenLinkedList {
	public ListNode<Integer> oddEvenList(ListNode<Integer> head) {
		if(head == null) 
			return head;

		ListNode<Integer> result = head;
		ListNode<Integer> p1 = head;
		ListNode<Integer> p2 = head.next;
		ListNode<Integer> connectNode = head.next;

		while(p1 != null && p2 != null){
			ListNode<Integer> t = p2.next;
			if(t == null)
				break;

			p1.next = p2.next;
			p1 = p1.next;

			p2.next = p1.next;
			p2 = p2.next;
		}

		p1.next = connectNode;
		return result;
	}
}

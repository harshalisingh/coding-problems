package epi.LinkedList;

public class RemoveAllDuplicatesLinkedList {
	public static void main(String[] args){
		ListNode<Integer> L1 = new ListNode<Integer>(1, null);
		L1.next = new ListNode<Integer>(1, null);
		L1.next.next = new ListNode<Integer>(2, null);
		L1.next.next.next = new ListNode<Integer>(3, null);
		L1.next.next.next.next = new ListNode<Integer>(3, null);
		L1.next.next.next.next.next = new ListNode<Integer>(4, null);
		L1.next.next.next.next.next.next = new ListNode<Integer>(5, null);
		L1.next.next.next.next.next.next.next = new ListNode<Integer>(5, null);
		
		printList(L1);
		deleteDuplicates(L1);
		printList(L1);
	}
	public static ListNode<Integer> deleteDuplicates(ListNode<Integer> L) {
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, L);
		ListNode<Integer> p = dummyHead;
		while (p != null) {
			if (p.next != null && p.next.next != null && p.next.data == p.next.next.data) {
				int data = p.next.data;
				while (p.next != null && p.next.data == data) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}
		}
		return dummyHead.next;
	}
	
	public static void printList(ListNode<Integer> L) {
		while (L != null) {
			System.out.print(L.data);
			System.out.print("--->");
			L = L.next;
		}
		System.out.print("null");
		System.out.println();
	}
}

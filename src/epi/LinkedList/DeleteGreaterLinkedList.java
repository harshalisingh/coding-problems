package epi.LinkedList;

public class DeleteGreaterLinkedList {
	public static void main(String[] args){
		ListNode<Integer> L1 = new ListNode<>(0, null);
		ListNode<Integer> L2 = new ListNode<>(1, L1);
		ListNode<Integer> L3 = new ListNode<>(2, L2);
		ListNode<Integer> L4 = new ListNode<>(4, L3);
		ListNode<Integer> L5 = new ListNode<>(8, L4);
		ListNode<Integer> L6 = new ListNode<>(3, L5);
		//L1.printList(L6);
		ListNode<Integer> res = removeNode(L6, 2);
		printList(res);
	}
	public static ListNode<Integer> removeNode(ListNode<Integer> head, int val){
		ListNode<Integer> dummyHead = new ListNode<Integer>(0, null);
		dummyHead.next = head;
		ListNode<Integer> current = head;
		
		while(current.next != null){
			if(current.data > val){
				current.data = current.next.data;
				current.next = current.next.next;
			} else {
				current = current.next;
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

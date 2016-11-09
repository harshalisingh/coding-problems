package epi.LinkedList;

public class ReverseSubLinkedList {
	
	public static ListNode<Integer> reverseSubList(ListNode<Integer> L1, int start, int finish) {
        if(start == finish){
            return L1;
        }
        
        ListNode<Integer> dummyHead = new ListNode<Integer>(0, L1); // set dummyHead.next to L1
        ListNode<Integer> sublistHead = dummyHead;
        
        int k = 1;
        while(k++ < start){
            sublistHead = sublistHead.next;
        }
        
        //Reverse Sublist
        ListNode<Integer> sublistIter = sublistHead.next;
        while(start++ < finish){
            ListNode<Integer> temp = sublistIter.next;
            sublistIter.next = temp.next;
            temp.next = sublistHead.next;
            sublistHead.next = temp;
        }
        
        return dummyHead.next;
        
    }
	
	public static void main(String[] args){
		ListNode<Integer> L1 = new ListNode<>(9, null);
		ListNode<Integer> L2 = new ListNode<>(1, L1);
		ListNode<Integer> L3 = new ListNode<>(2, L2);
		ListNode<Integer> L4 = new ListNode<>(4, L3);
		ListNode<Integer> L5 = new ListNode<>(8, L4);
		ListNode<Integer> L6 = new ListNode<>(3, L5);
		L1.printList(L6);
		ListNode<Integer> res = reverseSubList(L6, 2, 5);
		L1.printList(res);
	}
}

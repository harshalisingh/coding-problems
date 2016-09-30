package epi.LinkedList;

public class ReverseSubLinkedList {
	
	public ListNode reverseSubList(ListNode<Integer> L1, int start, int finish) {
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

}

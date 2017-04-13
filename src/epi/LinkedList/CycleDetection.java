package epi.LinkedList;

public class CycleDetection {
	
	public ListNode<Integer> hasCycle(ListNode<Integer> head){
		ListNode<Integer> fast = head, slow = head;
		
		/* fast would become NULL when there are even elements 
        in the list and not NULL for odd elements.*/
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){ //There is a cycle
				int cycleLen = 0;
				do{
					++cycleLen;
					fast = fast.next;
				} while(slow != fast);
			
				//Finds the start of the cycle
				slow = head;
				while(slow != fast){
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		
		return null; //No cycle
	}

}

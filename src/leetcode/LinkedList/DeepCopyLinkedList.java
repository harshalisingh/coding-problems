package leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/#/description
 * 
 * More optimized: https://discuss.leetcode.com/topic/43907/java-very-simple-and-clean-solution-with-o-n-time-o-1-space-with-algorithm
 */
class RandomListNode {
	int val;
	RandomListNode next, random;
	RandomListNode(int x) { this.val = x; }
};
public class DeepCopyLinkedList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.val));
			node = node.next;
		}

		// loop 2. assign next and random pointers
		node = head;
		while (node != null) {
			map.get(node).next = map.get(node.next);
			map.get(node).random = map.get(node.random);
			node = node.next;
		}

		return map.get(head);
	}
}

/* Algorithm

Create the copy of node 1 and insert it between node 1 & node 2 in original Linked List, create the copy of 2 and insert it between 2 & 3.. Continue in this fashion, add the copy of N after the Nth node

Now copy the random link in this fashion

original->next->random = original->random->next;

This works because original->next is nothing but copy of original and Original->random->next is nothing but copy of random.

Now restore the original and copy linked lists in this fashion in a single loop.

original->next = original->next->next;  
copy->next = copy->next->next;
Make sure that last element of original->next is NULL.
*/
class DeepCopyConstantSpace {
	public RandomListNode copyRandomList(RandomListNode head) {
	    if(head == null) return head;
	    
	    RandomListNode original=head;
	    RandomListNode curOriginal=head;
	    
	    // step 1
	    while(original.next != null ){
	        RandomListNode copy=new RandomListNode(original.val);
	        RandomListNode temp=original.next;
	        original.next=copy;
	        copy.next=temp;
	        original=original.next.next;
	    }
	    original.next=new RandomListNode(original.val);
	    
	    //step 2
	    while(curOriginal!= null && curOriginal.next != null){
	        if(curOriginal.random != null){
	            curOriginal.next.random=curOriginal.random.next;
	        }
	        curOriginal=curOriginal.next.next;
	    }
	    
	    //step 3 and 4
	    RandomListNode orig=head;
	    RandomListNode copyCur=head.next;
	    RandomListNode copyHead=head.next;
	    
	    while(orig.next != null && copyCur.next != null){
	        orig.next=orig.next.next;
	        copyCur.next=copyCur.next.next;
	        orig=orig.next;
	        copyCur=copyCur.next;
	    }
	    orig.next=null;
	    
	    return copyHead;
	}
}

package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

/*
 * Initialize the result list as NULL and create an empty hash table. 
 * Traverse both lists one by one, for each element being visited, look the element in hash table. 
 * If the element is not present, then insert the element to result list. If the element is present, then ignore it.
 */
public class UnionIntersectionLinkedList {
	public static ListNode getUnionLL(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		Set<Integer> union = new HashSet<Integer>();
		ListNode cur1 = l1, cur2 = l2;
		while(cur1 != null){
			if(union.contains(cur1.val)){
				cur1 = cur1.next;
			} else {
				union.add(cur1.val);
				cur.next = new ListNode(cur1.val);
				cur = cur.next;
				cur1 = cur1.next;
			}
		}
		
		while(cur2 != null){
			if(union.contains(cur2.val)){
				cur2 = cur2.next;
			} else {
				union.add(cur2.val);
				cur.next = new ListNode(cur2.val);
				cur = cur.next;
				cur2 = cur2.next;
			}
		}
		
		return dummy.next;
	}
	
	/*
	 * Initialize the result list as NULL and create an empty hash table. Traverse list1. 
	 * For each element being visited in list1, insert the element in hash table. 
	 * Traverse list2, for each element being visited in list2, look the element in hash table. 
	 * If the element is present, then insert the element to result list. If the element is not present, then ignore it.
	 * 
	 */
	public static ListNode getIntersectionLL(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		Set<Integer> visited = new HashSet<Integer>();
		ListNode cur1 = l1, cur2 = l2;
		while(cur1 != null){
			if(visited.contains(cur1.val)){
				cur1 = cur1.next;
			} else {
				visited.add(cur1.val);
				cur1 = cur1.next;
			}
		}
		
		while(cur2 != null){
			if(visited.contains(cur2.val)){
				cur.next = new ListNode(cur2.val);
				cur = cur.next;
				cur2 = cur2.next;
			} else {
				cur2 = cur2.next;
			}
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(2);
		l1.next.next.next = new ListNode(3);
		l1.next.next.next.next = new ListNode(4);
		l1.next.next.next.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(6);
		l2.next.next.next = new ListNode(7);
		
		ListNode union = getUnionLL(l1, l2);
		ListNode intersection = getIntersectionLL(l1, l2);
		union.printList(l1);
		union.printList(l2);
		union.printList(union);
		union.printList(intersection);
	}
}

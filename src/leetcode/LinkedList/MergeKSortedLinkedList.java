package leetcode.LinkedList;

import java.util.PriorityQueue;
import java.util.Comparator;

public class MergeKSortedLinkedList {
	/* Every time we add a new element to the queue, it costs O(log n). And we have kn elements. 
	 * So the complexity is O(kn logn) + O(kn) = O(kn logn). And the space complexity is only O(n).
	 */
	public ListNode mergeKListsUsingHeap(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;

		PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1,ListNode o2){
				return o1.val - o2.val;
			}
		});

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				queue.add(lists[i]);  //add the heads of all lists in to the queue
		}

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!queue.isEmpty()) {
			ListNode node = queue.poll();
			p.next = node;
			if (node.next != null)
				queue.add(node.next);
			p = p.next;
		}
		return dummy.next;
	}


	/* Using Merge Sort
	 * Recursive version: We have T(n) = 2T(n/2) + kn. 
	 * So the complexity is O(kn logn). The depth of the recursive function is O(log n).
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) return null;
		return mergeKLists(lists, 0, lists.length - 1);
	}

	public ListNode mergeKLists(ListNode[] lists, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			return merge(mergeKLists(lists, left, mid), 
					mergeKLists(lists, mid + 1, right));
		}
		return lists[left];
	}

	//This function is from Merge Two Sorted Lists.
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0), p = dummy;

		while(l1 != null && l2 != null){
			if(l1.val <= l2.val){
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}			
			p = p.next;
		}

		p.next = (l1 != null)? l1 : l2;
		return dummy.next;
	}
}

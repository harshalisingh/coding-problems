package oa;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/#/description
 * 
 * More optimized: https://discuss.leetcode.com/topic/43907/java-very-simple-and-clean-solution-with-o-n-time-o-1-space-with-algorithm
 */

public class DeepCopyLinkedList {
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) return null;

		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

		// loop 1. copy all the nodes
		RandomListNode node = head;
		while (node != null) {
			map.put(node, new RandomListNode(node.label));
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

package leetcode.LinkedList;

import leetcode.Tree.TreeNode;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		return sortedListToBST(head, null);
	}
	private TreeNode sortedListToBST(ListNode head, ListNode tail){
		ListNode fast = head, slow = head;
		if(head == tail) return null;
		while(fast!=tail && fast.next!=tail){
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head, slow);
		root.right = sortedListToBST(slow.next, tail);
		return root;
	}
}

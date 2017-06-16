package leetcode.BST;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import leetcode.Tree.TreeNode;

public class ClosestKValuesBST {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		closestKValuesHelper(list, root, target, k);
		return list;
	}

	/**
	 * @return <code>true</code> if result is already found.
	 */
	private void closestKValuesHelper(LinkedList<Integer> list, TreeNode root, double target, int k) {
		if (root == null) return;

		closestKValuesHelper(list, root.left, target, k);
		if (list.size() == k) {
			if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
				return;
			} else {
				list.pollFirst();
			}
		}

		list.addLast(root.val);
		closestKValuesHelper(list, root.right, target, k);
	}
	
	//Iterative Inorder traversal
	public List<Integer> closestKValuesIterative(TreeNode root, double target, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (list.size() == k) {
            	if (Math.abs(list.getFirst() - target) < Math.abs(root.val - target)) {
                    break;
                } else {
                	list.pollFirst(); //list.removeFirst
                }
            }
            list.addLast(root.val);   //list.offer
            root = root.right;
        }
        return list;
    }
}

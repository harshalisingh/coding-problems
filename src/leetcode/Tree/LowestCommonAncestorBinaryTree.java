package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/#/description
 */
public class LowestCommonAncestorBinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
	
	 public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
	        Map<TreeNode, TreeNode> parent = new HashMap<>();
	        Deque<TreeNode> stack = new ArrayDeque<>();
	        parent.put(root, null);
	        stack.push(root);

	        while (!parent.containsKey(p) || !parent.containsKey(q)) {
	            TreeNode node = stack.pop();
	            if (node.left != null) {
	                parent.put(node.left, node);
	                stack.push(node.left);
	            }
	            if (node.right != null) {
	                parent.put(node.right, node);
	                stack.push(node.right);
	            }
	        }
	        Set<TreeNode> ancestors = new HashSet<>();
	        while (p != null) {
	            ancestors.add(p);
	            p = parent.get(p);
	        }
	        while (!ancestors.contains(q))
	            q = parent.get(q);
	        return q;
	    }
}

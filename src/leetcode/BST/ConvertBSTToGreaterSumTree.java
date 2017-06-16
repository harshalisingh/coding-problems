package leetcode.BST;

import java.util.Stack;

import leetcode.Tree.TreeNode;

/**Given a binary search tree (BST), con­vert it into greater sum tree.
 * Greater Sum Tree: A tree in which every node con­tains the sum of all the nodes which are greater than the node. 
 * Reverse Inorder Traversal
 */
public class ConvertBSTToGreaterSumTree {
	private int sum = 0;
    public TreeNode convertBSTRecursive(TreeNode root) {
        if (root == null) return null;
        convertBSTRecursive(root.right);
        int tmp = root.val;
        root.val += sum;
        sum += tmp;
        convertBSTRecursive(root.left);
        return root;
    }
    
    public TreeNode convertBSTIterative(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }
}

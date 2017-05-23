package leetcode.Tree;

import java.util.Stack;

/**
 * Reverse Inorder Traversal
 * @author harshalisingh
 *
 */
public class ConvertBSTToGreaterTree {
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

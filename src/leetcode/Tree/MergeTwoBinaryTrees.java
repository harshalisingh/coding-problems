package leetcode.Tree;

import java.util.Stack;

public class MergeTwoBinaryTrees {
	/*Time complexity: O(m). A total of m nodes need to be traversed. Here, m represents the minimum number of nodes from the two given trees.
	 * Space complexity: O(m). The depth of the recursion tree can go upto m in the case of a skewed tree. 
	 * In average case, depth will be O(logm).
	 */
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		
		//1. work on current node(s)
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        
        //2. process left subtree, 3. right subtree
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        
        //4. combine the results as children
        return t1;
    }
	
	/* Time complexity: O(n). We traverse over a total of n nodes. Here, n refers to the smaller of the number of nodes in the two trees.
	 * Space complexity : O(n). The depth of stack can grow upto n in case of a skewed tree.
	 */
	public TreeNode mergeTreesIterative(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }
}

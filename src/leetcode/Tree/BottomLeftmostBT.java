package leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Typical way to do binary tree level order traversal. Only additional step is to remember the first element of each level.
 * https://leetcode.com/problems/find-bottom-left-tree-value/#/description
 */
public class BottomLeftmostBT {
	public int findLeftMostNode(TreeNode root) {
        if (root == null) return 0;
        
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) result = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        
        return result;
    }
}

package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * https://leetcode.com/problems/find-leaves-of-binary-tree/#/description
 */
public class FindLeavesBT {
	public List<List<Integer>> findLeaves(TreeNode root) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    findLeavesHelper(list, root);
	    return list;
	}
	 
	// traverse the tree bottom-up recursively
	//return the level of root
	private int findLeavesHelper(List<List<Integer>> list, TreeNode root){
	    if(root==null)
	        return -1;
	 
	    int leftLevel = findLeavesHelper(list, root.left);
	    int rightLevel = findLeavesHelper(list, root.right);
	    int level = Math.max(leftLevel, rightLevel) + 1;
	       
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
	 
        list.get(level).add(root.val);
        root.left = root.right = null;
        return level;
	}
}

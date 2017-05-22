package leetcode.Tree;

/**
 * https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/#/description
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * DFS
 */
public class LongestConsecutiveSequenceBT {
	public static int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
         
        return DFSHelper(root, 0, root.val + 1);
    }
     
    private static int DFSHelper(TreeNode root, int curLen, int target) {
        if (root == null) {
            return curLen;
        }
         
        if (root.val == target) {
            curLen += 1;
        } else {
            curLen = 1;
        }
         
        int left = DFSHelper(root.left, curLen, root.val + 1);
        int right = DFSHelper(root.right, curLen, root.val + 1);
         
        return Math.max(curLen, Math.max(left, right));
    }
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
	    root.left = new TreeNode(11);
	    root.right = new TreeNode(9);
	    //root.left.left = new TreeNode(13);
	    root.left.right = new TreeNode(12);
	    root.left.right.right = new TreeNode(13);
	    root.right.left = new TreeNode(13);
	    root.right.right = new TreeNode(8);
	    
	    System.out.println(longestConsecutive(root)); 
	}

}

package leetcode.BST;

import leetcode.Tree.TreeNode;

public class FindModeBST {
    private int currVal;
    private int currCount = 0;
    private int maxCount = 0;
    private int modeCount = 0;
    
    private int[] modes;
    
	public int[] findMode(TreeNode root) {
        inorderMorris(root);
        modes = new int[modeCount];
        modeCount = 0;
        currCount = 0;
        inorderMorris(root);
        return modes;
    }
	
	//Morris Inorder traversal O(1) space
	public void inorderMorris(TreeNode root) {  
		TreeNode cur = root;  
		while (cur != null) {  
			if (cur.left != null) {  
				TreeNode pre = cur.left;  
				while (pre.right != null && pre.right != cur) {  
					pre = pre.right;  
				}  
				if (pre.right == null) { // set right to successor  
					pre.right = cur;  
					cur = cur.left;  
				} else { // visit and revert the change  
					pre.right = null;  
					handleValue(cur.val); 
					cur = cur.right;  
				}  
			} else { // visit and move to successor 
				handleValue(cur.val);
				cur = cur.right;  
			}  
		}  
	}  
	
    private void handleValue(int val) {
        if (val != currVal) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null)
                modes[modeCount] = currVal;
            modeCount++;
        }
    }
    
}

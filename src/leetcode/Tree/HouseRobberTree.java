package leetcode.Tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberTree {
	//Step I - Recursion ("optimal substructure")
	public int robSlow(TreeNode root) {
	    if (root == null) return 0;
	    
	    int val = 0;
	    //we rob the root, now rob the 4 grand childs of the root
	    if (root.left != null) {
	        val += robSlow(root.left.left) + robSlow(root.left.right);
	    }	    
	    if (root.right != null) {
	        val += robSlow(root.right.left) + robSlow(root.right.right);
	    }
	    
	    //max of when we rob the root and when we don't rob the root
	    return Math.max(val + root.val, robSlow(root.left) + robSlow(root.right));
	}
	
	//Step II - DP ("optimal substructure" + "overlapping of subproblems")
	public int robDP(TreeNode root) {
	    return robSub(root, new HashMap<>());
	}
	private int robSub(TreeNode root, Map<TreeNode, Integer> map) {
	    if (root == null) return 0;
	    if (map.containsKey(root)) return map.get(root);
	    
	    int val = 0;	    
	    if (root.left != null) {
	        val += robSub(root.left.left, map) + robSub(root.left.right, map);
	    }	    
	    if (root.right != null) {
	        val += robSub(root.right.left, map) + robSub(root.right.right, map);
	    }
	    
	    val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
	    map.put(root, val);	    
	    return val;
	}
	
	//Step III - DP and Optimization
	//an array of two elements:
	//	first  res[0]: maximum amount of money that can be robbed if root is not robbed, 
	//  second res[1]: maximum amount of money robbed if it is robbed.
	
	public int rob(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	private int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];

	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    
	    return res;
	}

}

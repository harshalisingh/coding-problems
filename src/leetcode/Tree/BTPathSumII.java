package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Similar to BinaryTreePaths
 */
public class BTPathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> resultList = new ArrayList<List<Integer>>();
		List<Integer> currentPath = new ArrayList<>();
		pathSumHelper(root, sum, currentPath, resultList);
		return resultList;
	}

	public static void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
		if (root == null){
	        return; 
	    }
		path.add(root.val);
	    if (root.left == null && root.right == null && root.val == sum){
	    	result.add(new ArrayList<Integer>(path));
	    }else{
	    	pathSumHelper(root.left, sum - root.val, path, result);
	    	pathSumHelper(root.right, sum - root.val, path, result);
	    }
	    path.remove(path.size()-1);
	}



	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(9);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(5);
		List<List<Integer>> result = pathSum(root, 9);
		for(List<Integer> outer : result){
			for(Integer i : outer){
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

}

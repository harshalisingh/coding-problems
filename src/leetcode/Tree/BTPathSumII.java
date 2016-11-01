package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 */
public class BTPathSumII {
	public static void pathSumInner(TreeNode root, int sum, List<Integer>path, List<List<Integer>> result) {
	    path.add(root.data);
	    if(root.left == null && root.right == null)
	        if(sum == root.data) result.add(new ArrayList<Integer>(path));
	    if(root.left!=null) pathSumInner(root.left, sum-root.data, path, result);
	    if(root.right!=null)pathSumInner(root.right, sum-root.data, path, result);
	    path.remove(path.size()-1);
	}

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> resultList = new ArrayList<List<Integer>>();
	    if(root==null) return resultList;
	    List<Integer> currentPath = new ArrayList<Integer>();
	    pathSumInner(root, sum, currentPath, resultList);
	    return resultList;
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

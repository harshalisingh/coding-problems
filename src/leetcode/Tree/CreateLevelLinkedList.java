package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/*Create LinkedList of Level order Traversal
 * CTCI
 */
public class CreateLevelLinkedList {
	
	/*
	 * Using Recursion, Space : extra O(log n) recursive calls, Result: O(N) data
	 */
	ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root, result, 0);
		return result;
	}

	private void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> result, int level) {
		if(root == null) return; //base case
		
		LinkedList<TreeNode> list;
		if(result.size() == level){             //existing level not contained in the result
			
			/*
			 * Levels are always traversed in order. So, if this is the first time we have visited level i,
			 * we must have seen levels 0 through i - 1. We can therefore safely add this level at the end of result.
			 */
			list = new LinkedList<TreeNode>();
			result.add(list);
		} else {
			list = result.get(level);
		}
		
		list.add(root);
		
		createLevelLinkedList(root.left, result, level + 1);
		createLevelLinkedList(root.right, result, level + 1);
		
	}
	
	/*
	 * Using Queue
	 */
	public static ArrayList<LinkedList<TreeNode>> levelOrder(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) return null;

		queue.offer(root);
		while(!queue.isEmpty()){
			int size = queue.size();
			LinkedList<TreeNode> layer = new LinkedList<TreeNode>();
			for(int i=0; i < size; i++) {
				root = queue.poll();
				layer.add(root);
				//System.out.print(root.val + " ");
				if(root.left != null) queue.offer(root.left);
				if(root.right != null) queue.offer(root.right);
			}
			result.add(layer);
			System.out.println();
		}
		return result;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		CreateLevelLinkedList cll = new CreateLevelLinkedList();
		ArrayList<LinkedList<TreeNode>> res = cll.createLevelLinkedList(root);
		ArrayList<LinkedList<TreeNode>> res2 = cll.levelOrder(root);
		for(LinkedList<TreeNode> layer : res2){
			System.out.print("[");
			for(TreeNode node : layer){
				System.out.print(node.val + ", ");
			}
			System.out.print("]");
		}
		
		
	}
}

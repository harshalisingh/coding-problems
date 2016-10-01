package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderTraversalBinaryTree {
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<List<Integer>> res = levelOrder(root);
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		Deque<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> nodes = new LinkedList<List<Integer>>();
        
        if(root == null) return nodes;
        
        queue.add(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> layer = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                root = queue.poll();
                layer.add(root.data);
                if(root.left != null) queue.add(root.left);
                if(root.right != null) queue.add(root.right);
            }
            nodes.add(layer);
        }
        return nodes;
    }
}

package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ReverseLevelOrderBinaryTree {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            nodes.add(0, layer);
        }
        return nodes;
    }
	
	public void reverseLevelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Deque<TreeNode> q = new LinkedList<>();
        Deque<TreeNode> s = new LinkedList<>();
        
        q.offer(root);
        while(!q.isEmpty()){
            root = q.poll();
            if(root.right != null){
                q.offer(root.right);
            }
            if(root.left != null){
                q.offer(root.left);
            }
            s.push(root);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop().data + " ");
        }
    }
}

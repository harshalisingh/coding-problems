package leetcode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/#/description
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class ZigZagLevelOrderTraversal {
	 //add modification to levelorder traversel: for levels from left to right, add next node to the end of list
    //for levels from right to left, add next node to the front of the list
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        
        if(root == null)    return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean leftToRight = true;    //root level is left to right
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(leftToRight){
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }
                if(node.left != null)   q.offer(node.left);
                if(node.right != null)  q.offer(node.right);
               
            }
            
            result.add(list);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}

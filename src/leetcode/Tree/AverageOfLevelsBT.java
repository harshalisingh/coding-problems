package leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** Average of Levels in Binary Tree
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/#/description
 */
public class AverageOfLevelsBT {
	public List<Double> averageOfLevels(TreeNode root) {
	    List<Double> result = new ArrayList<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    
	    if(root == null) return result;
	    q.offer(root);
	    while(!q.isEmpty()) {
	        int size = q.size();
	        double sum = 0.0;
	        for(int i = 0; i < size; i++) {
	            TreeNode node = q.poll();
	            sum += node.val;
	            if(node.left != null) q.offer(node.left);
	            if(node.right != null) q.offer(node.right);
	        }
	        result.add(sum / size);
	    }
	    return result;
	}
}

package leetcode.HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leetcode.Tree.TreeNode;

public class BTVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> res = new ArrayList<>();
	    if (root == null) {
	        return res;
	    }
	    
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();

	    q.offer(root); 
	    cols.offer(0);

	    int min = 0;
	    int max = 0;
	    
	    while (!q.isEmpty()) {
	        TreeNode node = q.poll();
	        int col = cols.poll();
	        
	        if (!map.containsKey(col)) {
	            map.put(col, new ArrayList<Integer>());
	        }
	        map.get(col).add(node.val);

	        if (node.left != null) {
	            q.offer(node.left); 
	            cols.offer(col - 1);
	            min = Math.min(min, col - 1);
	        }
	        
	        if (node.right != null) {
	            q.offer(node.right);
	            cols.offer(col + 1);
	            max = Math.max(max, col + 1);
	        }
	    }

	    for (int i = min; i <= max; i++) {
	        res.add(map.get(i));
	    }

	    return res;
	}
}

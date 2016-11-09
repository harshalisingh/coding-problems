package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *          				 1
                          /      \
                         2        3
                      /         /   \
                     4         5     6
                       \           /
                        7         8
 * Rightmost cousin of 4 is 6, right most cousin of 7 is 8 and so on. 
 */
public class RightMostCousin {
	public static TreeNode rightMostCousin(TreeNode root, int targetKey){
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		
		int count = 0;
		queue.offer(root);	
		count++;
		boolean targetLevel = false;
		
		while(!queue.isEmpty())
		{
			TreeNode node = queue.poll();	
			count--;
			if((node.left!=null && node.left.val == targetKey) || (node.right!=null && node.right.val == targetKey))
				targetLevel = true;			
			
			if(node.left != null) queue.offer(node.left);
			if(node.right != null) queue.offer(node.right);		

			if(count == 0){			
				count = queue.size();
				if(targetLevel){
					TreeNode cousin = null;
					while(!queue.isEmpty())
					{
						cousin = queue.poll();															
					}
									
					return cousin;
				}
			}
		}
		
		return null;
	}
}

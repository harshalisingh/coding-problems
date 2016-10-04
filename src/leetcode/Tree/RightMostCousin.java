package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

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
			if((node.left!=null && node.left.data == targetKey) || (node.right!=null && node.right.data == targetKey))
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

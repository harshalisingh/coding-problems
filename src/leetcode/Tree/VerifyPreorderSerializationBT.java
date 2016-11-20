package leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;

/*
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", 
 * where # represents a null node.
 * Given a string of comma separated values, 
 * verify whether it is a correct preorder traversal serialization of a binary tree. 
 * Find an algorithm without reconstructing the tree.
 */
public class VerifyPreorderSerializationBT {
	
	//Using stack
	public boolean isValidSerializationStack(String preorder){
		// using a stack, scan left to right
        // case 1: we see a number, just push it to the stack
        // case 2: we see #, check if the top of stack is also #
        // if so, pop #, pop the number in a while loop, until top of stack is not #
        // if not, push it to stack
        // in the end, check if stack size is 1, and stack top is #
        if (preorder == null) {
            return false;
        }
        
        Deque<String> stack = new LinkedList<>();
        String[] str = preorder.split(",");
        for(int pos = 0; pos < preorder.length(); pos++){
        	String curr = str[pos];
        	while(curr.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
        		stack.pop();
        		if(stack.isEmpty()){
        			return false;
        		}
        		stack.pop();
        	}
        	stack.push(curr);
        }
        return stack.size() == 1 && stack.peek().equals("#");
	}
	
	
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1;
		for (String node: nodes) {
			diff -= 1; //every node has 1 indegree (1 parent)
			if (diff < 0) return false;
			if (!node.equals("#")) diff += 2; //every non-null node has 2 outdegree (2 children)
		}
		return diff == 0;
	}
}

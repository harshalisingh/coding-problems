package leetcode.BFSDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.StackAndQueue.NestedInteger;

/**
 * https://leetcode.com/problems/nested-list-weight-sum/#/description
 */
public class NestedListWeightSum {
	/* Recursive - DFS */
	public int depthSum(List<NestedInteger> nestedList) {
	    return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> list, int depth) {
	    int sum = 0;
	    for (NestedInteger n : list) {
	        if (n.isInteger()) {
	            sum += n.getInteger() * depth;
	        } else {
	            sum += depthSum(n.getList(), depth + 1);
	        }
	    }
	    return sum;
	}
	
	/*Iterative - BFS */
	public int depthSumIterative(List<NestedInteger> nestedList) {
	    if(nestedList == null){
	        return 0;
	    }
	    
	    int sum = 0;
	    int level = 1;	    
	    Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
	    for (NestedInteger next: nestedList) {
            queue.offer(next);
        }
	    while(!queue.isEmpty()){
	        int size = queue.size();        
	        for(int i = 0; i < size; i++){
	            NestedInteger ni = queue.poll();	            
	            if(ni.isInteger()){
	                sum += ni.getInteger() * level;
	            }else{
	                queue.addAll(ni.getList());
	            }
	        }	        
	        level++;
	    }	    
	    return sum;
	}
}

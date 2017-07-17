package leetcode.BFSDFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.StackAndQueue.NestedInteger;

/**
 * https://leetcode.com/problems/nested-list-weight-sum-ii/#/description
 */
public class NestedListWeightSumII {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        
        int prev = 0;
        int total = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger next: nestedList) {
            queue.offer(next);
        }       
        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.poll();
                if (current.isInteger()) {
                	levelSum += current.getInteger();
                }
                List<NestedInteger> nextList = current.getList();
                if (nextList != null) {
                    for (NestedInteger next: nextList) {
                        queue.offer(next);
                    }
                }
            }
            prev += levelSum;
            total += prev;
        }
        return total;
    }
}

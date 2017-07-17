package leetcode.contest;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: pid =  [1, 3, 10, 5]   ppid = [3, 0, 5, 3]  kill = 5
 * Output: [5,10]
 */
public class KillProcess {
	//DFS: Time O(n), Space O(n)
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	    
	    // Store process tree as an adjacency list
	    Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
	    for (int i = 0; i < ppid.size(); i++) {
	        adjacencyLists.putIfAbsent(ppid.get(i), new ArrayList<>());
	        adjacencyLists.get(ppid.get(i)).add(pid.get(i));
	    }
	    
	    // Kill all processes in the subtree rooted at process "kill"
	    List<Integer> res = new ArrayList<>();
	    Deque<Integer> stack = new ArrayDeque<>();
	    stack.add(kill);
	    while (!stack.isEmpty()) {
	        int cur = stack.pop();    //get cur pid
	        res.add(cur);             //add to result list
	        if (adjacencyLists.containsKey(cur)) {  //if it has children
                stack.addAll(adjacencyLists.get(cur)); //add all its child process to stack
            }
	    }
	    return res;   

	}
}

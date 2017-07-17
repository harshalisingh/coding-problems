package leetcode.BFSDFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * https://leetcode.com/problems/remove-invalid-parentheses/#/description
 * 
 * "()())()" -> ["()()()", "(())()"]
   "(a)())()" -> ["(a)()()", "(a())()"]
   ")(" -> [""]
   
   T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
 */
public class RemoveInvalidParenthesesBFS {
	public List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		// sanity check
		if (s == null) return res;

		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();

		// initialize
		queue.add(s);
		visited.add(s);

		boolean found = false;

		while (!queue.isEmpty()) {
			s = queue.poll();

			if (isValid(s)) {
				// found an answer, add to the result
				res.add(s);
				found = true;
			}

			/* Based on the statement, we need to Remove the minimum number of invalid parentheses, 
			 * so if for the same level(BFS), if a solution is found, we cannot remove more character after, 
			 * and the removal number of rest of candidate in the queue is less than or equal to the current one.
			 */
			if (found) continue;

			// generate all possible states
			for (int i = 0; i < s.length(); i++) {
				// we only try to remove left or right paren
				if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;

				//create new string skipping parentheses at i
				String t = s.substring(0, i) + s.substring(i + 1);

				if (!visited.contains(t)) {
					// for each state, if it's not visited, add it to the queue
					queue.add(t);
					visited.add(t);
				}
			}
		}
		return res;
	}


	// helper function checks if string s contains valid parentheses
	boolean isValid(String s) {
	    int count = 0;
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') count++;
	        if (c == ')') {
	            if (count == 0) return false;
	            count--;
	        }
	    }
	    return count == 0;
	}
	
	public static void main(String[] args){
		RemoveInvalidParenthesesBFS rip = new RemoveInvalidParenthesesBFS();
		String s = "(a)())()";
		for(String str : rip.removeInvalidParentheses(s)){
			System.out.println(str);
		}	
	}
}

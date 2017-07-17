package leetcode.StackAndQueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.LinkedList;

/** Simplify Path
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * The main idea is to push to the stack every valid file name (not in {"",".",".."}), 
 * popping only if there's smth to pop and we met "..". I don't feel like the code below needs any additional comments.
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
	    Deque<String> stack = new LinkedList<>();
	    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    String res = "";
	    for (String dir : stack) res = "/" + dir + res;
	    return res.isEmpty() ? "/" : res;
	}
}

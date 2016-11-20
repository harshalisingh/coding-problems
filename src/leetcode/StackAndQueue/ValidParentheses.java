package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given a string containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid 
 * but "(]" and "([)]" are not.
 */
public class ValidParentheses {

	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}
}

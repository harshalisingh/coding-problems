package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/** Evaluate the value of an arithmetic expression in Reverse Polish Notation (Postfix expression).
   Valid operators are +, -, *, /. Each operand may be an integer or another expression.
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */
public class ReversePolishNotation {
	public static int eval(String RPNExpression) {
		Deque<Integer> stack = new LinkedList<>();
		String delimiter = ",";
		String[] symbols = RPNExpression.split(delimiter);
		for (String token : symbols) {
			if (token.length() == 1 && "+-*/".contains(token)) {
				final int y = stack.pop();
				final int x = stack.pop();
				switch (token.charAt(0)) {
				case '+':
					stack.push(x + y);
					break;
				case '-':
					stack.push(x - y);
					break;
				case '*':
					stack.push(x * y);
					break;
				case '/':
					stack.push(x / y);
					break;
				default:
					throw new IllegalArgumentException("Malformed RPN at :" + token);
				}
			} else { // token is a number.
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}

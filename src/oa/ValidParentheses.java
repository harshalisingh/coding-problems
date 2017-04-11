package oa;

import java.util.*;
public class ValidParentheses {
	public int solution(String input) {
		int LENGTH = input.length();
		if ( LENGTH % 2 == 1) {
			return -1;
		}
		int count = 0;
		Stack<Character> stack = new Stack<>();
		for (int pos = 0; pos < LENGTH; pos++) {
			if (input.charAt(pos) == '[') {
				stack.push('[');
			} else {
				if (!stack.isEmpty() && stack.pop().equals('[')) {
					count += 1;
				} else {
					return -1;
				}
			}
		}

		if (stack.isEmpty()) {
			return count;
		}

		return -1;
	}

	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while (s.length() > 0) {
			System.out.println(test.solution(s));
			s = sc.nextLine();
		}
	}
}



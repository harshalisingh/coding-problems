package oa;

import java.util.*;

public class LongestPalindromeSubstring {
	public String calLongest(String input) {
		int LEN = input.length();
		if (LEN < 2) {
			return input;
		}
		int maxLen = 1;
		int startPos = 0;
		for (int centerPos = 1; centerPos < LEN - 1; centerPos++) {
			int oddStartPos = expand(input, centerPos, centerPos); 
			int evenStartPos = expand(input, centerPos, centerPos + 1);

			int tempStartPos;
			int tempLen;
			if (oddStartPos < evenStartPos) {
				tempStartPos = oddStartPos;
				tempLen = 2 * (centerPos - oddStartPos) + 1;
			} else {
				tempStartPos = evenStartPos;
				tempLen = 2 * (centerPos - evenStartPos) + 2;
			}

			if (maxLen < tempLen) {
				maxLen = tempLen;
				startPos = tempStartPos;
			}

		}
		return input.substring(startPos, startPos + maxLen);
	}

	private int expand(String input, int leftEnd, int rightEnd) {
		while (input.charAt(leftEnd) == input.charAt(rightEnd)) {
			if (leftEnd == 0 || rightEnd == input.length() - 1) {
				break;
			}
			leftEnd--;
			rightEnd++;
		}
		if (input.charAt(leftEnd) != input.charAt(rightEnd)) {
			leftEnd++;
		}
		return leftEnd;
	}

	public static void main(String[] args) {
		LongestPalindromeSubstring test = new LongestPalindromeSubstring();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(test.calLongest(input));
	}
}



package epi.ArraysAndString;

//LeetCode Solution
public class ReverseWordsII {
	public static void main(String[] args){

		char[] input = "the    sky, is blue".toCharArray();
		reverseWords(input);
		System.out.println(input);
	}

	public static void reverseWords(char[] s) {
		// Three step to reverse
		// 1, reverse the whole sentence
		reverse(s, 0, s.length - 1);
		// 2, reverse each word
		int i = 0;
		for (int j = 0; j < s.length; j++) {
			if (s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
		// 3, reverse the last word, if there is only one word this will solve the corner case
		reverse(s, i, s.length - 1);
	}

	public static void reverse(char[] s, int start, int end) {
		while (start < end) {
			char temp = s[start];
			s[start++] = s[end];
			s[end--] = temp;
		}
	}
}

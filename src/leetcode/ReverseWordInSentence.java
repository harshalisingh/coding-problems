package leetcode;

//LeetCode Solution
public class ReverseWordInSentence {
	public static void main(String[] args){

		char[] input = "a  cat    and  dog".toCharArray();
		reverseWords(input);
		System.out.println(input);
	}

	public static void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);
		for (int i = 0, j = 0; j <= s.length; j++) {
			if (j == s.length || s[j] == ' ') {
				reverse(s, i, j - 1);
				i = j + 1;
			}
		}
	}
	private static void reverse(char[] array, int start, int last) {
		while(start < last){
			char temp = array[start];
			array[start] = array[last];
			array[last] = temp;
			start++;
			last--;
		}
	}
}

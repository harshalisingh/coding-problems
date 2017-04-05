package leetcode.Strings;

/*
 * https://leetcode.com/problems/length-of-last-word/#/description
 * Given s = "Hello World", return 5.
 */
public class LengthLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
		int lastIndex = s.lastIndexOf(' ') + 1;
		return s.length() - lastIndex;    
	}
}

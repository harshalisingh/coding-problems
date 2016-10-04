package leetcode.Strings;

public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
		s = s.trim();
	    int lastIndex = s.lastIndexOf(' ') + 1;
	    return s.length() - lastIndex;        
	}
}

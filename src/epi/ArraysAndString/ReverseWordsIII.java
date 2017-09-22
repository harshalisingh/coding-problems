package epi.ArraysAndString;

/**
 * Given a string, you need to reverse the order of characters in each word 
 * within a sentence while still preserving whitespace and initial word order.
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 */
public class ReverseWordsIII {
	public String reverseWords(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = 0;
        for (j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                reverse(cs, i, j - 1);
                i = j + 1;
            }
        }
        reverse(cs, i, j - 1);
        return new String(cs);
    }
    
    private void reverse(char[] cs, int x, int y) {
        while (x < y) {
            char t = cs[x];
            cs[x++] = cs[y];
            cs[y--] = t;
        }
    }
}

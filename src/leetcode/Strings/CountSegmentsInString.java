package leetcode.Strings;

/*
 * https://leetcode.com/problems/number-of-segments-in-a-string/#/solutions
 * Increment at start of each character in word
 */
public class CountSegmentsInString {
	public int countSegments(String s) 
    {
        if (s.length() == 0) return 0;
        int count = s.charAt(0) != ' ' ? 1 : 0;
        for (int i = 1; i < s.length(); i++)
        {
            // count the number of word starts
            count += s.charAt(i) != ' ' && s.charAt(i-1)== ' ' ? 1 : 0;  
        }
        return count;
    }
}

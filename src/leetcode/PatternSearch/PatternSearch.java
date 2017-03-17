package leetcode.PatternSearch;

public class PatternSearch {
	
	//Worst case: O(m(n - m +1)), which is clearly O(nm)
	public static void naivePatternSearch(String text, String pattern) {
        int n = text.length(), m = pattern.length();
        int threshold = n - m;
        for (int i = 0; i <= threshold; ++i) {
            if (text.substring(i,i+m).equals(pattern)) {
                System.out.println(i);
            }
        }
    }
}

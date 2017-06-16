package leetcode.Strings;

/**
 * Minimum Window Substring, S = "ADOBECODEBANC"  T = "ABC"   Minimum window is "BANC".
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/2
 * 1. Use two pointers: start and end to represent a window.
 * 2. Move end to find a valid window.
 * 3. When a valid window is found, move start to find a smaller window.
 * Time Complexity: O(n)
 */
public class MinWindowSubstringTemplate {
	public String minWindow(String s, String t) {
		int map[] = new int[128];

		int counter = t.length();      // check whether the substring is valid
		int start = 0, end = 0;        //two pointers, one point to tail and one  head
		int minLen = Integer.MAX_VALUE; //the length of substring
		int minStart = 0; 

		/* initialize the hash map here */
		for(char c : t.toCharArray())
			map[c]++;

		while(end < s.length()){

			/* modify counter here */
			final char c1 = s.charAt(end);
			if(map[c1] > 0) counter--;             
			map[c1]--;
			end++;
	

			while(counter == 0){ //Valid

				/* update d here if finding minimum*/
				if(end - start < minLen){
					minLen = end - start;
					minStart = start;
				}

				final char c2 = s.charAt(start);
				map[c2]++;
				if(map[c2] > 0) counter++;  //make it invalid
				start++;
			
			}
		}
		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
	}

	/**
	 * Longest Substring - at most K distinct characters
	 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
	 * For example, Given s = “eceba” and k = 2,
	 * T is "ece" which its length is 3.
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[128];
		int start = 0, end = 0, counter = 0;
		int maxLen = Integer.MIN_VALUE;
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;
			map[c1]++;
			end++;
			
			while (counter > k) {
				final char c2 = s.charAt(start);
				map[c2]--;
				if (map[c2] == 0) counter--;
				start++;
			}
			maxLen = Math.max(maxLen, end - start);
		}
		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}

	/**
	 * Longest Substring - at most 2 distinct characters
	 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
	 * For example, Given s = “eceba”, T is "ece" which its length is 3.
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, counter = 0;
		int maxLen = Integer.MIN_VALUE;
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;
			map[c1]++;
			end++;

			while (counter > 2) {
				final char c2 = s.charAt(start);
				map[c2]--;
				if (map[c2] == 0) counter--;				
				start++;
			}
			maxLen = Math.max(maxLen, end - start);
		}
		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}
	
	/**
	 * Longest Substring Without Repeating Characters
	 * Given a string, find the length of the longest substring without repeating characters.
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * Given "pwwkew", the answer is "wke", with the length of 3. 
	 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstringWithoutRepeatingChars(String s) {
		int[] map = new int[128];
		int start = 0, end = 0, counter = 0;
		int maxLen = Integer.MIN_VALUE;
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] > 0) counter++;
			map[c1]++;
			end++;

			while (counter > 0) {
				final char c2 = s.charAt(start);
				map[c2]--;
				if (map[c2] > 0) counter--;				
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}

	public static void main(String[] args){
		String s = "ADOBECODEBANC";
		String s1 = "ADEBGCABC";
		String t = "ABC";
		MinWindowSubstringTemplate mws = new MinWindowSubstringTemplate();
		
		//Minimum Window Substring
		System.out.println(mws.minWindow(s1, t));
		
		//Longest Substring - at most K distinct characters
		System.out.println(mws.lengthOfLongestSubstringKDistinct("eceba", 3));
		
		//Longest Substring - at most K distinct characters
		System.out.println(mws.lengthOfLongestSubstringTwoDistinct("eceba"));
		
		//Longest Substring Without Repeating Characters
		System.out.println(mws.lengthOfLongestSubstringWithoutRepeatingChars("abcdabcbb"));
	}
}

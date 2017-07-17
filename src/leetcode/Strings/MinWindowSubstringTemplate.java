package leetcode.Strings;

import java.util.Arrays;

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
	 * Longest Substring - at most K distinct characters (longest substring with at most 1 distinct character will be length 1)
	 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
	 * For example, Given s = “eceba” and k = 2,
	 * T is "ece" which its length is 3.
	 */
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] map = new int[128];
		int start = 0, end = 0, counter = 0;
		int maxLen = Integer.MIN_VALUE;
		System.out.println(Arrays.toString(map));
		while (end < s.length()) {
			final char c1 = s.charAt(end);
			if (map[c1] == 0) counter++;   //seen a distinct character, limit it to k
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
			if (map[c1] == 0){
				counter++;  
			}
			map[c1]++;
			end++;

			while (counter > 2) {
				final char c2 = s.charAt(start);
				map[c2]--;
				if (map[c2] == 0){
					counter--;				
				}
				start++;
			}
			maxLen = Math.max(maxLen, end - start);
		}
		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}
	
	/** Refer : LongestNonRepeatingSubstring.java
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
			if (map[c1] > 0){
				counter++; //seen a character again, limit it to 
			}
			map[c1]++;
			end++;

			while (counter > 0) {
				final char c2 = s.charAt(start);
				map[c2]--;
				if (map[c2] > 0){
					counter--;				
				}
				start++;
			}

			maxLen = Math.max(maxLen, end - start);
		}

		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}
	
	/** Permutation in String (Using Sliding Window)
	 *  Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, 
	 *  one of the first string's permutations is the substring of the second string.
	 */
	public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;
        
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }        
        return false;
    }
    
    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
    
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, zero = 0, k = 1; // flip at most k zero
        int start = 0, end = 0;
        while(end < nums.length){
        	 if (nums[end] == 0) {
        		 zero++;
        	 }
        	 end++;
        	 
        	 while(zero > k){
        		 if (nums[start] == 0){
        			 zero--;
        		 }
        		 start++;                  
        	 }
        	 max = Math.max(max, end - start);
        }                                                            
        return max;             
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
		
		//s2 contains one permutation of s1 ("ba").
		System.out.println(mws.checkInclusion("ab", "eidbaooo"));
	}
}

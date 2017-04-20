package leetcode.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 */
public class LongestNonRepeatingSubstring {
	public static void main(String[] args){
		String s ="abbabc";
		System.out.println(lengthOfLongestSubstring(s));
		System.out.println(lengthOfLongestSubstringFaster(s));
		System.out.println(lengthOfLongestSubstringHashMap(s));
	}
	public static int lengthOfLongestSubstring(String s) {		
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i=0, maxLen = 0;
        for(int j = 0; j < s.length(); j++){        
            if(charMap[s.charAt(j)] >= i){      
                i = charMap[s.charAt(j)] + 1;  
            }
            charMap[s.charAt(j)] = j;        
            maxLen = Math.max(j-i+1, maxLen);  
        }
        return maxLen;
    }
	
	public static int lengthOfLongestSubstringFaster(String s) {
        Set<Character> uniqueSet = new HashSet<>();
        int maxSize = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!uniqueSet.contains(s.charAt(i))) {
                uniqueSet.add(s.charAt(i));
                if(uniqueSet.size() > maxSize) {
                    maxSize = uniqueSet.size();
                }
            } else {
                while (s.charAt(start) != s.charAt(i)) {
                    uniqueSet.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
        }
        return maxSize;
    }
	
	//Using HashMap
	
	public static int lengthOfLongestSubstringHashMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
	
	/*
	 * Time complexity : O(n). Index j will iterate n times.
	 * Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
	 * Space complexity (Table): O(m). m is the size of the charset.
	 */
	public int lengthOfLongestSubstringCharSet(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)] + 1, i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j;
        }
        return ans;
    }
}

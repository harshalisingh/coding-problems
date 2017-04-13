package leetcode.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestNonRepeatingSubstring {
	public static void main(String[] args){
		String s ="abbabc";
		System.out.print(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {		
        int[] charMap = new int[256];
        Arrays.fill(charMap, -1);
        int i=0, maxLen = 0;
        for(int j=0; j<s.length(); j++){        
            if(charMap[s.charAt(j)] >= i){      
                i = charMap[s.charAt(j)] + 1;  
            }
            charMap[s.charAt(j)] = j;        
            maxLen = Math.max(j-i+1, maxLen);  
        }
        return maxLen;
    }
	
	public int lengthOfLongestSubstringFaster(String s) {
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
	
	public int lengthOfLongestSubstringHashMap(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	
	/*
	 * Time complexity : O(n)O(n). Index jj will iterate nn times.
	 * Space complexity (HashMap) : O(min(m, n))O(min(m,n)). Same as the previous approach.
	 * Space complexity (Table): O(m)O(m). mm is the size of the charset.
	 */
	public int lengthOfLongestSubstringCharSet(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}

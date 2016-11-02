package leetcode.Strings;

import java.util.Arrays;
import java.util.HashSet;
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
}

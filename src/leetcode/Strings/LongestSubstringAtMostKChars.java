package leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/#/description
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * 
 * 
 * This is a classic two-pointers (slow & fast) plus hash map problem, 
 * we can let the fast pointer j go through the string and count the characters as long as the size of the map <= m, 
 * otherwise, let the slow pointer i catch up with j till the size of the map < m.
 * 
 * Time complexity is O(n), but since we move i one by one to decrease the count and once the count is 0 
 * we will remove that character from the map, it can be slow if we have a super long string. 
 * To make it even faster, we can borrow LRU data structure to help us quickly know the character 
 * we need to remove from the map in O(1) time, the implementation is a bit complex.
 */
public class LongestSubstringAtMostKChars {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0;
		int best = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			//current character is in the map already update its count
			map.put(c, map.getOrDefault(c, 0) + 1);

			// otherwise, use the slow pointer i to
			// decrease the count of old characters
			// till we can put the new character in the map
			while (map.size() > k) {
				char leftChar = s.charAt(left);
				if (map.containsKey(leftChar)) {
					map.put(leftChar, map.get(leftChar) - 1);                     
					if (map.get(leftChar) == 0) { 
						map.remove(leftChar);
					}
				}
				left++;
			}
			
			// update max length every time we move j	
			best = Math.max(best, i - left + 1);
		}
		return best;
	} 
	
	public int longestSubstring(String s, int M) {
		  int i = 0, j = 0, max = 0;
		  
		  Map<Character, Integer> map = new HashMap<>();
		  
		  while (j < s.length()) {
		    char cj = s.charAt(j++);
		    
		    if (map.containsKey(cj)) {
		      // current character is in the map already
		      // update its count
		      map.put(cj, map.get(cj) + 1);
		    } else {
		      // otherwise, use the slow pointer i to
		      // decrease the count of old characters
		      // till we can put the new character in the map
		      while (map.size() >= M) {
		        char ci = s.charAt(i++);
		        
		        map.put(ci, map.get(ci) - 1);
		        if (map.get(ci) == 0) {
		          map.remove(ci);
		        }
		      }
		      
		      map.put(cj, 1);
		    }
		    
		    // update max length every time we move j
		    max = Math.max(max, j - i);
		  }
		  
		  return max;
		}
	
	public static void main(String[] args){
		LongestSubstringAtMostKChars o = new LongestSubstringAtMostKChars();
		String s = "abbccdd";
		System.out.println(o.lengthOfLongestSubstringKDistinct(s, 3));
		System.out.println(o.longestSubstring(s, 3));
	}
}

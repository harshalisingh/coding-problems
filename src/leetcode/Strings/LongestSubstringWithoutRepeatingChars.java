package leetcode.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 */
public class LongestSubstringWithoutRepeatingChars {
	/*
	 * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
	 * Space complexity : O(min(m, n)). Same as the previous approach. We need O(k) space for the sliding window, 
	 * where k is the size of the Set. The size of the Set is upper bounded by the size of the string n and the size of the 
	 * charset/alphabet m.
	 */
	public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
	
	/*
	 * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. 
	 * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. 
	 * Then we can skip the characters immediately when we found a repeated character.
	 * The reason is that if s[j] have a duplicate in the range [i, j) with index j', we don't need to increase i little by little. 
	 * We can skip all the elements in the range [i, j'] and let i to be j' + 1 directly.
	 */
	public int lengthOfLongestSubstringUsingMap(String s) {
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); //to fast forward i to j+1 and skip all elements if a duplicate is found
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
	
	/*
	 * Time complexity : O(n). Index j will iterate n times.
	 * Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
	 * Space complexity (Table): O(m). m is the size of the charset.
	 */
	public int lengthOfLongestSubstringASCII(String s) {
        int ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}

package leetcode.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example, "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class CanStringBePalindromePermutation {
	/*
	 * Time complexity : O(n). Space complexity : O(n)
	 */
	public boolean canPermutePalindromeHashmap(String s) {
		HashMap < Character, Integer > map = new HashMap < > ();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		int count = 0;
		for (char key: map.keySet()) {
			count += map.get(key) % 2;
		}
		return count <= 1;
	}

	/*
	 * Time complexity : O(n). Space complexity : O(128). A mapmap of constant size(128) is used.
	 */
	public boolean canPermutePalindromeArray(String s) {
		int[] map = new int[128];
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
		}
		int count = 0;
		for (int key = 0; key < map.length && count <= 1; key++) {
			count += map[key] % 2;
		}
		return count <= 1;
	}
	
	/*
	 * Time complexity : O(n), Space complexity : O(n)
	 */
	public boolean canPermutePalindromeSet(String s) {
        Set < Character > set = new HashSet < > ();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }
}

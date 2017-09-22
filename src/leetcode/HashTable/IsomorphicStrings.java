package leetcode.HashTable;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example, Given "egg", "add", return true.
 * 				Given "foo", "bar", return false.
 * 				Given "paper", "title", return true.
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		int m1[] = new int[256]; 
		int m2[] = new int[256];
		int count = 1;
		for(int i=0; i < s.length(); i++) {
			char a = s.charAt(i), b = t.charAt(i);
			if(m1[a] != m2[b]) return false;
			if(m1[a] == 0) {
				m1[a] = count;
				m2[b] = count;
				count++;
			}
		}
		return true;
	}
}

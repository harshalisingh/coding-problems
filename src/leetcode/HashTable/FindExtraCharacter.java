package leetcode.HashTable;

public class FindExtraCharacter {
	public char findTheDifference(String s, String t) {
		int[] alpha = new int[26];
		for (int i = 0; i < 26; i++) alpha[i] = 0;
        for (char c : s.toCharArray())
            alpha[ c - 'a' ]++;

        for (char c : t.toCharArray()) {
           //could do decrement first, then check but yeah
        	alpha[c - 'a']--;
            if (alpha[c - 'a'] < 0)
                return c;
        }

        return 0;
	}
}

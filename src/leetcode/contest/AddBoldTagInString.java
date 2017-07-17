package leetcode.contest;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s 
 * that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. 
 * Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * 
 * Input: s = "abcxyz123"  dict = ["abc","123"],    Output: "<b>abc</b>xyz<b>123</b>"
 * Input: s = "aaabbcc"  dict = ["aaa","aab","bc"]  Output: "<b>aaabbc</b>c"
 */
public class AddBoldTagInString {
	public String addBoldTag(String s, String[] dict) {
		boolean[] bold = new boolean[s.length()];
		for (int i = 0, end = 0; i < s.length(); i++) { // For every character in `s`,
			for (String word : dict) {                 // For every `word` in `dict`, we test:

				// If substring s[i, i + word.length()] == word, meaning characters between i, 
				// i + word.length() should be `bold`.
				if (s.startsWith(word, i)) {

					// Use variable `end` to store known longest end of current continuous `bold` characters
					end = Math.max(end, i + word.length());
				}
			}

			// If `end` > `i`, meaning character at position `i` is within the current continuous `bold`
			// characters, we mark it as `bold`.
			bold[i] = i < end;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			//if character at index i is not bold, add to result and continue
			if (!bold[i]) {
				result.append(s.charAt(i));
				continue;
			}
			int j = i;
			while (j < s.length() && bold[j]) j++;
			result.append("<b>" + s.substring(i, j) + "</b>");
			i = j - 1;
		}

		return result.toString();
	}
}

package leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreakString {
	private final Map<String, String> cache = new HashMap<>();

	public String wordBreak(String s, Set<String> dict) {      
		if(s == null || s.isEmpty()) return "";

		if (cache.containsKey(s)) return cache.get(s);
		if (dict.contains(s)) return s;

		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0,i), right = s.substring(i);
			if (dict.contains(left) && containsSuffix(dict, right)) {
				return left + " " + wordBreak(right, dict);
			}
		}
		cache.put(s, null);
		return null;
	}
	private boolean containsSuffix(Set<String> dict, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (dict.contains(str.substring(i))) return true;
		}
		return false;
	}

	public static void main(String[] args){
		WordBreakString wbs = new WordBreakString();
		String s = "catsanddog";
		String[] arrayDict = new String[]{"cats", "and", "dog"};
		List<String> listDict = Arrays.asList(arrayDict);
		Set<String> setDict = new HashSet<>();
		setDict.addAll(listDict);
		System.out.println(wbs.wordBreak(s, setDict));
	}
}

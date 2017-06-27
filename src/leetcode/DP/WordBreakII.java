package leetcode.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word. 
 * You may assume the dictionary does not contain duplicate words.
 * s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
	private final Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> dict) {      
        List<String> result = new ArrayList<>();
        if(s == null || s.isEmpty()) return result;
        
        if (cache.containsKey(s)) return cache.get(s);
        if (dict.contains(s)) result.add(s);
        
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i), right = s.substring(i);
            if (dict.contains(left) && containsSuffix(dict, right)) {
                for (String ss : wordBreak(right, dict)) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }
    
    public static void main(String[] args){
    	WordBreakII wb = new WordBreakII();
    	String s = "catsanddog";
    	String[] arrayDict = new String[]{"cats", "and", "dog"};
    	List<String> listDict = Arrays.asList(arrayDict);
    	Set<String> setDict = new HashSet<>();
    	setDict.addAll(listDict);
    	for(String string : wb.wordBreak(s, setDict)){
    		System.out.println(string);
    	}
    }
}

package leetcode.HashTable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	/* Easy
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 1. pattern = "abba", str = "dog cat cat dog" should return true.
	 * 2. pattern = "abba", str = "dog cat cat fish" should return false.
	 * 
	 * Go through the pattern letters and words in parallel, and compare the indexes where they last appeared.
	 */
	public boolean wordPatternI(String pattern, String str) {
	    String[] words = str.split(" ");
	    if (words.length != pattern.length())
	        return false;
	    Map index = new HashMap();
	    for (Integer i=0; i<words.length; ++i)
	        if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
	            return false;
	    return true;
	}
	
	

}

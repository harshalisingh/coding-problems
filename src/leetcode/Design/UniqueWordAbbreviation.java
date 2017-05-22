package leetcode.Design;

import java.util.HashMap;

public class UniqueWordAbbreviation {
	HashMap<String, String> map;
	public UniqueWordAbbreviation(String[] dictionary) {
	    map = new HashMap<String, String>();
	    for(String str:dictionary){
	        String key = getAbbr(str);
	        // If there is more than one string belong to the same key
	        // then the key will be invalid, we set the value to ""
	        if(map.containsKey(key) && !map.get(key).equals(str))
	            map.put(key, "");
	        else
	            map.put(key, str);
	    }
	}

	public boolean isUnique(String word) {
	    String key = getAbbr(word);
	    return !map.containsKey(key) || map.get(key).equals(word);
	}

	private String getAbbr(String str){
	    if(str.length()<=2) return str;
	    return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
	}
}

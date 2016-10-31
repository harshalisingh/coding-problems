package leetcode.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedString = new String(charArr);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(s);
        }
        
        List<List<String>> groupAnagram = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            groupAnagram.add(entry.getValue());
        }
        
        return groupAnagram;
    }
}

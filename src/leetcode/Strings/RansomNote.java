package leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : ransomNote.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        for(char m : magazine.toCharArray()){
            if(map.containsKey(m)){
                map.put(m, map.get(m) - 1);
                
                if(map.get(m) == 0){
                    map.remove(m);
                    if(map.isEmpty()){
                        break;
                    }
                }
                
            }
            
        }
        
        return map.isEmpty();
    }
}

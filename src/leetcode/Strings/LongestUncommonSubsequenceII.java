package leetcode.Strings;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequenceII {
	public int findLUSlength(String[] strs) {
        int len = strs.length;
        
        // reverse sorting array with length 
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.length() - s1.length();
            }
        });
        
        for(int i=0; i<len; i++){
            int missMatchCount = strs.length - 1;
            for(int j=0; j<len; j++){
                if(i != j && !isSubSequence(strs[i], strs[j])){
                    missMatchCount --;
                }
            }
            
            // strs[i] is not a sub sequence of any other entry
            if(missMatchCount == 0){
                return strs[i].length();
            }
        }
        
        return -1;
    }
    
    private boolean isSubSequence(String s1, String s2){
        int idx = 0;
        for(char ch : s2.toCharArray()){
            if(idx < s1.length() && ch == s1.charAt(idx)){
                idx++;
            }
        }
        
        return idx == s1.length();
    }
}

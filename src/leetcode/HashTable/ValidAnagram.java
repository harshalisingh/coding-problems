package leetcode.HashTable;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] countMap = new int[26];
        for(int i = 0; i < s.length(); i++){
        	countMap[s.charAt(i)-'a']++;
        	countMap[t.charAt(i)-'a']--;
        }
        for(int i:countMap){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}

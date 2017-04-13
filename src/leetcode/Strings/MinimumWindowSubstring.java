package leetcode.Strings;

import java.util.HashMap;

/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * https://leetcode.com/problems/minimum-window-substring/#/description
 */
public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : t.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}
			else{
				map.put(c, 1);
			}
		}
		int left = 0, minLeft=0, minLen =s.length()+1, count = 0;
		for(int right = 0; right<s.length(); right++){
			char r = s.charAt(right);

			//the goal of this part is to get the first window that contains whole t
			if(map.containsKey(r)){
				map.put(r, map.get(r)-1);

				//identify if the first window is found by counting frequency of the characters of t showing up in S
				if(map.get(r)>=0) count++;
			}

			//if the count is equal to the length of t, then we find such window
			while(count == t.length()){

				//just update the minleft and minlen value
				if(right-left+1 < minLen){
					minLeft = left;
					minLen = right-left+1;
				}
				char l = s.charAt(left);

				//starting from the leftmost index of the window, we want to check if s[left] is in t. 
				//If so, we will remove it from the window, and increase 1 time on its counter in hashmap 
				//which means we will expect the same character later by shifting right index. 
				//At the same time, we need to reduce the size of the window due to the removal.
				if(map.containsKey(l)){
					map.put(l, map.get(l)+1);
					if(map.get(l)>0) count--;
				}

				//if it doesn't exist in t, it is not supposed to be in the window, left++. 
				//If it does exist in t, the reason is stated as above. left++.
				left++;
			}
		}
		return minLen == s.length() + 1 ? "" : s.substring(minLeft, minLeft+minLen);
	}

	public static void main(String[] args){
		String s = "ADOBECODEBANC";
		String t = "ABC";
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow(s, t));
	}
}

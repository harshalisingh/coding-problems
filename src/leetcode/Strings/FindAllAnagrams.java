package leetcode.Strings;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
	public static void main(String[] args){
		List<Integer> result = findAnagrams("slate", "tea");
		//List<Integer> result = findAnagrams("cbaebabacd", "abc");
		if(result.size() == 0){
			System.out.println("No Anagram Found");
		} else {
			for(Integer i : result){
				System.out.println(i);
			}
		}

	}
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

		int[] hash = new int[256]; //character hash
		char[] charArr = p.toCharArray();
		//record each character in p to hash
		for (char c : charArr) {
			hash[c]++;
		}
		//two points, initialize count to p's length
		int start = 0, end = 0, count = p.length();

		while (end < s.length()) {
			//move right everytime, if the character exists in p's hash, decrease the count
			//current hash value > 0 means the character is existing in p
			final char c1 = s.charAt(end);
			if (hash[c1] > 0) count--;
			hash[c1]--;
			end++;

			//when the count is down to 0, means we found the right anagram
			//then add window's left to result list
			if (count == 0) {
				list.add(start);
			}
			//if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
			//++ to reset the hash because we kicked out the left
			//only increase the count if the character is in p
			//the count >= 0 indicate it was original in the hash, cuz it won't go below 0
			if (end - start == p.length() ) {
				final char c2 = s.charAt(start);
				hash[c2]++;
				if (hash[c2] > 0) count++;
				start++;
			}
		}
		return list;
	}

}

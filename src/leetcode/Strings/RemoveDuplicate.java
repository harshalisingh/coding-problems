package leetcode.Strings;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class RemoveDuplicate {
	public static void main(String[] args){
		String input = "abracadabra";
		System.out.println(removeDuplicates(input) + " : " + removeDuplicatesUsingSet(input));
	}
	//Remove duplicates and maintain order
	public static String removeDuplicates(String str) {
		boolean seen[] = new boolean[256];
		StringBuilder sb = new StringBuilder(seen.length);

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (!seen[ch]) {
				seen[ch] = true;
				sb.append(ch);
			}
		}
		return sb.toString();
	}

	//Using LinkedHashSet
	public static String removeDuplicatesUsingSet(String str) { 

		LinkedHashSet<Character> set = new LinkedHashSet<Character>(); 
		char[] array = str.toCharArray(); 
		for(char c : array) { 
			set.add(c); 
		} 
		StringBuilder sb = new StringBuilder(); 
		Iterator<Character> it = set.iterator(); 

		while (it.hasNext()) { 
			sb.append(it.next()); 
		} 
		return sb.toString(); 
	}
}

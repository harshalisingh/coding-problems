package leetcode.Strings.duplicate;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two words, determine if the first word, or any anagram of it, 
 * appears in consecutive characters of the second word. For instance, tea appears as an anagram 
 * in the last three letters of slate, but let does not appear as an anagram in slate even though 
 * all the letters of let appear in slate. 
	Return the anagram of the first word that has appeared in the second word.
	https://www.careercup.com/question?id=5761560760811520
	Sample Input 1           Sample Output1
	tea                                 ate
	slate 
	
	Sample Input 2           Sample Output2 
	let                                  None
	slate  
 */
public class FindAnagramInWord {
	public static void findWord(String part, String full) {
		char c;
		int k = 0;
		int fullCount = 0;

		Map<Character, Integer> map = new HashMap<>();

		for(int i = 0; i < part.length(); i++){
			int val = map.containsKey(part.charAt(i)) ? map.get(part.charAt(i)) : 1;
			map.put(part.charAt(i), val + 1);
		}
		
		mainloop: for (int i = 0; i < full.length(); i++) {
			for (int j = 0; j < part.length(); j++) {
				c = full.charAt(i);
				if (c == part.charAt(j)) {
					k = i;
					break mainloop;
				}
			}
		}

		StringBuffer sb = new StringBuffer();
		secondloop: for (int v = k; v < full.length(); v++) {
			if(map.containsKey(full.charAt(v))){
				sb.append(full.charAt(v));
				fullCount++;
			} else {
				System.out.println("no anagram found");
				break secondloop;
			}
		}
		if (fullCount == part.length()) {
			System.out.println("String   " + sb.toString());
		}
	}
	
	public static void main(String[] args) {
		findWord("let", "slate");
	}
}

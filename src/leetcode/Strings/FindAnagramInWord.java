package leetcode.Strings;

import java.util.HashMap;
import java.util.Map;

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

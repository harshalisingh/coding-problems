package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWordsAlternate {
	public String reverseWordsAlternate(String words) { 
		char[] letters = words.toCharArray(); 
		letters = ReverseLetters(letters, 0, letters.length - 1); 
		String l = new String(letters); 
		int start = 0; 
		int end = 0; 
		boolean isReversed = true; 
		while (end < letters.length) { 
			if ((letters[end] == ' ' || letters[end] == letters.length - 1)) { 
				if (isReversed) { 
					letters = ReverseLetters(letters, start, end - 1); 
					start = end + 1; 
					isReversed = false; 
				} else { 
					start = end + 1; 
					isReversed = true; 
				} 

			} 
			end++; 
		} 
		if (isReversed) { 
			letters = ReverseLetters(letters, start, end - 1); 
		} 


		return new String(letters); 
	} 

	private static char[] ReverseLetters(char[] letters, int start, int end) { 
		while (start < end) { 
			char temp = letters[end]; 
			letters[end] = letters[start]; 
			letters[start] = temp; 
			start++; 
			end--; 
		} 
		return letters; 
	}
	
	public static void main(String[] args){
		List<Character> ignoreChars = new ArrayList<>(Arrays.asList(',', ' ', ':', '.'));
		ReverseWordsAlternate rwa = new ReverseWordsAlternate();
		String input = "I am,   Harshali.";
		String output = rwa.reverseWordsAlternate(input);
		System.out.println(output);
	}
}

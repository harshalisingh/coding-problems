package oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseWords {

	private void reverseWords(char[] input) {		
		//Reverse the sentence
		//reverse(input, 0, input.length - 1);
		
		int start = 0, end;
		while((end = find(input, start)) != -1){		
			//Reverse each word
			reverse(input, start, end - 1);
			start = end + 1;
		}
		
		//Reverse the last word
		reverse(input, start, input.length - 1);
	}

	private static int find(char[] array, int start) {
		for(int i = start; i < array.length; i++){
			if(!Character.isLetterOrDigit(array[i])){
				return i;
			}
		}
		return -1;
	}

	private static void reverse(char[] array, int start, int end) {		
		while(start < end){
			char temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		
	}
	
	public static void main(String[] args){
		ReverseWords rw = new ReverseWords();
		char[] input = "I am, Harshali.".toCharArray();
		char[] input2 = "Let's take LeetCode contest".toCharArray();
		rw.reverseWords(input);
		System.out.println(input);
	}
}

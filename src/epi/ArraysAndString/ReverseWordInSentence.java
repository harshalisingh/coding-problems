package epi.ArraysAndString;

//EPI Solution
public class ReverseWordInSentence {
	
	public static void main(String[] args){
		
		char[] input = "a  cat    and  dog".toCharArray();
		reverseWords(input);
		System.out.println(input);
	}

	private static void reverseWords(char[] input) {		
		//Reverse the sentence
		reverse(input, 0, input.length);
		
		int start = 0, end;
		while((end = find(input, ' ', start)) != -1){		
			//Reverse each word
			reverse(input, start, end);
			start = end + 1;
		}
		
		//Reverse the last word
		reverse(input, start, input.length);
		
	}

	private static int find(char[] array, char c, int start) {
		for(int i = start; i < array.length; i++){
			if(array[i] == c){
				return i;
			}
		}
		return -1;
	}

	private static void reverse(char[] array, int start, int stopIndex) {		
		if(start >= stopIndex){
			return;
		}
		
		int last = stopIndex - 1;
		for(int i =  start; i <= start + (last-start)/2; i++){			
			char temp = array[i];
			array[i] = array[last - i + start];
			array[last - i + start] = temp;
		}
		
	}

}

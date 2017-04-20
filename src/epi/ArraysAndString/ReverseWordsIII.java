package epi.ArraysAndString;

public class ReverseWordsIII {
	public static void main(String[] args){

		char[] input = "Let's take, LeetCode contest".toCharArray();
		reverseWords(input);
		System.out.println(input);
	}
	
	public static String reverseWords(char[] s) 
	{
	    int i = 0;
	    for(int j = 0; j < s.length; j++)
	    {
	        if(s[j] == ' ')
	        {
	            reverse(s, i, j - 1);
	            i = j + 1;
	        }
	    }
	    reverse(s, i, s.length - 1);
	    return new String(s);
	}

	public static void reverse(char[] s, int start, int end)
	{
		while(start < end)
		{
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++; end--;
		}
	}
}

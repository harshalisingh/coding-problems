package leetcode.DP;


public class LongestPalindromicSubstring {
	
	/*
	 * Key idea, every time we move to right, we only need to consider whether using this new character as tail 
	 * could produce new palindrome string of length (current length +1) or (current length +2)
	 */
	public String longestPalindrome(String s) {
        int curLen = 0;
        int start = -1;
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++) {
            if(isPalindrome(array, i - curLen - 1, i)) {
                start = i - curLen - 1;
                curLen += 2;
            } else if (isPalindrome(array, i - curLen, i)) {
                start = i - curLen;
                curLen += 1;
            }
        }
        return new String(array, start, curLen);
    }
    private boolean isPalindrome(char[] array, int start, int end) {
        if(start < 0) {
            return false;
        }
        while(start < end) {
            if(array[start++] != array[end--]) {
                return false;
            }
        }
        return true;
    }
	

	
	public static void main(String[] args){
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("abad"));
	}
}

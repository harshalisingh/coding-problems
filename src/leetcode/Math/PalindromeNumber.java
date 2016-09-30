package leetcode.Math;

public class PalindromeNumber {
	public static void main(String[] args){
		int x = 1201;
		isPalindrome(x);
		
	}
	public static boolean isPalindrome(int x) {
		if (x < 0) return false;
		int div = 1;
		while (x / div >= 10) {
			div *= 10;
		}
		while (x != 0) {
			int l = x / div;
			int r = x % 10;
			if (l != r) return false;
			x = (x % div) / 10;
			div /= 100;
		}
		return true;
	}
}

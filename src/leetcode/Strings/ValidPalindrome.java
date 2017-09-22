package leetcode.Strings;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; 
			j--;
		}
		return true;
	}

	public static void main(String[] args){
		ValidPalindrome obj = new ValidPalindrome();
		String str = "..malayalam malayalam !";
		System.out.println(obj.isPalindrome(str));
	}
}

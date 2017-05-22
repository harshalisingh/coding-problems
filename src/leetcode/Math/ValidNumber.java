package leetcode.Math;

/*
 * Validate if a given string is numeric.
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		int i = 0, n = s.length();
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
		boolean isNumeric = false;
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		while (i < n && Character.isWhitespace(s.charAt(i))) i++;
		return isNumeric && i == n;
	}
}

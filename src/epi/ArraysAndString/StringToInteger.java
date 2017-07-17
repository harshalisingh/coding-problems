package epi.ArraysAndString;


public class StringToInteger {
	public static void main(String[] args){
		System.out.println(stringToIntSimple("-34843"));
	}
	public static int stringToIntSimple(String s){
		if(s == null || s.length() == 0) return 0;
		boolean isNegative = s.charAt(0) == '-';
		int result = 0;
		for(int i = isNegative ? 1 : 0; i < s.length(); i++){
			int digit = s.charAt(i) - '0';
			result = result * 10 + digit;
		}
		return isNegative ? -result : result;
	}

	/** String to Integer (atoi)
	 * https://leetcode.com/problems/string-to-integer-atoi/#/description
	 * discards all leading whitespaces
	 * sign of the number
	 * overflow
	 * invalid input
	 * 
	 * Integer.MAX_VALUE = 2147483647 (2^31 - 1)
	 * Integer.MIN_VALUE = -2147483648 (2^31)
	 */
	public static int stringToInt(String str) {
		if (str.isEmpty()) return 0;
		int sign = 1, base = 0, i = 0;
		while (str.charAt(i) == ' ')
			i++;
		if (str.charAt(i) == '-' || str.charAt(i) == '+'){
			sign = str.charAt(i) == '-' ? -1 : 1;
			i++;
		}

		while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
				return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			base = 10 * base + (str.charAt(i) - '0');
			i++;
		}
		return base * sign;
	}

}

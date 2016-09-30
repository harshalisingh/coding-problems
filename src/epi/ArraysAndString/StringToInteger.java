package epi.ArraysAndString;

public class StringToInteger {
	public static int stringToInt(String s){
		boolean isNegative = s.charAt(0) == '-';
		int result = 0;
		for(int i = isNegative ? 1 : 0; i < s.length(); i++){
			int digit = s.charAt(i) - '0';
			result = result * 10 + digit;
		}
		
		return isNegative ? -result : result;
	}

}

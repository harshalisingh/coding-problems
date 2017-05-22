package epi.ArraysAndString;

import java.security.InvalidParameterException;

public class StringToInteger {
	public static void main(String[] args){
		System.out.println(stringToInt("-34843"));
	}
	public static int stringToInt(String s){
		if(s == null || s.length() == 0){
	        throw new InvalidParameterException();
	    }
		
		boolean isNegative = s.charAt(0) == '-';
		int result = 0;
		for(int i = isNegative ? 1 : 0; i < s.length(); i++){
			int digit = s.charAt(i) - '0';
			result = result * 10 + digit;
		}
		
		return isNegative ? -result : result;
	}

}

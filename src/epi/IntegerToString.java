package epi;

public class IntegerToString {
	public static String intToString(int x){
		boolean isNegative = false;
		if(x < 0){
			x = -x;
			isNegative = true;
		}
		
		StringBuilder sb = new StringBuilder();
		do{
			char c = (char)(x % 10 + '0');
			sb.append(c);
			x /= 10;
		} while( x != 0);
		
		if(isNegative){
			sb.append('-');
		}
		
		return sb.reverse().toString();
	}

}

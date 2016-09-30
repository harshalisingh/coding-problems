package leetcode.Strings;

public class AlternateStringPrint {

	public static void main(String[] args){
		String s1 = "abcd";
		String s2 = "w";
		alternateString(s1, s2);
	}

	public static void alternateString(String s1, String s2){

		int s1Length = s1.length(), s2Length = s2.length();
		int maxLen = Math.max(s1Length, s2Length);
		for(int i = 0; i < maxLen; i++){
			if(s1Length > i){
				System.out.print(s1.charAt(i));
			}
			if(s2Length > i){
				System.out.print(s2.charAt(i));
			}
		}
	}

}

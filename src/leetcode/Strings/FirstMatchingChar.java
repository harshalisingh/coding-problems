package leetcode.Strings;

//Find first character of string B which exists in string A.
public class FirstMatchingChar {
	public int firstOccurrence(String sA, String sB){
		int[] map = new int[26];
		for(char c : sB.toCharArray()){
			map[c - 'a'] += 1;
		}
		for(int i = 0; i < sA.length(); i++){
			if(map[sA.charAt(i) - 'a'] > 0) return i;
		}
		return -1;
	}
	
	public static void main(String[] args){
		FirstMatchingChar obj = new FirstMatchingChar();
		String sA = "singh"; String sB = "harshali";
		System.out.println(obj.firstOccurrence(sA, sB));
	}
}

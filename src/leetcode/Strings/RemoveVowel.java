package leetcode.Strings;

public class RemoveVowel {
	public static String removeVowel(String s)
	{
		String t = "aeiouAEIOU";
		StringBuilder sb = new StringBuilder();
		for(char c: s.toCharArray())
		{
			if(t.indexOf(c) >= 0) continue;
			sb.append(c);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeVowel("abcdefghijk"));
	}
}

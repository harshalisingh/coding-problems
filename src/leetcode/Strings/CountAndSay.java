package leetcode.Strings;

/*
 * https://leetcode.com/problems/count-and-say/#/description
 * n = 1 to 10
   1.     1
   2.     11
   3.     21
   4.     1211
   5.     111221 
   6.     312211
   7.     13112221
   8.     1113213211
   9.     31131211131221
   10.    13211311123113112211
 */
public class CountAndSay {
	public String countAndSay(int n) {
		if (n < 0) {
			return "";
		}

		String s = "1";
		for (int i = 0; i < n - 1; i++) {
			StringBuilder sb = new StringBuilder();    //new stringbuilder must be created
			int count = 1;

			int j = 0;
			while (j < s.length()) {
				while (j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) {
					count++;
					j++;
				}
				sb.append(Integer.toString(count));
				sb.append(s.charAt(j));
				count = 1;
				j++;
			}
			s = sb.toString();
		}
		return s;
	}
	
	public static void main(String[] args){
		CountAndSay cs = new CountAndSay();
		System.out.println(cs.countAndSay(4)); //1
	}
}

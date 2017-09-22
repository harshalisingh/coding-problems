package leetcode.Strings;

public class RunLengthCompression {
	public static String encoding(String s) {
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= s.length(); i++) {
			if (i == s.length() || s.charAt(i) != s.charAt(i - 1)) {
				// Found new character so write the count of previous character.
				sb.append(s.charAt(i - 1));
				sb.append(count);			
				count = 1;
			} else { // s.charAt(i) == s.charAt(i - 1).
				++count;
			}
		}
		return sb.toString();
	}

	public static String decoding(String s) {
		int count = 0;
		char lastSeen = 0;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				count = count * 10 + (c - '0');
			} else { // c is a letter of alphabet.
				while (count > 0) { // Appends count copies of c to result.
					result.append(lastSeen);
					count--;
				}
				lastSeen = c;
			}
		}
		while (count > 0) { // Appends count copies of c to result.
			result.append(lastSeen);
			count--;
		}	
		return result.toString();
	}

	public static void main(String[] args) {
		if (args.length == 2) {
			System.out.println(encoding(args[0]) + ' ' + decoding(args[1]));
		}

		System.out.println("a4b1c3a2".equals(encoding("aaaabcccaa")));
		System.out.println(decoding("e3f4e2"));
		System.out.println("eeeffffee".equals(decoding("e3f4e2")));
		System.out.println("aaaaaaaaaaffffee".equals(decoding("a10f4e2")));
	}
}

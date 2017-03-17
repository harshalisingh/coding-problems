package leetcode.PatternSearch;

public class CustomPatternMatch {
	public static void main(String[] args) {
		System.out.println("regexMatch(\"aa\", \"a\") -> " + regexMatch("aa", "a"));
		System.out.println("regexMatch(\"aa\", \"aa\") -> " + regexMatch("aa", "aa"));
		System.out.println("regexMatch(\"aaa\", \"aa\") -> " + regexMatch("aaa", "aa"));
		System.out.println("regexMatch(\"aa\", \"a*\") -> " + regexMatch("aa", "a*"));
		System.out.println("regexMatch(\"aa\", \".*\") -> " + regexMatch("aa", ".*"));
		System.out.println("regexMatch(\"ab\", \".*\") -> " + regexMatch("ab", ".*"));
		System.out.println("regexMatch(\"aab\", \"c*a*b\") -> " + regexMatch("aab", "c*a*b"));
		System.out.println("regexMatch(\"ccca\", \"c*a\") -> " + regexMatch("ccca", "c*a"));
	}

	public static boolean regexMatch(final String inputString, final String patternString){

		char[] text = inputString.toCharArray();
		char[] pattern = patternString.toCharArray();


		boolean T[][] = new boolean[text.length + 1][pattern.length + 1];

        T[0][0] = true;
        //Deals with patterns like a* or a*b* or a*b*c*
        for (int i = 1; i < T[0].length; i++) {
            if (pattern[i-1] == '*') {
                T[0][i] = T[0][i - 2];
            }
        }

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == text[i - 1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j - 1] == '*')  {
                    T[i][j] = T[i][j - 2];
                    if (pattern[j-2] == '.' || pattern[j - 2] == text[i - 1]) {
                        T[i][j] = T[i][j] | T[i - 1][j];
                    }
                } else {
                    T[i][j] = false;
                }
            }
        }
        return T[text.length][pattern.length];

	}
}
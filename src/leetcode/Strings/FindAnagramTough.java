package leetcode.Strings;

public class FindAnagramTough {
	public static void findWord(String part, String full) {
		char c, ch;
		int k = 0;
		int fullCount = 0;
	
		mainloop: for (int i = 0; i < full.length(); i++) {
			for (int j = 0; j < part.length(); j++) {
				c = full.charAt(i);
				if (c == part.charAt(j)) {
					k = i;
					break mainloop;
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		secondloop: for (int v = k; v < full.length(); v++) {
			int partCount = 0;
			for (int p = 0; p < part.length(); p++) {
				ch = full.charAt(v);
				if (ch == part.charAt(p)) {
					sb.append(part.charAt(p));
					fullCount++;
				} else {
					partCount++;
					if (partCount == part.length() && fullCount < part.length()) {
						System.out.println("no anagram found");
						break secondloop;
					}

				}

			}
		}
		if (fullCount == part.length()) {
			System.out.println("String   " + sb.toString());
		}

	}

	public static void main(String[] args) {
		findWord("eat", "slate");
	}

}

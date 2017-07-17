package leetcode.contest;

public class GenerateAlphaCodes {

	public static char[] ALPHABET = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {

		generateString("1123", new StringBuilder(), 0);
	}

	public static void generateString(String nums, StringBuilder sb, int pos) {

		if (pos > nums.length()) {
			return;
		}
		if (pos == nums.length()) {
			System.out.println(sb);
			return;
		}

		sb.append(ALPHABET[Integer.parseInt(nums.substring(pos, pos + 1))]);
		generateString(nums, sb, pos + 1);
		sb.setLength(sb.length() - 1);

		if (pos + 2 <= nums.length()) {
			sb.append(ALPHABET[Integer.parseInt(nums.substring(pos, pos + 2))]);
			generateString(nums, sb, pos + 2);
			sb.setLength(sb.length() - 1);
		}
	}

}

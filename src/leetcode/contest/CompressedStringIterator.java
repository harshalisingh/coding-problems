package leetcode.contest;

/**
 * https://leetcode.com/problems/design-compressed-string-iterator/#/description
 */
public class CompressedStringIterator {
	public static void main(String[] args){
		StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");

		System.out.println(iterator.next()); // return 'L'
		System.out.println(iterator.next());  // return 'e'
		System.out.println(iterator.next());  // return 'e'
		System.out.println(iterator.next());  // return 't'
		System.out.println(iterator.next());  // return 'C'
		System.out.println(iterator.next());  // return 'o'
		System.out.println(iterator.next());  // return 'd'
		System.out.println(iterator.hasNext()); // return true
		System.out.println(iterator.next());  // return 'e'
		System.out.println(iterator.hasNext()); // return false
		System.out.println(iterator.next());  // return ' '
	}
}

class StringIterator {
	String res;
	int i = 0, count = 0; //i to keep track of characters, count to keep track of occurrences
	char ch = ' ';
	public StringIterator(String compressedString) {
		this.res = compressedString;
	}
	public char next() {
		if (!hasNext())
			return ' ';
		if (count == 0) {
			ch = res.charAt(i++); //get next character
			while (i < res.length() && Character.isDigit(res.charAt(i))) { //get the number followed by the character
				count = count * 10 + res.charAt(i++) - '0';
			}
		}
		count--;
		return ch;
	}
	public boolean hasNext() {
		return i != res.length() || count != 0;
	}
}

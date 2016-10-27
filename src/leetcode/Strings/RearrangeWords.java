package leetcode.Strings;

//Lexicographic Ordering
public class RearrangeWords {
	static String rearrangeWord(String word) {
		char[] charArr = word.toCharArray();
		int k = -1;
		int len = charArr.length;
		for(int i = len - 2; i >= 0; i--){
			if(charArr[i] < charArr[i+1]){
				k = i;
				break;
			}
		}

		if(k == -1){
			return "no answer";
		}

		int j = -1;
		for(int i = len - 1; i > k; i--){
			if(charArr[i] > charArr[k]){
				j = i;
				break;
			}
		}

		char temp = charArr[k];
		charArr[k] = charArr[j];
		charArr[j] = temp;

		char[] newWord = new char[len];
		for(int i = 0; i < k+1; i++){
			newWord[i] = charArr[i];
		}

		int l = 1;
		for(int i = len - 1; i > k; i--){
			newWord[k+l] = charArr[i];
			l++;
		}
		return new String(newWord);
	}
}

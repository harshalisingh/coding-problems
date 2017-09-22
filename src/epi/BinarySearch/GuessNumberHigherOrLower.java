package epi.BinarySearch;

public class GuessNumberHigherOrLower {
	//https://leetcode.com/problems/guess-number-higher-or-lower/#/description
	public int guessNumber(int n) {
		int low = 1, high = n;
		while(low < high){
			int mid = low + (high - low) / 2;
			if(guess(mid) == 0){
				return mid;
			} else if(guess(mid) == 1){
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	private int guess(int mid) {
		return 0;
	}

	
}

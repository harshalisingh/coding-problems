package leetcode;

public class TwoSumII {
	public static int[] twoSumII(int[] numbers, int target){
		
		if(numbers == null || numbers.length == 0){
			return null;
		}
		
		int i = 0;
		int j = numbers.length - 1;
		
		while(i < j){
			int x = numbers[i] + numbers[j];
			if(x < target){
				++i;
			} else if(x > target){
				j--;
			} else {
				return new int[] {i, j};
			}
		}
		return null;
	}
	
	public static void main(String[] args){
		int[] numbers = new int[]{2, 5, 7, 8, 9};
		int target = 9;
		
		int[] result = twoSumII(numbers, target);
		System.out.println(result[0] + " " + result[1]);
	}
}

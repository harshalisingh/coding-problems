package leetcode.Arrays;

public class ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
        Integer max = null, mid = null, min = null;
        for (int num : nums) {
            if (max == null || num > max) {
                min = mid;
                mid = max;
                max = num;
            }
            else if ((mid == null || num > mid) && num != max) {
                min = mid;
                mid = num;
            }
            else if ((min == null || num > min) && num != max && num != mid) {
                min = num;
            }
        }
        return min == null ? max : min;
    }
	
	public static void main(String[] args){
		int[] arr = {-1, 2, 3, -4, 5, -6, 3};
		
	}
}

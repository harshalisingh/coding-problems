package leetcode.Backtracking;

import java.util.Arrays;

public class NextPermutation {
	
	//https://leetcode.com/problems/next-permutation/#/description
	public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        //We need to find the first pair of two successive numbers 
        //a[i] and a[i-1], from the right, which satisfy a[i] > a[i-1]. 
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
    	NextPermutation caller = new NextPermutation();
    	int[] nums = {9,8,7,6,5};
    	caller.nextPermutation(nums);
    	System.out.println(Arrays.toString(nums));
    }
}

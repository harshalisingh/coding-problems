package leetcode.Sorting;

import java.util.Arrays;

//Average and Worst Case: O(n logn), Memory: O(n)
public class MergeSort {

	public int mergeSort(int[] nums) {
		int[] helper = new int[nums.length];
		return mergeSort(nums, helper, 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int[] helper, int low, int high) {
		int invCount = 0;
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			invCount += mergeSort(nums, helper, low, middle);
			// Sort the right side of the array
			invCount += mergeSort(nums, helper, middle + 1, high);
			// Combine them both
			invCount += merge(nums, helper, low, middle, high);
		}
		return invCount;
	}

	private int merge(int[] nums, int[] helper, int low, int mid, int high) {

		int invCount = 0;
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = nums[i];
		}

		int i = low;
		int j = mid + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= mid && j <= high) {
			if (helper[i] <= helper[j]) {
				nums[k] = helper[i];
				i++;
			} else {
				nums[k] = helper[j];
				j++;

				//if a[i] is greater than a[j], so all the remaining elements in left-subarray will be greater than a[j]
				invCount = invCount + (mid - i + 1); 
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= mid) {
			nums[k] = helper[i];
			k++;
			i++;
		}
		return invCount;

	}
	public static void main(String[] args){
		MergeSort ms = new MergeSort();
		int[] nums = {3,6,4,9,8,1,2,6,7,0,3,5,7,3};
		int invCount = ms.mergeSort(nums);
		System.out.println(Arrays.toString(nums));
		System.out.println("number of inversion: " + invCount);
	}
}
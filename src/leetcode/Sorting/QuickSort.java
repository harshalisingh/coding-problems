package leetcode.Sorting;

import java.util.Arrays;

//Average: O(n logn), Worst Case: O(n^2), Memory: O(1)
//http://me.dt.in.th/page/Quicksort/
public class QuickSort  {
	public void quickSort(int[] nums) {
		// check for empty or null array
		if (nums ==null || nums.length==0){
			return;
		}
		quickSort(nums, 0, nums.length - 1);
	}
	private void quickSort(int[] arr, int left, int right){
		int index = partition(arr, left, right);
		if(left < index - 1) { //Sort left half
			quickSort(arr, left, index - 1);
		}
		if(index < right) { //Sort right half
			quickSort(arr, index, right);
		}
	}

	private int partition(int[] arr, int lo, int hi) {
		// Get the pivot element from the middle of the list
		int pivot = arr[lo + (hi - lo)/2];

		// Divide into two lists
		while (lo <= hi) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			//Find element on left that should be on right
			while (arr[lo] < pivot) lo++;


			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			//Find element on right that should be on left
			while (arr[hi] > pivot) hi--;


			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can move left and right indices
			if (lo <= hi) {
				swap(arr, lo, hi);
				lo++;
				hi--;
			}
		}
		return lo;
	}

	private void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		int[] numsA = {3,6,4,9,8,1,2,6,7,0,3,5,7,3};
		int[] numsB = {0,-1,7,8,9,2,2,3,6};
		int[] numsC = {8, 3, 7, 9, 6, 1, 9, 10};
		qs.quickSort(numsA);
		qs.quickSort(numsB);
		qs.quickSort(numsC);
		System.out.println(Arrays.toString(numsA));
		System.out.println(Arrays.toString(numsB));
		System.out.println(Arrays.toString(numsC));
	}
}

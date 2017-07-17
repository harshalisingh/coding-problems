package leetcode.Sorting;

import java.util.Arrays;

//Average: O(n logn), Worst Case: O(n^2), Memory: O(1)
public class QuickSort  {
	public void quickSort(int[] nums) {
		// check for empty or null array
		if (nums ==null || nums.length==0){
			return;
		}
		quickSort(nums, 0, nums.length - 1);
		int kthLargest = quickSelect(nums, 0, nums.length - 1, 7);
		System.out.println(kthLargest);
	}
	private void quickSort(int[] arr, int left, int right){
		int pivot = partition(arr, left, right);
		if(left < pivot - 1) { //Sort left half
			quickSort(arr, left, pivot - 1);
		}
		if(pivot < right) { //Sort right half
			quickSort(arr, pivot, right);
		}
	}

	private int quickSelect(int[] arr, int left, int right, int k){
		if (left == right) {
            return arr[left];
        }

        while (true) {
            int pivot = partition(arr, left, right);
            if (pivot == k) {
                return arr[pivot];
            } else if (k < pivot) {
            	right = pivot - 1;
            } else {
            	left = pivot + 1;
            }
        }
	}

	private int partition(int[] arr, int left, int right) {
		// Get the pivot element from the middle of the list
		int pivot = arr[(left + right)/2];

		// Divide into two lists
		while (left <= right) {
			// If the current value from the left list is smaller then the pivot
			// element then get the next element from the left list
			//Find element on left that should be on right
			while (arr[left] < pivot) left++;


			// If the current value from the right list is larger then the pivot
			// element then get the next element from the right list
			//Find element on right that should be on left
			while (arr[right] > pivot) right--;


			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can move left and right indices
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
	}

	private void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args){
		QuickSort qs = new QuickSort();
		int[] nums = {3,6,4,9,8,1,2,6,7,0,3,5,7,3};
		qs.quickSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}

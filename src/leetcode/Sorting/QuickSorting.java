package leetcode.Sorting;

import java.util.Arrays;

public class QuickSorting {
	//http://buttercola.blogspot.com/2014/12/data-structure-algorithms-sorting.html
	public void quickSort(int[] A) {
		if (A == null || A.length <= 1) {
			return;
		}

		//Collections.shuffle(A);
		quickSortHelper(A, 0, A.length - 1);
	}

	private void quickSortHelper(int[] A, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int index = partition(A, lo, hi);
		quickSortHelper(A, lo, index - 1);
		quickSortHelper(A, index + 1, hi);
	}

	//  partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <=
	//  a[j+1..hi]
	//  and return the index j.
	private int partition(int[] A, int lo, int hi) {
		int pivot = A[lo];
		int i = lo + 1;
		int j = hi;

		while (i <= j) {
			while (i <= j && A[i] < pivot) {
				i++;
			}

			while (i <= j && A[j] >= pivot) {
				j--;
			}
			if (i <= j) {
				swap(A, i, j);
			}
		}

		// swap the pivot 
		swap(A, lo, j);

		return j;
	}
	
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
    //http://buttercola.blogspot.com/2015/08/leetcode-kth-largest-element-in-array.html
	public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        return findKthLargestHelper(nums, 0, nums.length - 1, nums.length - k);
    }
     
    private int findKthLargestHelper(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) {
            return nums[lo];
        }
         
        int pivot = partition(nums, lo, hi);
        if (pivot == k) {
            return nums[k];
        }
         
        if (pivot > k) {
            return findKthLargestHelper(nums, lo, pivot - 1, k);
        } else {
            return findKthLargestHelper(nums, pivot + 1, hi, k);
        }
    }
    
	public static void main(String[] args) {
		QuickSorting obj = new QuickSorting();
		int[] numsA = {3,6,4,9,8,1,2,6,7,0,3,5,7,3};
		int[] numsB = {0,-1,7,8,9,2,2,3,6};
		int[] numsC = {8, 3, 7, 9, 6, 1, 9, 10};
		obj.quickSort(numsA);
		obj.quickSort(numsB);
		obj.quickSort(numsC);
		System.out.println(Arrays.toString(numsA));
		System.out.println(Arrays.toString(numsB));
		System.out.println(Arrays.toString(numsC));
	}
}

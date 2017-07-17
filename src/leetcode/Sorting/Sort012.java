package leetcode.Sorting;

import java.util.Arrays;

/**
 * Variation of Dutch National Flag problem. Time Complexity: O(n)
 */
public class Sort012 {

	//Sort an array consisting of 0s and 1s
	private static void separate01(int[] arr){
		/* Initialize lo and hi indices */
		int lo = 0, hi = arr.length - 1;

		while (lo < hi) {
			/* Increment left index while we see 0 at left */
			while (arr[lo] == 0 && lo < hi)
				lo++;

			/* Decrement right index while we see 1 at right */
			while (arr[hi] == 1 && lo < hi)
				hi--;

			/* If left is smaller than right then there is a 1 at left
               and a 0 at right.  Exchange arr[lo] and arr[hi]*/
			if (lo < hi) {
				arr[lo] = 0;
				arr[hi] = 1;
				lo++;
				hi--;
			}
		}
	}

	//Sort an array consisting of 0s, 1s and 2s
	private static void separate012(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int lo = 0, mid = 0, hi = arr.length - 1;
		while (mid <= hi)
			switch (arr[mid]) {
			case 0:
				swap(arr, lo++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr, mid, hi--);
				break;
			}
	}
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args){
		int arr1[] = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1};
		int arr2[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		separate01(arr1);
		separate012(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}


}

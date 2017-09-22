package leetcode.Arrays;

import java.util.Arrays;
import java.util.Collections;

public class DescendingOddAscendingEven {
	// To do two way sort. First sort even numbers in ascending order, then odd numbers in descending order.
	void twoWaySort(Integer[] arr, int n) {
		// Current indexes from left and right
		int l = 0, r = n-1;

		// Count of odd numbers
		int k = 0;
		while (l < r) {
			// Find first even number from left side.
			while (arr[l]%2 != 0) {
				l++;
				k++;
			}

			// Find first odd number from right side.
			while (arr[r]%2 == 0  && l<r){
				r--;
			}

			// Swap even number present on left and odd number right.
			if (l < r) {
				//  swap arr[l] arr[r]
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;

			}

		}

		// Sort odd number in descending order
		Arrays.sort(arr, 0, k, Collections.reverseOrder());

		// Sort even number in ascending order
		Arrays.sort(arr, k, n);
	}

	// To do two way sort. First sort even numbers in
	// ascending order, then odd numbers in descending
	// order.
	static void twoWaySort(int arr[], int n){
		// Make all odd numbers negative
		for (int i=0 ; i<n ; i++)
			if ((arr[i] & 1) != 0) // Check for odd
				arr[i] *= -1;

		// Sort all numbers
		Arrays.sort(arr);

		// Retaining original array
		for (int i=0 ; i<n ; i++)
			if ((arr[i] & 1) != 0)
				arr[i] *= -1;
	}


	public void printArray(Integer[] arrA) {
		for (int i = 0; i < arrA.length; i++) {
			System.out.print(" " + arrA[i]);
		}
	}

	public static void main(String args[]) {
		Integer[] arrA = new Integer[] {1,2,3,4,5,6,7,8,8,10};
		DescendingOddAscendingEven d = new DescendingOddAscendingEven();
		System.out.println("Original Array : ");
		d.printArray(arrA);
		System.out.println("\nOutput Array : ");
		d.twoWaySort(arrA, 10);
		d.printArray(arrA);

	}
}

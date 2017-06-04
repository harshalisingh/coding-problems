package leetcode.Sorting;

public class Sorting {

	//Average and Worst Time Complexity: O(n^2), Memory: O(1)
	//Best Case Time Complexity: O(n). Best case occurs when array is already sorted.
	public static void bubbleSort(int[] arr) {  
		int n = arr.length;
		boolean swapped = true;   // set flag to true to begin first pass
		for (int i = 0; i < n-1; i++) {
			swapped = false;
			for (int j = 0; j < n-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}

			// IF no two elements were swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	//Average and Worst Time Complexity: O(n^2), Memory: O(1)
	public static void selectionSort(int[] a)
	{ // Sort a[] into increasing order.
		int n = a.length; // array length
		for (int i = 0; i < n; i++)
		{ // Exchange a[i] with smallest entry in a[i+1...N).
			int min = i; // index of minimal entry.
			for (int j = i+1; j < n; j++)
				if (a[j] < a[min]) 
					min = j;
			swap(a, i, min);
		}
	}

	public static void insertionSort(int[] a)
	{ // Sort a[] into increasing order.
		int N = a.length;
		for (int i = 1; i < N; i++)
		{ // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
			for (int j = i; j > 0 && (a[j] < a[j-1]); j--)
				swap(a, j, j-1);
		}
	}

	private static void swap(int[] a, int i, int min) {
		int temp = a[i];
		a[i] = a[min];
		a[min] = temp;

	}
}

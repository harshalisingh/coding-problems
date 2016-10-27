package leetcode.Sorting;

public class Sorting {
	public static void selectionSort(int[] a)
	{ // Sort a[] into increasing order.
		int N = a.length; // array length
		for (int i = 0; i < N; i++)
		{ // Exchange a[i] with smallest entry in a[i+1...N).
			int min = i; // index of minimal entry.
			for (int j = i+1; j < N; j++)
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

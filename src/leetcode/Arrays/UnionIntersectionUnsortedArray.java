package leetcode.Arrays;

import java.util.Arrays;

class UnionIntersectionUnsortedArray
{
	// Prints union of arr1[0..m-1] and arr2[0..n-1]
	void printUnion(int arr1[], int arr2[], int m, int n) 
	{
		// Before finding union, make sure arr1[0..m-1] is smaller
		if (m > n) 
		{
			int tempp[] = arr1;
			arr1 = arr2;
			arr2 = tempp;

			int temp = m;
			m = n;
			n = temp;
		}

		// Now arr1[] is smaller
		// Sort the first array and print its elements (these two
		// steps can be swapped as order in output is not important)
		Arrays.sort(arr1);
		for (int i = 0; i < m; i++)
			System.out.print(arr1[i] + " ");

		// Search every element of bigger array in smaller array
		// and print the element if not found
		for (int i = 0; i < n; i++) 
		{
			if (binarySearch(arr1, arr2[i]) == -1)
				System.out.print(arr2[i] + " ");
		}
	}

	// Prints intersection of arr1[0..m-1] and arr2[0..n-1]
	void printIntersection(int arr1[], int arr2[], int m, int n) 
	{
		// Before finding intersection, make sure arr1[0..m-1] is smaller
		if (m > n) 
		{
			int tempp[] = arr1;
			arr1 = arr2;
			arr2 = tempp;

			int temp = m;
			m = n;
			n = temp;
		}

		// Now arr1[] is smaller
		// Sort smaller array arr1[0..m-1]
		Arrays.sort(arr1);

		// Search every element of bigger array in smaller array
		// and print the element if found
		for (int i = 0; i < n; i++) 
		{
			if (binarySearch(arr1, arr2[i]) != -1) 
				System.out.print(arr2[i] + " ");
		}
	}

	// A recursive binary search function. It returns location of x in
	// given array arr[l..r] is present, otherwise -1
	public int binarySearch(int[] A, int t){

		int low = 0, high = A.length - 1;
		while(low <= high){
			int mid = low + (high - low)/2;
			if(A[mid] < t){
				low = mid + 1;
			} else if(A[mid] == t){
				return mid;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}

	// Driver program to test above functions
	public static void main(String[] args) 
	{
		UnionIntersectionUnsortedArray u_i = new UnionIntersectionUnsortedArray();
		int arr1[] = {7, 1, 5, 2, 3, 6};
		int arr2[] = {3, 8, 6, 20, 7};
		int m = arr1.length;
		int n = arr2.length;
		System.out.println("Union of two arrays is ");
		u_i.printUnion(arr1, arr2, m, n);
		System.out.println("");
		System.out.println("Intersection of two arrays is ");
		u_i.printIntersection(arr1, arr2, m, n);
	}
}
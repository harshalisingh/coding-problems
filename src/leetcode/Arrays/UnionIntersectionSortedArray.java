package leetcode.Arrays;

//O(m + n) algorithms to find union and intersection of two sorted arrays.
//http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/

public class UnionIntersectionSortedArray {

	/* Function prints union of arr1[] and arr2[]
	   m is the number of elements in arr1[]
	   n is the number of elements in arr2[] */
	void printUnion(int arr1[], int arr2[], int m, int n)
	{
		int i = 0, j = 0;
		while (i < m && j < n)
		{
			if (arr1[i] < arr2[j])
				System.out.print(arr1[i++]);
			else if (arr2[j] < arr1[i])
				System.out.print(arr2[j++]);
			else
			{
				System.out.print(arr2[j++]);
				i++;
			}
		}

		/* Print remaining elements of the larger array */
		while(i < m)
			System.out.print(arr1[i++]);
		while(j < n)
			System.out.print(arr2[j++]);
	}

	/* Function prints Intersection of arr1[] and arr2[]
	   m is the number of elements in arr1[]
	   n is the number of elements in arr2[] */
	void printIntersection(int arr1[], int arr2[], int m, int n)
	{
		int i = 0, j = 0;
		while (i < m && j < n)
		{
			if (arr1[i] < arr2[j])
				i++;
			else if (arr2[j] < arr1[i])
				j++;
			else {
				/* if arr1[i] == arr2[j] */
				System.out.print(arr2[j++]);
				i++;
			}
		}
	}

}

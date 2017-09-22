package leetcode.Sorting;

/*
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeTwoSortedArrays {
	public void merge(int A[], int m, int B[], int n) {
		int i = m-1;
		int j = n-1;
		int k = m + n - 1;
		while(i >=0 && j>=0)
		{
			if(A[i] > B[j])
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
		while(j>=0)
			A[k--] = B[j--];
	}

	public static int[] sortedArrayMerge(int a[], int b[]) {
		int result[] = new int[a.length +b.length];
		int i =0; int j = 0;int k = 0;
		while(i<a.length && j <b.length) {
			if(a[i]<b[j]) {
				result[k++] = a[i];
				i++;
			} else {
				result[k++] = b[j];
				j++;
			}
		}
		System.arraycopy(a, i, result, k, (a.length -i));
		System.arraycopy(b, j, result, k, (b.length -j));
		return result;
	}
}

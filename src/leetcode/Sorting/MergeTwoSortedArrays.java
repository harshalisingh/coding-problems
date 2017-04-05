package leetcode.Sorting;

public class MergeTwoSortedArrays {
	public void merge(int A[], int m, int B[], int n) {
		while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
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

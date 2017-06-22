package epi.BinarySearch;

/**
 * https://discuss.leetcode.com/topic/16797/very-concise-o-log-min-m-n-iterative-solution-with-detailed-explanation
 * Time Complexity:  O(log(min(M,N))) 
 */
public class FindMedianTwoSortedArray {
	double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int N1 = nums1.length;
	    int N2 = nums2.length;
	    if (N1 < N2) return findMedianSortedArrays(nums2, nums1);	// Make sure A2 is the shorter one.
	    
	    if (N2 == 0) return ((double)nums1[(N1-1)/2] + (double)nums1[N1/2])/2;  // If A2 is empty
	    
	    int lo = 0, hi = N2 * 2;
	    while (lo <= hi) {
	        int mid2 = (lo + hi) / 2;   // Try Cut 2 
	        int mid1 = N1 + N2 - mid2;  // Calculate Cut 1 accordingly
	        
	        double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1-1)/2];	// Get L1, R1, L2, R2 respectively
	        double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2-1)/2];
	        double R1 = (mid1 == N1 * 2) ? Integer.MAX_VALUE : nums1[(mid1)/2];
	        double R2 = (mid2 == N2 * 2) ? Integer.MAX_VALUE  : nums2[(mid2)/2];
	        
	        if (L1 > R2) lo = mid2 + 1;		// A1's lower half is too big; need to move C1 left (C2 right)
	        else if (L2 > R1) hi = mid2 - 1;	// A2's lower half too big; need to move C2 left.
	        else return (Math.max(L1,L2) + Math.min(R1, R2)) / 2;	// Otherwise, that's the right cut.
	    }
	    return -1;
	} 
	public static void main(String[] args){
		FindMedianTwoSortedArray fm = new FindMedianTwoSortedArray();
		int[] nums1 = new int[]{1,2,3,4,5};
		int[] nums2 = new int[]{3,7,8};
		System.out.println(fm.findMedianSortedArrays(nums1, nums2));
	}
}

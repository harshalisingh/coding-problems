package leetcode.Sorting;

import java.util.Arrays;

/**
 * 3-Way QuickSort (Dutch National Flag Problem)
 * Not stable, O(lg(n)) extra space
 * O(n^2) time, but typically O(n·lg(n)) time
 * Adaptive: O(n) time when O(1) unique keys
 */
public class DutchFlagPartition {
    
	public static void dutchFlagPartition(int[] a, int lo, int hi){
		if (hi <= lo) return;
        int sm = lo, gt = hi;
        int v = a[lo];
        int eq = lo;
        while (eq <= gt) {
        	if(a[eq] < v){
        		swap(a, sm++, eq++);
        	} else if(a[eq] > v){
        		swap(a, eq, gt--);
        	} else {
        		eq++;
        	}
        }

        // a[lo..sm-1] < v = a[sm..gt] < a[gt+1..hi]. 
        dutchFlagPartition(a, lo, sm-1);
        dutchFlagPartition(a, gt+1, hi);
		
	}
	private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
	
	public static void main(String[] args){
		int[] input = {2, 5, 3, 1, 0, 0, 4, 0, 1, 1, 2, 1, 2, 3};
		dutchFlagPartition(input, 0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}
}

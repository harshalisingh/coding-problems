package leetcode.Sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/** Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Given [3,2,1,5,6,4] and k = 2, return 5. You may assume k is always valid, 1 ? k ? array's length.
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class KthLargestElementLeetCode {
	//Time: O(nlogn), Space: O(1)
	public int findKthLargestSorting(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	//Time: O(n logk), Space:O(k)
	public int findKthLargestMinHeap(int[] nums, int k) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int val : nums) {
			pq.offer(val);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek(); //heap maintains the top k elements, remove minimum -> kth largest
	}

	//O(N) best case / O(N^2) worst case running time + O(1) memory
	public int findKthLargestQuickSelect(int[] nums, int k) {
		k = nums.length - k;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			final int pivot = partition(nums, lo, hi);
			if(pivot < k) {
				lo = pivot + 1;
			} else if (pivot > k) {
				hi = pivot - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private int partition(int[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while(true) {
			while(i < hi && less(a[++i], a[lo]));
			while(j > lo && less(a[lo], a[--j]));
			if(i >= j) {
				break;
			}
			swap(a, i, j);
		}
		swap(a, lo, j);
		return j;
	}

	private void swap(int[] a, int i, int j) {
		final int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private boolean less(int v, int w) {
		return v < w;
	}

	//O(N) guaranteed running time + O(1) space
	public int findKthLargestRandomize(int[] nums, int k) {
		shuffle(nums);
		k = nums.length - k;
		int lo = 0;
		int hi = nums.length - 1;
		while (lo < hi) {
			final int j = partition(nums, lo, hi);
			if(j < k) {
				lo = j + 1;
			} else if (j > k) {
				hi = j - 1;
			} else {
				break;
			}
		}
		return nums[k];
	}

	private void shuffle(int a[]) {
		final Random random = new Random();
		for(int ind = 1; ind < a.length; ind++) {
			final int r = random.nextInt(ind + 1);
			swap(a, ind, r);
		}
	}
}

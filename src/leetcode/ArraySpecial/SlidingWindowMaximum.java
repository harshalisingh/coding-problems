package leetcode.ArraySpecial;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. 
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 */
public class SlidingWindowMaximum {
	
	//Using Arrays Time: O(N)
	public static int[] slidingWindowMax(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}
		int[] max_left = new int[nums.length];
		int[] max_right = new int[nums.length];
		max_left[0] = nums[0];
		max_right[nums.length - 1] = nums[nums.length - 1];

		for (int i = 1; i < nums.length; i++) {
			max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);

			final int j = nums.length - i - 1;
			max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
		}

		final int[] sliding_max = new int[nums.length - k + 1]; //size of result array 
//		for (int i = 0, j = 0; i + k <= nums.length; i++) {
//			sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
//		}

		for (int i = 0, j = 0; i <= nums.length - k; i++) {
			sliding_max[j++] = Math.max(max_right[i], max_left[i + k - 1]);
		}
		
		return sliding_max;
	}

	//Using Dequeue
	public static ArrayList<Integer> maxSlidingWindowQueue(int[] nums, int k) {		
		if (nums == null || k <= 0) {
			return new ArrayList<>();
		}
		ArrayList<Integer> res = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			// remove numbers out of range k
			while (!q.isEmpty() && q.peek() < i - k + 1) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}
			// q contains index... res contains content
			q.offer(i);
			if (i >= k - 1) {
				// every peek element is the smallest one in the q
				res.add(nums[q.peek()]); 
			}
		}
		return res;
	}
	
	/*
	 * create a MaxHeap size of k, add k elements in each out for loop
	 * in each step, extract the max and clear the queue for next iteration.
	 */
	private static int[] maxSlidingWindowHeap(int[] a, int k) {
		if(a == null || a.length == 0) return new int[] {};
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int[] result = new int[a.length - k + 1];
		int count = 0;
		for (int i = 0; i < a.length - k + 1; i++) {
			for (int j = i; j < i + k; j++) {
				pq.offer(a[j]);
			}
			result[count] = pq.poll();
			count = count + 1;
			pq.clear();
		}
		return result;

	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindowHeap(a, k)));
		System.out.println(maxSlidingWindowQueue(a, k).toString());
		System.out.println(Arrays.toString(slidingWindowMax(a, k)));
	}
}

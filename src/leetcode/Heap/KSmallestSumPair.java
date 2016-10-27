package leetcode.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Uses Min-Heap
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * */

public class KSmallestSumPair {
	class Pair implements Comparable<Pair>{
		int[] pair;
		int idx; // current index to nums2
		long sum;
		Pair(int idx, int n1, int n2){
			this.idx = idx;
			pair = new int[]{n1, n2};
			sum = (long) n1 + (long) n2;
		}
		
		@Override
		public int compareTo(Pair o) {
			return Long.compare(sum, o.sum);
		}
	}
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<>();
		if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0) return ret;

		PriorityQueue<Pair> q = new PriorityQueue<Pair>(k); 
		for (int i=0; i < nums1.length && i<k ; i++) { // only need first k number in nums1 to start  
			q.offer( new Pair(0, nums1[i], nums2[0]) );
		}
		for (int i=1; i<=k && !q.isEmpty(); i++) { // get the first k sums
			Pair p = q.poll();  //Get the minimum
			ret.add( p.pair );
			if (p.idx < nums2.length - 1 ) { // get to next value in nums2
				int next = p.idx + 1;
				q.offer( new Pair(next, p.pair[0], nums2[next]) );
			}
		}
		return ret;
	}

}

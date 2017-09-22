package leetcode.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements. Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
class Pair{
	int num;
	int count;
	public Pair(int num, int count){
		this.num=num;
		this.count=count;
	}
}

//use maxHeap. Put entry into maxHeap so we can always poll a number with largest frequency
public class TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		//count the frequency for each element
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num: nums){
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		// create a max heap
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
			@Override
			public int compare(Pair a, Pair b){
				return b.count - a.count;
			}
		});

		//maintain a heap of size k. 
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			Pair p = new Pair(entry.getKey(), entry.getValue());
			queue.offer(p);
		}

		//get all elements from the heap
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		while(i < k){
			result.add(queue.poll().num);
			i++;
		}

		return result;
	}

	// use an array to save numbers into different bucket whose index is the frequency
	public List<Integer> topKFrequentBucketSort(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();
		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,3,2,2,2,4,7,7,9,10,7};
		System.out.println(topKFrequent(nums, 3).toString());
	}

}

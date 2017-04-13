package leetcode.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair{
	int num;
	int count;
	public Pair(int num, int count){
		this.num=num;
		this.count=count;
	}
}

public class TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		//count the frequency for each element
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int num: nums){
			if(map.containsKey(num)){
				map.put(num, map.get(num)+1);
			}else{
				map.put(num, 1);
			}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,3,2,2,2,4,7,7,9,10,7};
		System.out.println(topKFrequent(nums, 3).toString());
	}

}

package leetcode.Heap;

import java.util.PriorityQueue;
import java.util.Comparator;

public class HeapTest {
	public static void main(String[] args){
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxPQ = new PriorityQueue<>(10, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return b - a;
			}
		});
		
		for(int i = 1; i < 10; i++){
			minPQ.offer(i);
			maxPQ.offer(i);
		}
		
		while(!maxPQ.isEmpty()){
			//System.out.println(minPQ.poll());
			System.out.println(maxPQ.poll());
		}
	}
}

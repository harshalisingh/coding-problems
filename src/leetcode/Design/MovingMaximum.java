package leetcode.Design;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingMaximum {
	private int size;
	private int max;
	private Queue<Integer> queue;

	public MovingMaximum(int size) {
		this.size = size;
		this.max = Integer.MIN_VALUE;
		this.queue = new ArrayDeque<>();
	}

	public void add(int num){
		queue.offer(num);
		max = Math.max(num, max);
		if(queue.size() > size){
			queue.poll();
		}
	}

	public int getMax(){
		return max;
	}

	public static void main(String[] args){
		MovingMaximum mm = new MovingMaximum(3);
		System.out.println(mm.getMax());
		mm.add(1);
		System.out.println(mm.getMax());
		mm.add(3);
		System.out.println(mm.getMax());
		mm.add(2);
		System.out.println(mm.getMax());
		mm.add(-1);
		System.out.println(mm.getMax());
		mm.add(4);
		System.out.println(mm.getMax());
		mm.add(7);
		System.out.println(mm.getMax());
		mm.add(8);
		System.out.println(mm.getMax());
		mm.add(5);
		System.out.println(mm.getMax());
	}
}

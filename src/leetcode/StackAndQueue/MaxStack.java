package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

	int max = Integer.MIN_VALUE;
	Deque<Integer> stack = new ArrayDeque<Integer>();

	public void push(int x){
		// only push the old maximum value when the current 
		// maximum value changes after pushing the new value x
		if(x >= max){          
			stack.push(max);
			max = x;
		}
		stack.push(x);
	}

	public void pop() {
		// if pop operation could result in the changing of the current maximum value, 
		// pop twice and change the current maximum value to the last maximum value.
		int top = stack.pop();
		if (top == max)
			max = stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMax() {
		return max;
	}
	public static void main(String[] args) {
		MaxStack max = new MaxStack();
		max.push(1);
		System.out.println(max.getMax());
		max.push(10);
		System.out.println(max.getMax());
		max.push(9);
		System.out.println(max.getMax());
		max.push(19);
		System.out.println(max.getMax());
		max.pop();
		System.out.println(max.getMax());

	}
}

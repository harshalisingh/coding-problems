package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SortStack {
	public static Deque<Integer> sortStack(Deque<Integer> s) {
		Deque<Integer> r = new ArrayDeque<Integer>();

	    while(!s.isEmpty()) {
	        int tmp = s.pop();
	        while(!r.isEmpty() && r.peek() > tmp) {
	            s.push(r.pop());
	        }
	        r.push(tmp);
	    }
	    return r;
	}
	
	public static void main(String[] args){
		SortStack ss = new SortStack();
		Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(8);
        stack.push(3);
        stack.push(5);
        stack.push(2);
        stack.push(1);
        printStack(stack);
        stack = ss.sortStack(stack);
        printStack(stack);
        
        System.out.println(stack.pop());
	}
	
	private static void printStack(Deque<Integer> stack){
    	System.out.println(Arrays.toString(stack.toArray()));
    }
}

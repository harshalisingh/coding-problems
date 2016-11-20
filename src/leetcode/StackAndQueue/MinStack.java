package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * https://leetcode.com/problems/min-stack/
 */
class MinStack {
    int min=Integer.MAX_VALUE;
    Deque<Integer> stack = new ArrayDeque<Integer>();
    public void push(int x) {
       // only push the old minimum value when the current 
       // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
       // if pop operation could result in the changing of the current minimum value, 
       // pop twice and change the current minimum value to the last minimum value.
    	int top = stack.pop();
        if (top == min)
            min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

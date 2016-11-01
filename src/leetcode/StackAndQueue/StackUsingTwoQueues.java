package leetcode.StackAndQueue;
import java.util.Deque;
import java.util.LinkedList;

public class StackUsingTwoQueues {
	//using two queue. The push is inefficient.
	private Deque<Integer> q1 = new LinkedList<Integer>();
	private Deque<Integer> q2 = new LinkedList<Integer>();
	public void push(int x) {
	    if(q1.isEmpty()) {
	        q1.add(x);
	        for(int i = 0; i < q2.size(); i ++)
	            q1.add(q2.poll());
	    }else {
	        q2.add(x);
	        for(int i = 0; i < q1.size(); i++)
	            q2.add(q1.poll());
	    }
	}

	public void pop() {
	    if(!q1.isEmpty()) 
	        q1.poll();
	    else
	        q2.poll();
	}
	public int top() {
	    return q1.isEmpty() ? q2.peek() : q1.peek();
	}
	public boolean empty() {
	    return q1.isEmpty() && q2.isEmpty();
	}
}

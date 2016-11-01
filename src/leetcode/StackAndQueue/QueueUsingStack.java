package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/implement-queue-using-stacks/
public class QueueUsingStack {

	private Deque<Integer> s1;    // back of queue
	private Deque<Integer> s2;    // front of queue

	// create an empty queue
	public QueueUsingStack() {
		s1 = new ArrayDeque<Integer>();
		s2 = new ArrayDeque<Integer>();
	}

	// Push element x to the back of queue.
	public void push(int x) {
		s1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		peek();
		s2.pop();
	}

	// Get the front element.
	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
		}

		return s2.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}

}

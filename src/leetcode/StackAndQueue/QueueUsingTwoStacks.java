package leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingTwoStacks {
	private Deque<Integer> stack1;    // back of queue
	private Deque<Integer> stack2;    // front of queue

	// create an empty queue
	public QueueUsingTwoStacks() {
		stack1 = new ArrayDeque<Integer>();
		stack2 = new ArrayDeque<Integer>();
	}

	// move all items from stack1 to stack2
	private void moveStack1ToStack2() {
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
	}

	// is the queue empty?
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}


	// return the number of items in the queue.
	public int size() {
		return stack1.size() + stack2.size();     
	}

	// return the item least recently added to the queue.
	public Integer peek() {
		if (stack2.isEmpty()) 
			moveStack1ToStack2();
		return stack2.peek();
	}

	// add the item to the queue
	public void enqueue(Integer item) {
		stack1.push(item);
	}

	// remove and return the item on the queue least recently added
	public Integer dequeue() {
		if (stack2.isEmpty()) 
			moveStack1ToStack2();
		return stack2.pop();
	}

}
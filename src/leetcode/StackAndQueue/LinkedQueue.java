package leetcode.StackAndQueue;

import java.util.NoSuchElementException;

/**
 * An implementation of a queue using singly linked nodes.  The
 * queue itself maintains links to both the head and the tail
 * node, so that both enqueuing and dequeueing are O(1).
 */
public class LinkedQueue<T> {
	private class Node {
		private T data;
		private Node next;

		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	// Constructs a new empty queue.
	public LinkedQueue() {
		head = null;
		tail = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void enqueue(T item) {
		Node newNode = new Node(item);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
		}
		tail = newNode;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T item = head.data;
		if (tail == head) {
			tail = null;
		}
		head = head.next;
		return item;
	}

	public Object peek() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return head.data;
	}

	public int size() {
		return size;
	}
}

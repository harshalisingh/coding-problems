package leetcode.StackAndQueue;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> {
	// Each Node object stores a single element of data in the linked list and
	// a link to another (possibly null) Node for the next piece of data.
	private class Node {
		private T data;
		private Node next;

		// Constructs a new node to store the given data value.
		public Node(T data) {
			this.data = data;
		}
	}

	private Node top;   // null when list empty
	private int size;

	// Constructs a new empty stack.
	public LinkedStack() {
		top = null;
		size = 0;
	}

	// Returns true if the stack does not contain any elements.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns an Iterator to traverse the elements of this stack.
	public Iterator<T> iterator() {
		return new LinkedStackIterator();
	}

	// Returns the top element of this stack without removing it.
	// Throws an EmptyStackException if the stack is empty.
	public T peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	// Removes and returns the top element of this stack.
	// Throws an EmptyStackException if the stack is empty.
	public T pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;
		size--;
		return item;
	}

	// Adds the given value to the top of this stack.
	public void push(T value) {
		Node newNode = new Node(value);
		newNode.next = top;
		top = newNode;
		size++;
	}

	// Returns the number of elements contained in this stack.
	public int size() {
		return size;
	}

	// Returns a string representation of the stack, such as "bottom a b c top".
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = top	;
		while (current != null) {
			sb.append(current.data).append(", ");
			current = current.next;
		}
		return sb.toString();
	}



	// An iterator class to traverse the elements of this stack
	// from top to bottom.
	private class LinkedStackIterator implements Iterator<T> {
		private Node position;   // current position in list

		// Constructs an iterator at the beginning (top) of this stack.
		public LinkedStackIterator() {
			position = top;
		}

		// Returns true if there are any more elements for this iterator to return.
		public boolean hasNext() {
			return position != null;
		}

		// Returns the next element from the stack and advances iterator by one slot.
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T result = position.data;
			position = position.next;
			return result;
		}

		// Not implemented.
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}


}
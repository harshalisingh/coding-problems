package leetcode.Design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*
 * First hold the 2D List inside a Iterator of List as this allows to operate on the subsequent list once needed. 
 * 
 */
public class Flatten2DVector {
	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;

	public Flatten2DVector(List<List<Integer>> vec2d) {
		i = vec2d.iterator();
	}

	public int next() {
		hasNext();
		return j.next();
	}

	public boolean hasNext() {
		while ((j == null || !j.hasNext()) && i.hasNext())
			j = i.next().iterator();
		return j != null && j.hasNext();
	}
}

class Vector2D implements Iterator<Integer> {

	private final Iterator<List<Integer>> listIterator;
	private Iterator<Integer> sublistIterator;

	public Vector2D(List<List<Integer>> vec2d) {
		listIterator = vec2d.iterator();
		advanceListIterator();
	}

	private void advanceListIterator() {
		while (listIterator.hasNext()) {
			sublistIterator = listIterator.next().iterator();
			if (sublistIterator.hasNext()) {
				break;
			}
		}
	}

	@Override
	public Integer next() {
		if (!hasNext()) {
			throw new java.util.NoSuchElementException();
		}
		Integer ret = sublistIterator.next();
		if (!sublistIterator.hasNext()) {
			advanceListIterator();
		}
		return ret;
	}

	@Override
	public boolean hasNext() {
		return sublistIterator != null && sublistIterator.hasNext();
	}
}

class Vector2DUsingQueue {
    
    Queue<Iterator<Integer>> queue;
    Iterator<Integer> current = null;
    
    public Vector2DUsingQueue(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for (int i = 0; i < vec2d.size(); i++){
            queue.add(vec2d.get(i).iterator());
        }
        current = queue.poll(); // first
    }

    public int next() {
        if (!current.hasNext()) return -1;
        
        return current.next();
    }

    public boolean hasNext() {
        if (current == null) return false;
        
        while (!current.hasNext()) {
            if (!queue.isEmpty()) {
                current = queue.poll();
            } else return false;
        }
        
        return true;
    }
}

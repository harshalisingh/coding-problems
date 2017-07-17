package leetcode.Design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

class NestedInteger{
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger(){
		return false;	
	}
	
	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger(){
		return null;
		
	}
	
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList(){
		return null;
		
	}	
	
}

public class NestedListIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();
    public NestedListIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            curr = stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}

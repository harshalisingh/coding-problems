package leetcode.StackAndQueue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ReverseStack {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        reverseStack(stack);
        printStack(stack);
    }
    public static <T> void reverseStack(Deque<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Remove bottom element from stack
        T bottom = popBottom(stack);
        
        // Reverse everything else in stack
        reverseStack(stack);
        
        // Add original bottom element to top of stack
        stack.push(bottom);
    }
    private static <T> T popBottom(Deque<T> stack) {
        T top = stack.pop();
        if (stack.isEmpty()) {
            // If we removed the last element, return it
            return top;
        } else {
            // We didn't remove the last element, so remove the last element from what remains
            T bottom = popBottom(stack);
            // Since the element we removed in this function call isn't the bottom element, add it back onto the top of the stack where it came from
            stack.push(top);
            return bottom;
        }
    }
    
    private static <T> void printStack(Deque<T> stack){
    	System.out.println(Arrays.toString(stack.toArray()));
    }
}

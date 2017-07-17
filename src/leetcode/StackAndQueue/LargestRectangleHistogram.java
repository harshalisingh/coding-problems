package leetcode.StackAndQueue;

import java.util.Stack;

public class LargestRectangleHistogram {
	/* Then we can solve the problem recursively:
	 * Find the minimum height in [l, r), and compute an area as min*(l-r);
	 * Use the minimum to split the array into two parts and recursively find the max area in each of them;
	 * The final result is the maximum the above three results.
	 * This algorithm runs in time O(n^2). But it requires O(n^2) spaces since it is using recursion.
	 */
	public int largestRectangleAreaRecursion(int[] height) {  
		return largestRect(height, 0, height.length);  
	} 
	private int largestRect(int[] height, int l, int r) {  
		if (l>=r) return 0;  
		int min = height[l], minId = l;  
		// find the min and its index  
		for (int i=l+1; i<r; ++i) {  
			if (height[i] < min) {  
				min = height[i];  
				minId = i;  
			}  
		}  
		return Math.max(min*(r-l),  
				Math.max(largestRect(height, l, minId), largestRect(height, minId+1, r)));  
	}  

	public int largestRectangleAreaTwoStacks(int[] height) {  
		int area = 0;  
		// stack to store the indices of left boundary  
		// left boundary is the last height that is not lower than the current one  
		Stack<Integer> left = new Stack<Integer>();  
		Stack<Integer> index = new Stack<Integer>();  
		int cur = 0;  
		while (cur < height.length) {  
			if (cur == 0 || height[cur] > height[index.peek()]) {  
				left.push(cur);  
				index.push(cur);  
			} else if (height[cur] < height[index.peek()]) {  
				int last;  
				do {  
					last = left.pop();  
					area = Math.max(area, height[index.pop()] * (cur - last));  
				} while (!left.isEmpty() && height[cur] < height[index.peek()]);  
				left.push(last);  
				index.push(cur);  
			}  
			cur++;  
		}  
		// pop out values in index and left and calculate their areas  
		while (!index.isEmpty() && !left.isEmpty()) {  
			area = Math.max(area, height[index.pop()] * (height.length - left.pop()));  
		}
		return area;  
	}

	public int largestRectangleArea(int[] height) {  
		Stack<Integer> left = new Stack<Integer>();  
		int cur = 0, area = 0;  
		while (cur < height.length) {  
			if (left.isEmpty() || height[cur] >= height[left.peek()]) {  
				// push to stack if we hit a greater or equal height  
				left.push(cur++);  
			} else {  
				int top = left.pop();  
				// the height at left.peek() must be smaller than the current one  
				// so, the width of the rectangle is [left.peek()+1, cur)  
				area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));  
			}  
		}  
		while (!left.isEmpty()) {  
			int top = left.pop();  
			area = Math.max(area, height[top]*(left.isEmpty() ? cur : (cur-left.peek()-1)));  
		}  
		return area;  
	}  

	public static void main(String[] args){
		LargestRectangleHistogram lrh = new LargestRectangleHistogram();
		int[] height = new int[] {2,1,5,6,2,3};
		lrh.largestRectangleAreaTwoStacks(height);
	}
}

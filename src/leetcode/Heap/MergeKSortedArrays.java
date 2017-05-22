package leetcode.Heap;

import java.util.PriorityQueue;
import java.util.Comparator;

/* https://www.youtube.com/watch?v=6bvnZzwiKzs
 * Time Complexity : O(nlogk)
 * Space Complexity: O(k) beyond the space needed to write the final result
 * */
class ArrayNode {
    int array, index, value;
	 
    public ArrayNode(int array, int index, int value) {
        this.array = array;
        this.index = index;
        this.value = value;
    }
}
public class MergeKSortedArrays {
 
	public static int[] merge(int[][] arrays) {
		
		if(arrays.length == 0){
			return new int[0];
		}
	    PriorityQueue<ArrayNode> pq = new PriorityQueue<ArrayNode>(new Comparator<ArrayNode>(){
	    	public int compare(ArrayNode a, ArrayNode b){
	    		return a.value - b.value;
	    	}
	    });
	 
	    //Adding first elements of each array
	    int size = 0;
	    for (int i = 0; i < arrays.length; i++) {
	        size += arrays[i].length;
	        if (arrays[i].length > 0) {
	            pq.add(new ArrayNode(i, 0, arrays[i][0]));
	        }
	    }
	 
	    int[] result = new int[size];
	    for (int i = 0; !pq.isEmpty(); i++) {
	        ArrayNode n = pq.poll();
	        result[i] = n.value;
	        int newIndex = n.index + 1;
	        if (newIndex < arrays[n.array].length) {
	            pq.add(new ArrayNode(n.array, newIndex, 
	            arrays[n.array][newIndex]));
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args){
		int[][] arrays = new int[][] {
			{1, 3, 5},
			{2, 6, 10},
			{4, 5}
		};
		int[] output = merge(arrays);
		for(int i : output){
			System.out.print(i + ",");
		}
	}
}

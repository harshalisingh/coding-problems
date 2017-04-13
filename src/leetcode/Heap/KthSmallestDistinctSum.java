package leetcode.Heap;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class KthSmallestDistinctSum {
	public static class Pair{
        int x,y, sum;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.sum = val;
        }
    }
   
    public static int kthSmallestDistinctSum(int[] A, int[] B, int k) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || k < 0) {
            return -1;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.sum - p2.sum;
            }
        });
        HashSet<Integer> set = new HashSet<Integer>();
        List<Pair> list = new ArrayList<>();
        Pair min = new Pair(0, 0, A[0] + B[0]);
        queue.offer(min);
        set.add(min.sum);

        for (int i = 0; i < k; i++) {
            min = queue.poll();
            
            list.add(min);

            if (min.x + 1 < A.length) {
                Pair newP = new Pair(min.x + 1, min.y, A[min.x + 1] + B[min.y]);
                if (!set.contains(newP.sum)) {
                    set.add(newP.sum);
                    queue.offer(newP);
                }
            }
            if (min.y + 1 < B.length) {
                Pair newP = new Pair(min.x, min.y + 1, A[min.x] + B[min.y + 1]);
                if (!set.contains(newP.sum)) {
                    set.add(newP.sum);
                    queue.offer(newP);
                }
            }
        }
 
        min = queue.poll();
        list.add(min);
        
        for(Pair p : list){
        	System.out.println(A[p.x] + ":" + B[p.y] + "=" + p.sum);
        }
        return min.sum;
    }
    
    public static void main(String[] args){
		int A[] = {1, 2, 4, 6};
		int B[] = {2, 3, 6};
		System.out.println(kthSmallestDistinctSum(A, B, 3));
	}

}
